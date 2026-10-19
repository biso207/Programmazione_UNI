package Esame_2023.Es4;

import java.util.*;

public class Item {
	// attributi //
	private final String ID;
	private double price;
	private int sconto;
	private ItemType type;
	
	// costruttore //
	public Item(String ID, ItemType type, double price, int sconto, ArrayList<Item> listItemsTris) {
		this.ID = ID;
		this.type = type;
		
		// applicazione prezzo in base al tipo di articolo //
		this.price = 
		switch (type) {
			case STANDARD -> price;
			case SCONTATO -> price-=(price*sconto)/100; // applicazione sconto
		};
		
		if (type == TRIS) {
			double minPrice;
			for (Item i : listItemsTris) {
				if (i.getPrice() < minPrice) minPrice=i.getPrice();
			}
			
			// calcolo prezzo totale dell'articolo 'tris'
			for (Item i : listItemsTris) {
				// articolo meno costosto in regalo
				if (i.getPrice() == minPrice) i.setPrice(0);
				
				// somma prezzi
				this.price += i.getPrice();
			}
		}
	}
	
	// getters //
	public String getID() {
		return ID;
	}
	
	public double getPrice() {
		return price;
	}
	
	// setters //
	public void setPrice(double price) {
		this.price = price;
	}
	
	// l'ID è univoco non modificabile in seguito
	
	// metodo toString per returnare le info di un elemento //
	@Override
	public String toString() {
		String p;
		if (type==SCONTATO) p = prezzo + ". Applicato sconto " + sconto + "%";
		else p=prezzo;
		
		return "Elemento " + ID + ". Prezzo € " + p;
	}
}