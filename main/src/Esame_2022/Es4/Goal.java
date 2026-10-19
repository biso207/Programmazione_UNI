/*
Luca Bisognin - 6/10/2026
Classe Gol per creare e gestire istanze di un gol segnato
*/

package Esame_2022.Es4;

public class Goal {
	// attributi //
	private Giocatore giocatore;
	private int numVoti;
	private String des;
	
	// costruttore //
	public Goal(Giocatore g, int numVoti, String des) {
		giocatore = g;
		this.numVoti = numVoti;
		this.des = des;
	}
	
	// getters //
	public Giocatore getGiocatore() {
		return giocatore;              
	}
	
	public int getNumVoti() {
		return numVoti;
	}
	
	public String getDes() {
		return des;
	}
	
	
	// setters //
	public void setGiocatore(Giocatore g) {
		giocatore = g;
	}
	
	public void setNumVoti(int numVoti) {
		this.numVoti = numVoti;
	}
	
	public void setDes(String des) {
		this.des = des;
	}
	
	// metodo per restituire info di un gol //
	@Override
	public String toString() {
		return "Gol segnato da " + giocatore + ", ha ricevuto " + numVoti + "\nDescrizione:" + des;
	}
}