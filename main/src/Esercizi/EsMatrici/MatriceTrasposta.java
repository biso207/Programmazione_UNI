/*
Luca Bisognin - 20/10/2026
Es Lezione del 20/10- Matrice Trasposta
*/

package Esercizi.EsMatrici;

import java.util.*;

class MatriceTrasposta {
	static void main() {
		Scanner scanner = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.println("Creiamo una matrice");
		System.out.print("Numero Righe: ");
		int numRighe = scanner.nextInt();
		System.out.print("Numero Colonne: ");
		int numColonne = scanner.nextInt();
		
		char[][] matrixA = new char[numRighe][numColonne];
		
		// riempimento matrice A con caratteri random
		for (int i=0; i<numRighe; i++) {
			for (int j=0; j<numColonne; j++) matrixA[i][j] = (char) rand.nextInt('a', 'z'+1);
		}
		
		// stampa matrice A
		System.out.println("\nMatrice A");
		for (int i=0; i<numRighe; i++) {
			for (int j=0; j<numColonne; j++) System.out.print(matrixA[i][j] + " ");
			System.out.println();
		}
		
		// creazione matrice B trasposta //
		char[][] matrixB = new char[numColonne][numRighe];
		
		// riempimento matrice
		for (int i=0; i<numColonne; i++) {
			for (int j=0; j<numRighe; j++) matrixB[i][j] = matrixA[j][i];
		}
		
		// stampa matrice B
		System.out.println("\nMatrice B");
		for (int i=0; i<numColonne; i++) {
			for (int j=0; j<numRighe; j++) System.out.print(matrixB[i][j] + " ");
			System.out.println();
		}
		
		scanner.close();
	}
}