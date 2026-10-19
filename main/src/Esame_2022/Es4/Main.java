/*
Luca Bisognin - 6/10/2026
Classe Main per l'entrata del programma
*/

package Esame_2022.Es4;

import java.util.*;

public class Main {

	static void main() {
		// init classi
		Scanner scanner = new Scanner(System.in);
		QatarTop10 qatarTop10 = new QatarTop10();

		int input = 0;

		System.out.println(
				"Benvenuto nella classifica dei migliori 10 goal del Mondiale Qatar 2022"
		);

		// il menu viene ripetuto fino alla scelta di uscita (-1).
		while (input != -1) {

			System.out.println(
					"\nCosa vuoi fare?" +
							"\n[0] Cerca un goal per posizione" +
							"\n[1] Aggiungi un goal" +
							"\n[2] Stampa la Top 10" +
							"\n[3] Riepilogo goal per ruolo" +
							"\n[-1] Esci"
			);

			input = scanner.nextInt();
			scanner.nextLine();

			// esegue l'operazione scelta dall'utente.
			switch (input) {
				case 0 -> printAtIndex(scanner, qatarTop10);
				case 1 -> addToScore(scanner, qatarTop10);
				case 2 -> qatarTop10.printTop10();
				case 3 -> qatarTop10.printScore();
				case -1 -> System.out.println("Ciao!");
				default -> System.out.println("Input non permesso.");
			}
		}

		scanner.close();
	}

	// cerca e stampa il goal presente nella posizione richiesta.
	private static void printAtIndex(
			Scanner scanner,
			QatarTop10 qatarTop10
	) {
		System.out.print("Quale posizione vuoi esplorare? ");

		int index = scanner.nextInt();
		scanner.nextLine();

		Goal g = qatarTop10.getAtIndex(index);

		// se getAtIndex restituisce null, la posizione non è valida oppure non contiene alcun goal.
		if (g == null) {
			System.out.println("Nessun goal presente in questa posizione.");
		} else {
			System.out.println("Posizione " + index + ": " + g);
		}
	}

	// legge i dati di un goal e prova a inserirlo nella Top 10.
	private static void addToScore(
			Scanner scanner,
			QatarTop10 qatarTop10
	) {
		System.out.print("Nome del calciatore: ");
		String nome = scanner.nextLine();

		System.out.print(
				"Ruolo (p = portiere, d = difensore, c = centrocampista, a = attaccante): "
		);
		String ruolo = scanner.nextLine().toLowerCase();

		System.out.print("Numero di voti: ");
		int voti = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Descrizione del goal: ");
		String descrizione = scanner.nextLine();

		// crea il giocatore e il goal, quindi prova a inserirlo.
		try {
			Giocatore giocatore = new Giocatore(nome, ruolo);
			Goal goal = new Goal(giocatore, voti, descrizione);

			int posizione = qatarTop10.addToScore(goal);

			// un valore -1 indica che il goal non entra nella Top 10.
			if (posizione == -1) {
				System.out.println("Il goal non entra nella Top 10.");
			} else {
				System.out.println(
						"Goal inserito in posizione " + posizione + "."
				);
			}

		} catch (IllegalStateException e) {
			// gestisce un ruolo non riconosciuto dal costruttore.
			System.out.println("Ruolo non valido.");
		}
	}
}
