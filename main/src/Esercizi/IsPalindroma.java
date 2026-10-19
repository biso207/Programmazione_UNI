package Esercizi;/*
Luca Bisognin - 15/10/2026
Esercizi inversione - controllo stringa palindroma
*/

import java.util.*;

public class IsPalindroma {
	public void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = "";
		
		System.out.print("stringa: ");
		s = scanner.nextLine();
		s=s.replaceAll("\\s+", "").toLowerCase();
		
		boolean isPalindroma = isPalindroma(s);
		System.out.println("result: " + isPalindroma);
	}
	
	public boolean isPalindroma(String s) {
		int len = s.length();
		int metà = len/2;
		for (int i=0; i<metà; i++) {
			if (s.charAt(i) != s.charAt(len - 1- i)) return false;
		}
		
		return true;
	}
}