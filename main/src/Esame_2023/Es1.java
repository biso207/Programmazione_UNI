package Esame_2023;

import java.util.*;

public class Es1 {
	public static void main(String[] args) {
		// dichiarazione variabili e istanze
		Scanner scanner = new Scanner(System.in);
		Random r = new Random();
		List<Integer> lista = new ArrayList<>();
		int num;
		
		// while per l'inserimento dei numeri nell'arraylist
		while (true) {
			System.out.print("Inserisci un numero (minore di 0 per fermarti): ");
			try {
				num = scanner.nextInt();
				if (num<0) break;
			} 
			catch (Exception e) {
				scanner.next();
				System.out.println("Hai inserito un valore non permesso.");
				num = r.nextInt(10);
				System.out.println("È stato inserito il numero " + num);
			}
			
			lista.add(num);
		}
		
		// while per la stampa secondo i requisiti
		int index=0;
		while (true) {
			int valore = lista.get(index);
			System.out.println(valore);
			
			if (valore>=lista.size() || valore==index) break;
			
			index=valore;
		}
		
		scanner.close();
	}
}