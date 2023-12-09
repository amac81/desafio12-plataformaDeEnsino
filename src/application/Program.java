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

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		//Objeto Scanner para entrada de dados, a partir de System.in 
		Scanner sc = new Scanner(System.in);

		System.out.println("hello!!!");
		
		
		//polimorfismo
		Lesson lessonTask = new Task();
		Lesson lessonVideo = new Video();
		
		if(lessonTask instanceof Task) {
			System.out.println("Quantidade de questões: " + lessonTask.duration());
		}	
		
		if(lessonVideo instanceof Video) {
			System.out.println("Duração em segundos: " + lessonVideo.duration());
		}
		
		sc.close();
	}
}
