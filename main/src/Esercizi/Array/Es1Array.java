package Esercizi.Array;/*
Luca Bisognin - 12/10/2026
Es Pag 17 - Array
*/

import java.util.*;

public class Es1Array {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n;
		while(true) {
			System.out.print("Dimensione array: ");
			n = scanner.nextInt();
			if (n>=5 && n<=10) break;
		}
		
		// dichiarazio e init array
		boolean[] booleani = new boolean[n];
		for (int i=0; i<n; i++) booleani[i] = (i%2==0);
		
		// stampa array
		System.out.print("[");
		for (int i=0; i<n-1; i++) System.out.print(booleani[i] + ", ");
		System.out.print(booleani[n-1] + "]");
		
		scanner.close();
	}
}