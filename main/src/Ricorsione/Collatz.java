package Ricorsione;

import java.util.*;

public class Collatz {
    void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Numero: ");
        int N = scanner.nextInt();

        congetturaCollatz(N);
        System.out.println("fine");
    }

    // ricorsione per il calcolo //
    public void congetturaCollatz(int n) {
        if (n == 1) return;

        if (n%2==0) {
            System.out.println(n/2);
            congetturaCollatz(n / 2);
        }
        else {
            System.out.println(3 * n + 1);
            congetturaCollatz(3 * n + 1);
        }
    }
}
