import java.util.*;

public class Es2Bis {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Inserire un numero: ");
		double num = scanner.nextDouble();
		
		int result = num<0 ? (int)num : (int)(num*3+2);
		
		System.out.println(result);
	}
}