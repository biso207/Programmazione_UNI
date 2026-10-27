package EsameParziale2023.soluzioniTutor;

public class Esercizio2a {
	public static void main(String[] args) {
		int n = 3 + (int)(Math.random() * ((9 - 3) + 1));
		
		int[][] square = new int[n][n];
		
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				square[i][j] = ((i + j) % n) + 1;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(square[i][j] + " ");
			System.out.println();
		}
		
		/*
		// Stampare insieme a calcolare il numero
		int n = 3 + (int)(Math.random() * ((9 - 3) + 1));
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print((((i + j) % n) + 1) + " ");
			
			System.out.println();
		}
		*/
	}
}