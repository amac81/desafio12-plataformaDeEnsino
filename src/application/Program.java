/**
* Este programa ...
* 
* @author  Arnaldo Canelas
* @version 1.0
* @since   2023-12-07 
*/

package application;

import java.util.Locale;
import java.util.Scanner;

import utils.Ui;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		//Objeto Scanner para entrada de dados, a partir de System.in 
		Scanner sc = new Scanner(System.in);
		
		//Variaveis
		int nAulas = 0; 
		int reps = 0;

		nAulas = Ui.askAndValidateIntInput("Quantas aulas tem o curso? ", sc, 1, 999);
		System.out.println();		
		
		do {
			System.out.println("Dados da " + (reps+1) + "a aula: ");
			
			char[] options = {'c','t'};
			
			char tipoAula = Ui.askAndValidateCharInput("Conteúdo ou tarefa (c/t)? ", sc, options);
			
			
			reps ++;
		} while(reps < nAulas);
		
		//polimorfismo e upcasting
		/*Lesson lessonTask = new Task();
		Lesson lessonVideo = new Video();
		
		
		if(lessonTask instanceof Task) {
			System.out.println("Quantidade de questões: " + lessonTask.duration());
		}	
		
		if(lessonVideo instanceof Video) {
			System.out.println("Duração em segundos: " + lessonVideo.duration());
		}
		*/
		
		sc.close();
	}
}
