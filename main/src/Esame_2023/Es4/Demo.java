package Esame_2023.Es4;

import java.util.*;

public class Demo {
	public static void main(String[] args) {
		// creazione 6 elementi
		Item i1 = new Item("1", ItemType.STANDARD, 50, 0, null);
		Item i2 = new Item("2", ItemType.SCONTATO, 600, 10, null);
		Item i3 = new Item("3", ItemType.STANDARD, 100, 0, null);
		
		List<Item> listItemsTris = new ArrayList<Item>();
		listItemsTris.add(i1);
		listItemsTris.add(i2);
		listItemsTris.add(i3);
		
		Item i4 = new Item("4", ItemType.TRIS, 0, 0, listItemsTris);
		
		Item i5 = new Item("5", ItemType.STANDARD, 50, 0, null);
		Item i6 = new Item("6", ItemType.SCONTATO, 600, 10, null);
		Item i7 = new Item("7", ItemType.STANDARD, 100, 0, null);
		Item i8 = new Item("8", ItemType.STANDARD, 700, 0, null);
		
		// creazione 2 ordini
		Ordine o1 = new Ordine("1");
		o1.addItemToOrder(i1);
		o1.addItemToOrder(i2);
		o1.addItemToOrder(i3);
		o1.addItemToOrder(i4);
		
		Ordine o2 = new Ordine("2");
		o2.addItemToOrder(i5);
		o2.addItemToOrder(i6);
		o1.addItemToOrder(i7);
		o1.addItemToOrder(i8);
		
		// creazione negozio
		NegozioMare ng = new NegozioMare();
		ng.addOrder(o1);
		ng.addOrder(o2);
		
		// stampa su file => non funzionante
		ng.export();
	}
}