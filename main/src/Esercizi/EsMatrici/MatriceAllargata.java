/*
Luca Bisognin - 19/10/2026
Es MatriceAllargata
*/

package Esercizi.EsMatrici;

import java.util.*;

class MatriceAllargata {
	static void main() {
		Scanner scanner = new Scanner(System.in);
		Random rand = new Random();
		
		final int N = 5;
		int[][] matrixA = new int[N][N];
		
		// riempimento matrice con numeri random tra 1 e 9
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) matrixA[i][j] = rand.nextInt(1, 10);
		}
		// stampa matrice A
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) System.out.print(matrixA[i][j] + "\t");
			System.out.println();
		}
		
		System.out.print("Dimensione nuovo array (>0): ");
		int x;
		do {
			x = scanner.nextInt();
		} while (x<=0);
		
		final int NB = N+x;
		int[][] matrixB = new int[NB][NB];

		// todo: finire l'allargamento
		// riempimento matrice B
		for (int i=0; i<NB; i++) {
			for (int j=0; j<NB; j++) {
				/*
				if (i+j ==) matrixB[i][j] = matrixA[i][j];
				else matrixB[i][j] = 0;
				 */
			}
		}
		
		// stampa matrice B
		for (int i=0; i<NB; i++) {
			for (int j=0; j<NB; j++) System.out.print(matrixB[i][j] + "\t");
			System.out.println();
		}
	}
}