/**
* Este programa implementa uma plataforma de ensino
* Os conteudos podem ser na forma de vídeo ou tarefa
* 
* É pedido ao utilizador dados sobre os N conteudos do curso (inclusive a duracao do conteúdo)
* 
* no final é apresentado um relatório com a duração total, sem segundos, de todos os conteúdos do curso
* 
* @author  Arnaldo Canelas
* @version 1.0
* @since   2023-12-07 
*/

package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;
import utils.Ui;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		//Objeto Scanner para entrada de dados, a partir de System.in 
		Scanner sc = new Scanner(System.in);
		
		//Variaveis
		int nLessons = 0; 
		int reps = 0;

		//lista de Lesson
		List <Lesson> lessons = new ArrayList<Lesson>();
		
		nLessons = Ui.askAndValidateIntInput("Quantas aulas tem o curso? ", sc, 1, 999);
		System.out.println();		
		
		do {
			System.out.println("Dados da " + (reps+1) + "a aula: ");
			
			char[] lessonTypes = {'c','t'};
			
			char lessonType = Ui.askAndValidateCharInput("Conteúdo ou tarefa (c/t)? ", sc, lessonTypes);
			
			System.out.print("Título: ");
			String title = sc.nextLine();
			
			Lesson lesson = null;
			
			if(lessonType =='c') {
				System.out.print("URL do vídeo: ");
				String url = sc.nextLine();
				int duration = Ui.askAndValidateIntInput("Duração em segundos: ", sc, 1, 9999);
				
				//instanciacao de um Video;
				lesson = new Video(title, url, duration);
			}
			else{
				System.out.print("Descrição: ");
				String description = sc.nextLine();
				int nQuestions = Ui.askAndValidateIntInput("Quantidade de questões: ", sc, 1, 999);
				
				//instanciacao de uma Task;
				lesson = new Task(title, description, nQuestions);
			}
			
			lessons.add(lesson);			
			
			if(nLessons>1) {
				System.out.println();		
			}
			
			reps ++;
		} while(reps < nLessons);
		
		
		showReport(lessons);
		
		sc.close();
	}
	
	private static void showReport(List<Lesson> lessons) {
		int totalDuration = 0;
		
		if(lessons != null) {
			for(Lesson l: lessons) {
				
				//duração de uma aula tarefa = 5 minutos por questão
				//secs = min×60 
	
				totalDuration += (l instanceof Video) ? l.duration(): l.duration() * (5 * 60);
				
			}
		}
		
		System.out.println("DURAÇÃO TOTAL DO CURSO = " + totalDuration + " segundos");
	}
	
}
