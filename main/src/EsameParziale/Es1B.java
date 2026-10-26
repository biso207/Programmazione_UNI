/*
Luca Bisognin - 26/10/2026
Es 1b Esame Parziale 2023
*/

package EsameParziale;

import java.util.*;

public class Es1B {
    void main() {
        Scanner scanner = new Scanner(System.in);

        String s1, s2="";
        ArrayList<String> strings = new ArrayList<>();

        // inserimento stringhe //
        int cont=0;
        while (true) {
            System.out.print("Digita una stringa: ");
            s1 = scanner.nextLine();

            if (s1.length() < s2.length()) break;

            strings.add(s1);
            s2=s1; // aggiornamento stringa precedente
        }

        // calcolo lunghezza medie stringhe che iniziano con carattere tra 0 e 9
        int sumLengths=0, contStrings=0;
        double media;

        for (String s : strings) {
            if (Character.isDigit(s.charAt(0))) {
                sumLengths += s.length();
                contStrings++;
            }
        }
        media = (double) sumLengths/contStrings;

        // stampa risultato //
        System.out.println("La lunghezza media delle cifre che iniziano con una cifra è: " + media);

        scanner.close();
    }
}
