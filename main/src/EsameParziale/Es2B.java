/*
Luca Bisognin - 26/10/2026
Es 2b Esame Parziale 2023
*/

package EsameParziale;

import java.util.*;

public class Es2B {
    void main() {
        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();

        // inserimento da tastiera N (>0) //
        int N;
        while(true) {
            System.out.print("Inserire un numero maggiore di zero: ");
            N = scanner.nextInt();

            if (N>0) break;
        }

        System.out.println("Matrice");
        // riempimento, stampa e somma valori righe/colonne della matrice di numeri casuale tra -3 e 10 (compresi) //
        int[][] matrix = new int[N][N];
        int[] sumRighe = new int[N];
        int[] sumColonne = new int[N];

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                matrix[i][j] = rnd.nextInt(-3, 11);

                // stampa //
                System.out.print(matrix[i][j] + " ");

                // calcolo somme //
                sumRighe[i] += matrix[i][j];
                sumColonne[j] += matrix[i][j];
            }
            System.out.println();
        }

        System.out.println("Elementi A[i][j] per la somma della i-esima riga è uguale alla somma della j-esima colonna");
        int sumI=0, sumJ=0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (sumRighe[i]==sumColonne[j]) System.out.println(matrix[i][j]);
            }
        }
    }
}
