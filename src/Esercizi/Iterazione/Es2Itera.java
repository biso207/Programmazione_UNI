import java.util.*;

public class Es2Itera {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x, y;
		
		// ciclo while per chiedere i valori di x e y
		while(true) {
			System.out.print("Valore di x: ");
			x = scanner.nextInt();
			
			System.out.print("Valore di y: ");
			y = scanner.nextInt();
			
			if (x!=y || x<0 || y<0) break;
		}
		
		// ciclo while per modificare i valori di x e y
		while (true) {
			if (x>y) x-=y;
			else y-=x;
			
			if (x==y) break;
		}
		
		System.out.println("MCD = " + x);
		
		scanner.close();
	}
}