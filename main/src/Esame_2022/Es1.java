package Esame_2022;

import java.util.*;

public class Es1 {
	static void main() {
		 // lista per le stringhe
		ArrayList<String> arrayStringhe = new ArrayList<String>();
		// hashmap per mappare stringa e il suo numero di vocali
		HashMap<String, Integer> mapStringVocals = new HashMap<>();
		
		String s = new String();
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Digita stringhe, se la lunghezza è maggiore di 10 si ferma!\n");
		
		// lettura stringhe da tastiera fino alla prima stringa con lunghezza maggiore di 10
		while(true) {
			System.out.print("Digita una stringa: ");
			s = scanner.nextLine();
			
			if (s.length() >= 10) break;
			
			arrayStringhe.add(s);
		}
		
		int cont = 0; // contatore vocali singola stringa
		int numVocali = 0; // numero totale di vocali in tutte le stringhe
		
		for (String string : arrayStringhe) {
			string = string.toLowerCase();
			
			// ciclo for per conteggio vocali nella singola stringa
			for (int i=0; i<string.length(); i++) {
				char c = string.charAt(i);
				
				if (c=='a' || c=='e' || c=='i' || c=='o' || c=='u' ) cont++;
			}
			mapStringVocals.put(string, cont);
			numVocali += cont;
			
			cont=0;
		}
		
		// media vocali
		double media = numVocali/arrayStringhe.size();
		
		System.out.println("Media di vocali tra tutte le stringhe che hai inserito: " + media);
		
		System.out.println("\nEcco tutte le stringhe con numero di vocali oltre la media");
		for (Map.Entry<String, Integer> entry : mapStringVocals.entrySet()) {
			if (entry.getValue() > media) System.out.println(entry.getKey());
		}
		
		scanner.close();
	}
}