import java.util.*;

public class Es4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.print("Inserire il numero double (x): ");
        double x = scanner.nextDouble();
        System.out.print("Inserire il numero di cifre decimali (b): ");
        byte b = scanner.nextByte();

        // calcolo del fattore di scala (10 elevato a b)
        double fattore = Math.pow(10, b);

        // arrotondamento con la formula suggerita
        // il cast a (double) è necessario prima della divisione per non perdere i decimali
        double risultato = Math.round(x * fattore) / fattore;

        System.out.println("Risultato: " + risultato);
	}
}