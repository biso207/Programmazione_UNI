package EsameParziale2023.soluzioniTutor;

import java.util.Scanner;
import java.util.ArrayList;

public class Esercizio1b {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		ArrayList<String> a = new ArrayList<String>();
		
		// Input Stringhe
		System.out.println("Fornire stringhe: ");
		
		String oldString = "";
		do {
			String input = scan.nextLine();
			
			if (input.length() < oldString.length())
				break;
			
			oldString = input;
			
			char firstChar = input.charAt(0);
			if (firstChar >= '0' && firstChar <= '9')
				a.add(input);
			
		} while(true);
		
		// Somma lunghezze elementi array
		int somma = 0;
		for (String e : a)
			somma += e.length();
		
		// Calcolo media e stampo risultato
		float media = ((float) somma) / a.size();
		System.out.println(media);
	}
}