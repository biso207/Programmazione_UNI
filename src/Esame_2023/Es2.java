import java.util.*;

public class Es2 {
	private boolean [][] matrix;
	private int N, M;
	private boolean result=true, resultRow=false;
	
	public void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// - input utente -
		System.out.println("Creazione Matrice");
		
		System.out.print("Numero righe: ");
		N = scanner.nextInt();
		System.out.print("Numero colonne: ");
		M = scanner.nextInt();
		
		scanner.close();
		
		// - creazione e stampa matrice -
		fillMatrix();
		printMatrix();
		
		// - calcolo e stampa risultato -
		for (int i=0; i<N; i++) {
			resultRow = false; // azzeramento bool riga
			for (int j=0; j<M; j++) {
				resultRow = resultRow || matrix[i][j];
			}
			result = resultRow && result;
		}
		
		System.out.println("Ecco il risultato dell'AND dell'OR di tutte le righe: " + result);
	}
	
	// metodo per riempire la matrice di bool randomici
	public void fillMatrix() {
		Random r = new Random();
		matrix = new boolean[N][M];
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				matrix[i][j] = r.nextBoolean();
			}
		}
	}
	
	// metodo per stampare la matrice
	public void printMatrix() {
		System.out.println("\nEcco la matrice riempita di bool casuali");
		System.out.println("Riga |");
		for (int i=0; i<N; i++) {
			System.out.print(i +  "    |");
			for (int j=0; j<M; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
}