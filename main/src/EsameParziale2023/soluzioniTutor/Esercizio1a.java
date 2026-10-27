package EsameParziale2023.soluzioniTutor;

import java.util.Scanner;

public class Esercizio1a {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// Input N
		System.out.println("Fornire N: ");
		int n = scan.nextInt();
		
		if (n < 0 || n > 10) {
			System.out.println("Errore: N non appartiene all'intervallo [0, 10]");
			return;
		}
		
		System.out.println("Fornire ora " + n + " numeri: ");
		
		// Input array
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = scan.nextInt();
		
		// Somma elementi array
		float somma = 0;
		for (int v : a)
			somma += v;
		
		// Calcolo media
		float media = somma / n;
		
		// Varianza
		float varianza = 0;
		for (int i = 0; i < n; i++)
			varianza += Math.pow(a[i] - media, 2);
		varianza /= n;
		
		System.out.println("Risultato: " + varianza);
		
		/*
		// Rolling averange & rolling variance
		double oldMean = 0;
		double mean = 0;
		double s = 0;
		for (int i = 1; i < n + 1; i++) {
			int v = scan.nextInt();
			oldMean = mean;
			mean += (v - mean) / i;
			s += (v - oldMean) * (v - mean);
		}
		System.out.println("Risultato: " + (s / n));
		*/
	}
}