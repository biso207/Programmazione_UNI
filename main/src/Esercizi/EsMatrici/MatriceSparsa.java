/*
Luca Bisognin - 19/10/2026
Es MatriceSparsa
*/

package Esercizi.EsMatrici;

import java.util.*;

class MatriceSparsa {
	static void main() {
		Scanner scanner = new Scanner(System.in);
		Random rand = new Random();
		
		int numRighe, numColonne;
		
		System.out.println("Crea Matrice");
		
		System.out.print("Numero righe: ");
		numRighe = scanner.nextInt();
		System.out.print("Numero colonne: ");
		numColonne = scanner.nextInt();
		
		int[][] matrix = new int[numRighe][numColonne];
		
		// rimepimento matrice con numeri tra 0 e 3
		for (int i=0; i<numRighe; i++) {
			for (int j=0; j<numColonne; j++) matrix[i][j] = rand.nextInt(0,4);
		}
		
		// stampa matrice
		for (int i=0; i<numRighe; i++) {
			for (int j=0; j<numColonne; j++) System.out.print(matrix[i][j] + "\t");
			System.out.println();
		}
		
		int numZeri=0;
		for (int i=0; i<numRighe; i++) {
			for (int j=0; j<numColonne; j++) {
				if (matrix[i][j] == 0) numZeri++;
			}
		}
		
		boolean isSparsa = numZeri > (numRighe*numColonne)/2;
		String result = isSparsa ? "è sparsa" : "non è sparsa";
		
		System.out.println(numZeri + " zeri su " + numRighe*numColonne+ " elementi => La matrice " + result);
		
		scanner.close();
	}
}