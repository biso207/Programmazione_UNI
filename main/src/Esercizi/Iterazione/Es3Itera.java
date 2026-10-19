package Esercizi.Iterazione;

import java.util.*;

public class Es3Itera {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Inserire la prima stringa (x): ");
        String x = scanner.nextLine();
        System.out.print("Inserire la seconda stringa (y): ");
        String y = scanner.nextLine();

        StringBuilder risultato = new StringBuilder();
        int i = 0;

        // prende un carattere da x e uno da y finché entrambe hanno caratteri disponibili
        while (i < x.length() && i < y.length()) {
            risultato.append(x.charAt(i));
            risultato.append(y.charAt(i));
            i++;
        }

        // controllo dei residui: se x è più lunga, aggiunge la parte rimanente
        if (i < x.length()) {
            risultato.append(x.substring(i));
        }
        
        // se invece y è più lunga, aggiunge la sua parte rimanente
        if (i < y.length()) {
            risultato.append(y.substring(i));
        }

        System.out.println("Risultato fusione: " + risultato.toString());
	}
}