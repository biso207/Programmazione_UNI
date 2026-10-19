package Esercizi.PrimiEsercizi;

import java.util.*;

public class Es2 {
	static void main() {
		float x, y;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Valore di x: ");
		x = scanner.nextFloat();
		System.out.print("Valore di y: ");
		y = scanner.nextFloat();
		
		int result = (x==y*2 || x<=0) ? 1 : 0;
		
		System.out.println(result);
	}
}