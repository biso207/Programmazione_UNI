/*
Luca Bisognin - 26/10/2026
Es 1a Esame Parziale 2023
*/

package EsameParziale2023;

import java.util.*;

public class Es1A {
    void main() {
        Scanner scanner = new Scanner(System.in);

        // lettura N
        int N;
        while (true) {
            System.out.print("Inserire N: ");
            N = scanner.nextInt();

            if (N > 0 && N <=10) break;
        }

        double varianza=0, media, sum=0;

        // recupero N valori //
        int[] numeri = new int[N]; // per il salvataggio dei singoli numeri

        for (int i=0; i<N; i++) {
            System.out.print("Inserisci un numero: ");
            int num = scanner.nextInt();
            numeri[i] = num;

            sum += num;
        }
        media = sum/N;

        // calcolo varianza //
        for (int j=0; j<N; j++) {
            varianza += Math.pow((numeri[j]-media), 2); // incremento valore di varianza
        }
        varianza /= N; // operazione finale sulla varianza (divisione per N)

        // stampa risultato //
        System.out.println("La varianza dei tuoi numeri è: " + varianza);

        scanner.close();
    }
}
