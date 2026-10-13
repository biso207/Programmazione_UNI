import java.util.*;

public class Es2 {
	public static void main(String[] args) {
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