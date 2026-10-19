/*
Luca Bisognin - 19/10/2026
Esercizio Lezione del 19/10/2026
*/

import java.util.*;

public class ListaNatale {
	public static void main(String[] args) {
		// init istanze //
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> listaNatale = new ArrayList<>();
		
		// aggiunta invitati alla lista di natale //
		String nuovoInvitato;
		while (true) {
			System.out.print("Stringa: ");
			nuovoInvitato = scanner.nextLine();
		
			if (nuovoInvitato.toLowerCase().equals("stop")) break;
			
			listaNatale.add(nuovoInvitato);
		}
		
		// controlli sull'arraylist //
		boolean isAlan = false;
		
		listaNatale.removeIf(grinch -> grinch.equalsIgnoreCase("grinch")); // rimozione del 1° "Grinch"
		for (String s : listaNatale) {
			if (s.toLowerCase().equals("alan")) isAlan = true;
		}
		
		if (!isAlan) listaNatale.add("Alan"); // aggiunta di Alan se non è il lista
		
		// stampa lista in ordine inverso //
		System.out.println("\nLista Invertita: ");
		Collections.reverse(listaNatale); // inversione arraylist
		for (String invitato : listaNatale) {
			System.out.println(invitato);
		}
		
		scanner.close();
	}
}