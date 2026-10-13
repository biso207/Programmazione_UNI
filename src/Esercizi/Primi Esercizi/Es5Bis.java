import java.util.*;

public class Es5Bis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserire una stringa: ");
        String s = scanner.nextLine();
        String sTrimmed = s.trim(); // rimozione spazi inizio fine

        // troviamo la posizione finale calcolando l'indice di inizio + la lunghezza del testo pulito
        int inizioCaratteri = s.indexOf(sTrimmed);
        int fineCaratteri = inizioCaratteri + sTrimmed.length();

        // tagliamo dall'inizio (indice 0) fino alla fine del testo utile e concateniamo $
        String risultato = (inizioCaratteri != -1) ? s.substring(0, fineCaratteri) + "$" : "$";
        System.out.println("Risultato: \"" + risultato + "\"");
    }
}
