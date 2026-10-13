import java.util.*;

public class NegozioMare {
	// attributi //
	private Queue<Ordine> listaOrdini; // tipo per le liste FIFO
	
	// costruttore //
	public NegozioMare() {
		this.listaOrdini = new ArrayDeque<Ordine>();
	} 
	
	//GESTIONE LISTA//
	
	// aggiunta ordine in lista //
	public void addOrder(Ordine o) {
		if (o.getFinalPrice() > 500) listaOrdini.addFirst(o);
		else listaOrdini.offer(o);
	}
	
	// metodo per rimuovere dalla lista un ordine //
	public void removeOrder() {
		listaOrdini.poll();
	}
	
	// stampa su file delle info degli ordini //
	public boolean export() {
		return true;
	}
}