package Ricorsione;

public class PrimiEsercizi {

    // entry point //
    void main() {
        // es 9/11 //
        int N = 20;
        System.out.println("Somma dei primi " + N + " numeri interi: " + somma(N));

        // es #1 10/11 //
        System.out.print("7123 = ");
        printWord(7123);

        // es #2 10/11 //
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        System.out.println("\nSomma array: " + sommaArray(a, 0));
    }

    // ESERCIZIO 9/11 //
    public int somma(int N) {
        if (N>=0) {
            return N + somma(--N);
        }
        return 0;
    }

    // ESERCIZIO #1 10/11 //
    public void printToWord(int n) {
        switch (n) {
            case 0 -> System.out.print("zero ");
            case 1 -> System.out.print("uno ");
            case 2 -> System.out.print("due ");
            case 3 -> System.out.print("tre ");
            case 4 -> System.out.print("quattro ");
            case 5 -> System.out.print("cinque ");
            case 6 -> System.out.print("sei ");
            case 7 -> System.out.print("sette ");
            case 8 -> System.out.print("otto ");
            case 9 -> System.out.print("nove ");
        }
    }

    public void printWord(int n) {
        if (n>10) {
            printWord(n/10);
            printToWord(n%10);
        }
        printToWord(n);
    }

    // ESERCIZIO #2 10/11 //
    public int sommaArray(int[] a, int i) {
        if (i<a.length) {
            return a[i] + sommaArray(a, ++i);
        }
        return 0;
    }
}
