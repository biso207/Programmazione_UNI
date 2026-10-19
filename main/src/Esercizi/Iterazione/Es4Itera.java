package Esercizi.Iterazione;

import java.util.*;

public class Es4Itera {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String s1="", s2="";
		
		while(true) {
			System.out.print("stringa 1: ");
			s1 = scanner.nextLine();
			System.out.print("stringa 2: ");
			s2 = scanner.nextLine();
			
			if (!s1.equals(s2)) break; // contrario alla consegna sennò è un esercizio inutile
		}
		
		int minLength = Math.min(s1.length(), s2.length());
		
		for (int i=0; i<minLength; i++) {
			if (s1.charAt(i) < s2.charAt(i)) {
				System.out.println("viene prima " + s1 + " di " + s2);
				break;
			}
			
			if (s1.charAt(i) > s2.charAt(i)) {
				System.out.println("viene prima " + s2 + " di " + s1);       
				break;
			}
		}
	}
}