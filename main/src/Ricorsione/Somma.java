package Ricorsione;

public class Somma {
    private static int somma;

    void main() {
        int N = 20;
        somma(N);

        System.out.println("Somma dei primi " + N + " numeri interi: " + somma);
    }

    public static void somma(int N) {
        if (N>=0) {
            somma += N;
            somma(--N);
        }
    }
}
