/*
Luca Bisognin - 26/10/2026
Es 1b Esame Parziale 2023
*/

package EsameParziale2023;

import java.util.*;

public class Es1B {
    void main() {
        Scanner scanner = new Scanner(System.in);

        String s1, s2="";
        int sumLengths=0, contStrings=0;
        double media;

        // inserimento stringhe //
        while (true) {
            System.out.print("Digita una stringa: ");
            s1 = scanner.nextLine();

            if (s1.length() < s2.length()) break;

            char primoChar = s1.charAt(0);
            if (primoChar >='0' && primoChar <= '9') {
                sumLengths += s1.length();
                contStrings++;
            }
            s2=s1; // aggiornamento stringa precedente
        }

        media = (double) sumLengths/contStrings;

        // stampa risultato //
        System.out.println("La lunghezza media delle cifre che iniziano con una cifra è: " + media);

        scanner.close();
    }
}
