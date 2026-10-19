package Esame_2022;

import java.util.*;

public class Es2 {
	public void main(String[] args) {
		int N, M; // numero colonne e righe matrice
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Creiamo una matrice");
		
		try {
			System.out.print("Numero di colonne: ");
			N = scanner.nextInt();
			System.out.print("Numero di righe: ");
			M = scanner.nextInt();
			
			int[][] matrix = createMatrix(N, M);
			
			System.out.println("\nOra stampo tutte le righe della matrice per cui la somma degli elementi è minore del primo elemento della riga.");
			printFilteredMatrix(matrix, N, M);
		} catch (Exception e) {
			System.out.println("Mmmmh, hai scritto un valore non consentito, non creeremo una matrice...");
		}
		
		scanner.close();
	}
	
	// metodo per creare e riempire una matrice NxM di valori randomici tra -50 e 50 inclusi
	public int[][] createMatrix(int N, int M) {
		int[][] matrix = new int[N][M];
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				matrix[i][j] =(int)(Math.random()*101)-50;
			}
		}
		
		return matrix;
	}
	
	// metodo per stampare tutte le righe della matrice per cui la somma degli elementi è minore del primo elemento della riga
	public void printFilteredMatrix(int[][] matrix, int N, int M) {
		int somma=0;
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				somma+= matrix[i][j];
			}
			
			if (somma<matrix[i][0]) {
				System.out.print("Riga " + i + ": ");
				for (int k=0; k<M; k++) {
					System.out.print(matrix[i][k] + " ");
				}
			} else System.out.print("Riga " + i + ": nessun valore");
			
			System.out.print("\n");
			
			somma=0;
		}
	}
}