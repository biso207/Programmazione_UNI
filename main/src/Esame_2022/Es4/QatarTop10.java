/*
Luca Bisognin - 6/10/2026
Classe QatarTop10 per creare e gestire la classifica dei migliori gol del mondiale 2022
*/

package Esame_2022.Es4;

import java.util.*;

public class QatarTop10 implements Scoreboard {

	// lista dei goal ordinata per numero di voti decrescente
	private final List<Goal> goalList;

	// inizializza una classifica vuota.
	public QatarTop10() {
		goalList = new ArrayList<>(10); // la lista può contenere al massimo 10 elementi.
	}

	@Override
	public int addToScore(Goal g) {

		// se la Top 10 è piena e il goal non supera l'ultimo, non viene inserito.
		if (goalList.size() == 10 &&
				g.getNumVoti() <= goalList.get(9).getNumVoti()) {
			return -1;
		}

		// cerca la posizione corretta mantenendo l'ordine decrescente in base ai voti.
		int index = 0;

		while (index < goalList.size() &&
				goalList.get(index).getNumVoti() >= g.getNumVoti()) {
			index++;
		}

		// inserisce il goal nella posizione individuata.
		goalList.add(index, g);

		// se gli elementi diventano più di 10, elimina quello in ultima posizione.
		if (goalList.size() > 10) {
			goalList.remove(10);
		}

		// le posizioni mostrate all'utente partono da 1.
		return index + 1;
	}

	@Override
	public Goal getAtIndex(int index) {

		// controlla che la posizione sia valida e che esista un goal in quella posizione.
		if (index < 1 || index > 10 || index > goalList.size()) {
			return null;
		}

		return goalList.get(index - 1);
	}

	@Override
	public void printTop10() {

		// gestisce il caso in cui non ci siano goal.
		if (goalList.isEmpty()) {
			System.out.println("La classifica è vuota.");
			return;
		}

		// stampa tutti i goal in ordine di classifica.
		for (int i = 0; i < goalList.size(); i++) {
			System.out.println((i + 1) + ") " + goalList.get(i));
		}
	}

	@Override
	public void printScore() {

		// contatori dei goal per ruolo.
		int portieri = 0;
		int difensori = 0;
		int centrocampisti = 0;
		int attaccanti = 0;

		// analizza i goal presenti nella Top 10 e incrementa il contatore del ruolo corrispondente.
		for (Goal g : goalList) {
			switch (g.getGiocatore().getRuolo()) {
				case "Portiere" -> portieri++;
				case "Difensore" -> difensori++;
				case "Centrocampista" -> centrocampisti++;
				case "Attaccante" -> attaccanti++;
			}
		}

		// stampa il riepilogo dei goal per ruolo.
		System.out.println("Goal per ruolo:");
		System.out.println("Portieri: " + portieri);
		System.out.println("Difensori: " + difensori);
		System.out.println("Centrocampisti: " + centrocampisti);
		System.out.println("Attaccanti: " + attaccanti);
	}
}
