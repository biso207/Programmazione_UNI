import java.util.*;

public class Ordine {
	// attributi //
	private final String ID;
	private List<Item> listOrderedItems;
	private double finalPrice; // conteggiato in base al prezzo dei singoli articoli
	
	// costruttore //
	public Ordine(String ID) {
		this.ID = ID;
		listOrderedItems = new ArrayList<Items>();
		finalPrice = 0;
	}
	
	// metodi di gestione ordine //

	// aggiunta item all'ordine
	public void addItemToOrder(Item i) {
		listOrderedItems.add(i);
	}
	
	// getters //
	public String getID() {
		return ID;
	}
	
	public List<Item> getListOrderedItems() {
		return listOrderedItems;
	}
	
	public double getFinalPrice() {
		for (Item i : listOrderedItems) {
			finalPrice+=i.getPrice();
		}
		
		return finalPrice;
	}
	
	// metodo toString per recuperare le info di un ordine //
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("Ordine "+ID+"\n");
		
		// aggiunta info elementi alla stringa //
		for (Item i : listOrderedItems) {
			s.append(i).append("\n");
		}
		
		s.append("\nPrezzo Totale: " + finalPrice);
		
		return s.toString();
	}
}