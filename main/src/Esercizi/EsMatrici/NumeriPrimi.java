/*
Luca Bisognin - 12/11/2026
Es ArrayListFrequenze
*/

package Esercizi.EsMatrici;

import java.util.*;

public class NumeriPrimi {
    void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Numero massimo: ");
        int N = scanner.nextInt();

        for (int i=2; i<N; i++) if (isPrime(i)) System.out.println(i + " è un numero primo");
    }

    // metodo per controllare che un numero sia primo //
    public boolean isPrime(int n) {
        for (int i=2; i<n; i++) if (n%i==0) return false;
        return true;
    }
}
