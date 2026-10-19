package Esame_2023.Es4;

import java.util.*;

public class Item {
	// attributi //
	private final String ID;
	private double price;
	private final int sconto;
	private final ItemType type;
	
	// costruttore //
	public Item(String ID, ItemType type, double price, int sconto, ArrayList<Item> listItemsTris) {
		this.ID = ID;
		this.type = type;
		this.sconto = sconto;
		
		// applicazione prezzo in base al tipo di articolo //
		this.price = 
		switch (type) {
			case STANDARD -> price;
			case SCONTATO -> price - ((price * sconto) / 100); // applicazione sconto
            case TRIS -> {
				// Controlla che il tris contenga almeno un articolo.
				if (listItemsTris == null || listItemsTris.isEmpty()) {
					throw new IllegalArgumentException(
							"Il tris deve contenere almeno un articolo."
					);
				}

				double totale = 0;
				double minPrice = listItemsTris.getFirst().getPrice();

				// Calcola il totale e individua l'articolo meno costoso.
				for (Item i : listItemsTris) {
					totale += i.getPrice();

					if (i.getPrice() < minPrice) {
						minPrice = i.getPrice();
					}
				}

				// Il meno costoso è gratuito: restituisce il prezzo del tris.
				yield totale - minPrice;
			}
        };
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
		if (type==ItemType.SCONTATO) p = price + ". Applicato sconto " + sconto + "%";
		else p= "" + price;
		
		return "Elemento " + ID + ". Prezzo € " + p;
	}
}