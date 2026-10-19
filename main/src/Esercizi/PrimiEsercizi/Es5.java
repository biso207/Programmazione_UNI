package Esercizi.PrimiEsercizi;

import java.util.*;

public class Es5 {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserire una stringa: ");
        String s = scanner.nextLine();
        String sTrimmed = s.trim(); // rimozione spazi inizio fine

        // recupero primo carattere della stringa
        int primoCarattereIdx = s.indexOf(sTrimmed);

        // se la stringa non è vuota o composta di soli spazi, la tagliamo
        String risultato = (primoCarattereIdx != -1) ? s.substring(primoCarattereIdx) : "";
        System.out.println("Risultato: \"" + risultato + "\"");
    }
}
