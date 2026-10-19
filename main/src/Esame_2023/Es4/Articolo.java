package Esame_2023.Es4;

public class Articolo {
	// attributi //
	private final String ID;
	private double price;
	
	// costruttore //
	public Articolo(String ID, double price) {
		this.ID = ID;
		this.price = price;
	}
	
	// getters //
	public String getID() {
		return id;
	}
	
	public double getPrice() {
		return price;
	}
	
	// setters //
	public void setPrice(double price) {
		this.price = price;
	}
	
	// l'ID è univoco non modificabile in seguito
}