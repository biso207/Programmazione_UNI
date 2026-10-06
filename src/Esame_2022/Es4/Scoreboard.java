/*
Luca Bisognin - 6/10/2026
Interfaccia per definire i metodi per la gestione di una classifica
*/

public interface Scoreboard {
	void addToScore(); // method to add a value to the scoreboard
	void printScore(); // method to print the whole scoreboard
	void printTop10(); // method to print the top ten
	void printAtIndex(int index); // method to print the value at a specific index
}