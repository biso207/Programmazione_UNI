package Esercizi.PrimiEsercizi;

import java.util.*;

public class Es2Bis {
	static void main() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Inserire un numero: ");
		double num = scanner.nextDouble();
		
		int result = num<0 ? (int)num : (int)(num*3+2);
		
		System.out.println(result);
	}
}