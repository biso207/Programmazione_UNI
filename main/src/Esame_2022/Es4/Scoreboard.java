/*
Luca Bisognin - 6/10/2026
Interfaccia per definire i metodi per la gestione di una classifica
*/

package Esame_2022.Es4;

public interface Scoreboard {

	// aggiunge un goal alla classifica e restituisce la posizione ottenuta.
	int addToScore(Goal g);

	// restituisce il goal presente nella posizione indicata, oppure null se la posizione non è valida o è vuota.
	Goal getAtIndex(int index);

	// stampa i goal presenti nella Top 10.
	void printTop10();

	// stampa il riepilogo dei goal suddivisi per ruolo.
	void printScore();
}
