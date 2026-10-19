/*
Luca Bisognin - 13/10/2026
Es Diagonale Secondario Matrice
*/

package Esercizi.Array;

import java.util.*;

public class Es3Matrix {
	static void main() {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		System.out.println("Creiamo una matrice quadrata (almeno 3x3)");
		// lettura numRighe e numColonne
		int numRighe, numColonne;
		while(true) {
			System.out.print("Numero Righe: ");
			numRighe = scanner.nextInt();
			System.out.print("Numero Colonne: ");
			numColonne = scanner.nextInt();          
			
			if (numRighe==numColonne && numRighe>3) break;
		}
		
		// dichiarazione e inizializzazione matrice
		int[][] matrix = new int[numRighe][numColonne];
		for (int i=0; i<numRighe; i++) {
			for (int j=0; j<numColonne; j++) matrix[i][j] = random.nextInt(4, 9);
			matrix[i][0] = random.nextInt(4, 9);
		}
		  
		// stampa matrice riempita
		for (int i=0; i<numRighe; i++) {
			for (int j=0; j<numColonne; j++) System.out.print(matrix[i][j] + "\t");
			System.out.println();
		}
		
		// reset diagonale secondario
		for (int i=0; i<numRighe; i++) {
			for (int j=0; j<numColonne; j++) {
				if (i+j == numRighe-1) matrix[i][j] = 0;
			}
		}
		
		// versione compatta
		/*
		for (int j=0; j<numRighe; j++) {
			matrix[i][N-1-i] = 0;
		}
		*/
		
		System.out.println("\nDiagonale Secondaria Resettata");
		// stampa matrice finale
		for (int i=0; i<numRighe; i++) {
			for (int j=0; j<numColonne; j++) System.out.print(matrix[i][j] + "\t");
			System.out.println();
		}
		
	}
}