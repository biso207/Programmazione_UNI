package Esercizi.Iterazione;

import java.util.*;

public class Es1Itera {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int num, sum=0, cont=0;
		
		while(true) {
			System.out.print("Inserire un numero (0 per fermarti): ");
			num = scanner.nextInt();
			
			if (num==0) break;
			
			sum+=num;
			cont++;
		}
		
		int media = sum/cont;
		System.out.print("La media è " + media);
		
		scanner.close();
	}
}