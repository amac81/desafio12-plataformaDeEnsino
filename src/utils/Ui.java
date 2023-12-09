package utils;

import java.util.Scanner;


/*
 * Classe utilitaria de User Interface (Ui)
 * 
 * */
public class Ui {
	
	/**
	 * pede ao utilizador um número, valida-o e retorna-o
	 * 
	 * @param askMessage - String com o texto a apresentar ao utilizador
	 * @param scanner - objeto Scanner para entrada de dados, a partir de System.in
	 * @param minValue - valor inteiro minimo necessario para input
	 * @param maxValue - valor inteiro maximo necessario para input
	 * @return número inteiro
	 */
	public static int askAndValidateIntInput(String askMessage, Scanner scanner, int minValue, int maxValue) {
		int value = 0;
		boolean askAgain = true;
		
		System.out.print(askMessage);
		while(askAgain) 
		{
			if (scanner.hasNextInt()) 
			{
				value = scanner.nextInt();
				if(value < minValue || value > maxValue) {
					System.out.println("Introduza um número >= " + minValue + " e <= " + maxValue + ".");
					askAgain = true;
				}
				else {
					askAgain = false;
					//consumir quebra de linha
					scanner.nextLine();				
					break;
				}
			} 
			else {
				System.out.println("Número inválido! Introduza novamente.");
				scanner.next();
				askAgain = true;
			}
		}
		
		return value;
	}
	
	public static char askAndValidateCharInput(String askMessage, Scanner scanner, char[]options) {
		
		char option = 0;
		
		
		if(options!=null) {
			boolean notValid = false;
			int nOptions = options.length;
			
			System.out.print(askMessage);
			do {
				option = scanner.next().charAt(0);
				
				//percorrer todo o array
				
				for(int i=0; i<nOptions; i++) {
					if(options[i] == option)
					{
						//consumir quebra de linha
						scanner.nextLine();	
						return option;
					}
					else {
						notValid = true;
					}
				}
			
				if(notValid) {
					System.out.print("Valor invalido! Favor digitar um destes caracteres (");
					for(int i=0; i<nOptions; i++) {
						System.out.print(options[i]);
						
						if(i<nOptions-1) {
							System.out.print(",");
						}
					}
					System.out.print("): ");
				}	
				
			} while(notValid);
		}
		
		return 0;
	}

}
