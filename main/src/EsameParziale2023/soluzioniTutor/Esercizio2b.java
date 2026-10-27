package EsameParziale2023.soluzioniTutor;

import java.util.Scanner;

public class Esercizio2b {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// Input N
		System.out.println("Fornire N: ");
		int n = scan.nextInt();
		
		int[][] A = new int[n][n];
		
		// Caricamento
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				A[i][j] = -3 + (int)(Math.random() * ((10 + 3) + 1));
		
		/*
		// Sovrascrittura usata per verificare che il programma funzioni
		n = 3; A = new int[][] {{1, 5, 6}, {1, 0, 2}, {0, -2, 8}};
		*/
		
		// Stampa
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(A[i][j] + "\t");
			System.out.println();
		}
		
		// Stampare elemento A[i][j] se sommaRiga == sommaColonna
		System.out.println();
		for (int i = 0; i < n; i++) {			
			for (int j = 0; j < n; j++) {
				
				int sommaRiga = 0;
				for (int k = 0; k < n; k++)
					sommaRiga += A[i][k];
				
				int sommaColonna = 0;
				for (int k = 0; k < n; k++)
					sommaColonna += A[k][j];
				
				if (sommaRiga == sommaColonna)
					System.out.println(A[i][j]);
			}
		}
		
	}
}