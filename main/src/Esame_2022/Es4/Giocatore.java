/*
Luca Bisognin - 6/10/2026
Classe Giocatore per creare e gestire l'istanza di un calciatore
*/

package Esame_2022.Es4;

public class Giocatore {
	// attributi //
	private String nome;
	private Ruolo ruolo;
	
	// costruttore //
	public Giocatore(String nome, String ruolo) {
		this.nome = nome;
		this.ruolo = 
		switch(ruolo) {
			case "p" -> Ruolo.POR;
			case "d" -> Ruolo.DIF;
			case "c" -> Ruolo.CEN;
			case "a" -> Ruolo.ATT;
            default -> throw new IllegalStateException("Unexpected value: " + ruolo);
        };
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
		};
	}
	
	// setters //
	public void setNome(String nome) {
		this.nome= nome;
	}
	
	public void setRuolo(String r) {
		this.ruolo = 
		switch(r) {
			case "p" -> Ruolo.POR;
			case "d" -> Ruolo.DIF;
			case "c" -> Ruolo.CEN;
			case "a" -> Ruolo.ATT;
            default -> throw new IllegalStateException("Unexpected value: " + r);
        };
	}
	
	// metodo per restituire le info giocatore //
	@Override
	public String toString() {
		return this.getRuolo() + " " + this.nome;
	}
}