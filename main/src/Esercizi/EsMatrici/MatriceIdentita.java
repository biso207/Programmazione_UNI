package Esercizi.EsMatrici;/*
Luca Bisognin - 19/10/2026
Es MatriceIdentita
*/

class MatriceIdentita {
	public static void main(String[] args) {
		final int N = 4;
		int[][] matrix  = new int[N][N];
		
		// riempimento matrice
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) matrix[i][j] = 0;
		}
		
		// costruzione antidiagonale
		for (int i=0; i<N; i++) {
			matrix[i][N-1 - i] = 1;
		}
		
		// stampa matrix
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) System.out.print(matrix[i][j] + "\t");
			System.out.println();
		}
	}
}