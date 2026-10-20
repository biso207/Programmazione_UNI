/*
Luca Bisognin - 19/10/2026
Esercizio Lezione del 19/10/2026
*/

package Esercizi.Liste;

import java.util.*;

public class ListaNatale {
	static void main() {
		// init istanze //
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> listaNatale = new ArrayList<>();
		
		// aggiunta invitati alla lista di natale //
		String nuovoInvitato;
		while (true) {
			System.out.print("Stringa: ");
			nuovoInvitato = scanner.nextLine();
		
			if (nuovoInvitato.equalsIgnoreCase("stop")) break;
			
			listaNatale.add(nuovoInvitato);
		}

		//listaNatale.removeIf(grinch -> grinch.equalsIgnoreCase("grinch")); // rimozione di ogni 'Grinch'

		// rimozione primo 'Grinch' dalla lista //
		for (int i=0; i<listaNatale.size(); i++) {
			if (listaNatale.get(i).equalsIgnoreCase("grinch")) {
				listaNatale.remove(i);
				break;
			}
		}

		// aggiunta 'Alan' se non in lista
		boolean isAlan = false;

		for (String s : listaNatale) {
            if (s.equalsIgnoreCase("alan")) {
                isAlan = true;
                break;
            }
		}
		
		if (!isAlan) listaNatale.add("Alan");
		
		// stampa lista in ordine inverso //
		System.out.println("\nLista Invertita: ");
		Collections.reverse(listaNatale); // inversione arraylist
		for (String invitato : listaNatale) {
			System.out.println(invitato);
		}
		
		scanner.close();
	}
}