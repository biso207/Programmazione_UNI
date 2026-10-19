package Esercizi.Array;/*
Luca Bisognin - 13/10/2026
Es Pag 30 - Array
*/

import java.util.*;

public class Es2Matrix {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		System.out.println("Creiamo una matrice (almeno 2x2)");
		// lettura numRighe e numColonne
		int numRighe, numColonne;
		while(true) {
			System.out.print("Numero Righe: ");
			numRighe = scanner.nextInt();
			System.out.print("Numero Colonne: ");
			numColonne = scanner.nextInt();          
			
			if (numRighe>1 & numColonne>1) break;
		}
		
		// dichiarazione e inizializzazione matrice
		int[][] matrix = new int[numRighe][numColonne];
		for (int i=0; i<numRighe; i++) {
			for (int j=0; j<numColonne; j++) matrix[i][j] = random.nextInt(4, 9);
			matrix[i][0] = random.nextInt(4, 9);
		}
		System.out.println("\nMatrice Riempita di numeri casuali tra 4 e 8");
		// stampa matrice riempita
		for (int i=0; i<numRighe; i++) {
			for (int j=0; j<numColonne; j++) System.out.print(matrix[i][j] + "\t");
			System.out.println();
		}
		
		// ## PARTE 2 - RESET COLONNA E RIGA 'k' ##
		
		// lettura K
		int k;
		while(true) {
			System.out.print("Quale riga vuoi resettare? Numero Riga (>=0 e <" + numRighe + "): ");
			k = scanner.nextInt();
			
			if (k>=0 && k<numRighe) break;
		}		
		// reset riga k
		for (int i=0; i<numColonne; i++) matrix[k][i] = 0;
		
		
		// rilettura k
		while(true) {
			System.out.print("Quale colonna vuoi resettare? Numero Colonna (>=0 e <" + numColonne + "): ");
			k = scanner.nextInt();
			
			if (k>=0 && k<numColonne) break;
		}
		// reset colonna K
		for (int i=0; i<numRighe; i++) matrix[i][k] = 0;
		
		System.out.println("\nMatrice con colonna e riga selezionate resettate");
		// stampa finale con riga e colonna resettate
		for (int i=0; i<numRighe; i++) {
			for (int j=0; j<numColonne; j++) System.out.print(matrix[i][j] + "\t");
			System.out.println();
		}
	}
}