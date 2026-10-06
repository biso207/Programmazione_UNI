/*
Luca Bisognin - 6/10/2026
Classe Main per l'entrata del programma
*/

import java.util.*;

public class Main() {
	public void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		QatarTop10 qatarTop10 = new QatarTop10();
		
		System.out.println("Benvenuto nella classifica dei migliori 10 goal del Mondiale Qatar 2022");
		System.out.println(printChoice());
		
		int input=0;
		while (input != -1) {
			input = scanner.nextInt();
			
			switch (input) {
				case 0 -> printAtIndex(scanner);
				case 1 -> addToScore(scanner);
				case 2 -> printTop10();
				case -1 -> break;
				default -> System.out.println("Input non permesso");
			}
			
			printChoice();
		}
		
		System.out.println("Ciao");
		
		scanner.close();
	}
	
	public String printChoice() {
		return "Cosa vuoi fare?\n[0] Stampa Gol in posizione X\n[1] Aggiungi gol in classifica\n [2] Stampa Top 10\n [-1] Chiudi tutto";
	}
	
	// metodo per stampare un goal ad una determinata posizione //
	private void printAtIndex(Scanner s) {
		System.out.println("- Quale posizione vuoi esplorare?");
		
		System.out.print("Posizione: ");
		int index = s.nextInt();
		
		qatarTop10.printAtIndex(index);
	}
	
	// metodo per aggiungere un goal alla classifica //
	private void addToScore(Scanner s) { 
		
	}
	
	// metodo per stampare la top 10 //
	private void printTop10() {
	}
}