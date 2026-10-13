import java.util.*;

public class Es1 {
	public static void main(String[] args) {
		int baseMinore, baseMaggiore, altezza;
		double area;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Inserire valore base minore: ");
		baseMinore = scanner.nextInt();
		System.out.print("Inserire valore base maggiore: ");
		baseMaggiore = scanner.nextInt();
		System.out.print("Inserire valore altezza: ");
		altezza = scanner.nextInt();
		
		area = (baseMinore*baseMaggiore)*altezza/2;
		System.out.println("Area = " + area);
		
		scanner.close();
	}
}