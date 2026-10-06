/*
Luca Bisognin - 6/10/2026
Classe Giocatore per creare e gestire l'istanza di un calciatore
*/

public class Giocatore {
	// attributi //
	private String nome;
	private Ruolo r;
	
	// costruttore //
	public Giocatore(String nome, String ruolo) {
		this.nome = nome;
		this.ruolo = 
		switch(ruolo) {
			case "p" -> Ruolo.POR;
			case "d" -> Ruolo.DIF;
			case "c" -> Ruolo.CEN;
			case "a" -> Ruolo.ATT;
		}
	}
	
	// getters //
	public String getNome() {
		return this.nome;
	}
	
	public String getRuolo() {
		return switch(this.ruolo) {
			case POR -> "Portiere";
			case DIF -> "Difensore";
			case CEN -> "Centrocampista";
			case ATT -> "Attaccante";
		}
	}
	
	// setters //
	public void setNome(String nome) {
		this.nome= nome);
	}
	
	public void setRuolo(String r) {
		this.ruolo = 
		switch(r) {
			case "p" -> Ruolo.POR;
			case "d" -> Ruolo.DIF;
			case "c" -> Ruolo.CEN;
			case "a" -> Ruolo.ATT;
		}
	}
	
	// metodo per restituire le info giocatore //
	@Override
	public String toString() {
		String r = this.getRuolo();
		return r " " + this.nome;
	}
}