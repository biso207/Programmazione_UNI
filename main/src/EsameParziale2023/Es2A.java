/*
Luca Bisognin - 26/10/2026
Es 2a Esame Parziale 2023
*/

package EsameParziale2023;

import java.util.*;

public class Es2A {
    void main() {
        Random random = new Random();
        int N = random.nextInt(3, 10);
        int[] numRiga = new int[N];

        // numeri riga matrice //
        for (int i=0; i<N; i++) numRiga[i] = i+1;

        // stampa quadrato latino standard //
        int indexA=0, indexPartenza=0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                System.out.print(numRiga[indexA] + " ");
                indexA = (indexA==N-1) ? 0 : indexA+1;
            }

            indexPartenza++; // partenza numero seguente
            indexA = indexPartenza; // reset indice array numeri riga

            System.out.println();
        }
    }
}
