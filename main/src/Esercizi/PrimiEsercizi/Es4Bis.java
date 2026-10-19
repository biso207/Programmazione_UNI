package Esercizi.PrimiEsercizi;

import java.util.*;

public class Es4Bis {
	static void main() {
		Scanner scanner = new Scanner(System.in);

        System.out.print("Inserire il numero double (x): ");
        double x = scanner.nextDouble();
        System.out.print("Inserire il valore boolean (b): ");
        boolean b = scanner.nextBoolean();

        // selezione dell'arrotondamento tramite operatore ternario
        // Math.floor e Math.ceil restituiscono un double, facciamo il cast a (int) per stampare un numero intero pulito
        int risultato = b ? (int) Math.floor(x) : (int) Math.ceil(x);

        System.out.println("Risultato: " + risultato);
	}
}