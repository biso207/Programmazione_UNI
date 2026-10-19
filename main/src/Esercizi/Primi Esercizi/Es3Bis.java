import java.util.*;

public class Es3Bis {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int x1, x2;
		
		System.out.print("Inserire x1: ");
		x1 = scanner.nextInt();
		System.out.print("Inserire x2: ");
		x2 = scanner.nextInt();
		
		int result = (x1>=0 && x1<x2) ? (int)(Math.random() * (x2 - x1 + 1)) + x1 : -1;
		
		System.out.println(result);
	}
}