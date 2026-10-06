/*
Luca Bisognin - 6/10/2026
Classe QatarTop10 per creare e gestire la classifica dei migliori gol del mondiale 2022
*/

import java.util.*;

public class QatarTop10 implements Scoreboard {
	private List<Goal> goalList;
	
	// costruttore //
	public QatarTop10() {
		goalList = new ArrayList<Goal>();
	}
	
	// metodi //	
	@Override
	public void addToScore(Goal g) {
		goalList.add(g);
	}
	
	@Override
	public void printScore() {
		for (Goal g : goalList) {
			System.out.println(g.getIndex()+1 + ") " + g);
		}
	}
	
	@Override
	public void printTop10() {}
	
	@Override
	public void printAtIndex(int index) {
		if (index > 0) index--; // decremento per avere il range 0-9
		for (Goal g : goalList) {	
			if (index <= 0) break;
			if (g.getIndex() == index) {
				System.out.println("Posizione " + index + ") " + g);
				return;
			}
		}
		
		System.out.println("Nessun giocatore per la posizione " + index);
		return null;
	}
}