package Esame_2023.Es4;

import java.util.*;

public class NegozioMare {
	// attributi //
	private final Queue<Ordine> listaOrdini; // tipo per le liste FIFO
	
	// costruttore //
	public NegozioMare() {
		this.listaOrdini = new ArrayDeque<Ordine>();
	} 
	
	//GESTIONE LISTA//
	
	// aggiunta ordine in lista //
	public void addOrder(Ordine o) {
		if (o.getFinalPrice() > 500) {
			listaOrdini.offer(o);
		}
	}
	
	// metodo per rimuovere dalla lista un ordine //
	public void removeOrder() {
		listaOrdini.poll();
	}

	///by ChatGPT///
	// stampa su file delle info degli ordini //
	public boolean export() {
		try (java.io.PrintWriter writer =
					 new java.io.PrintWriter("ordini.txt")) {

			for (Ordine o : listaOrdini) {
				writer.println(o);
				writer.println();
			}

			return true;

		} catch (java.io.IOException e) {
			System.out.println("Errore durante l'esportazione: "
					+ e.getMessage());
			return false;
		}
	}
}