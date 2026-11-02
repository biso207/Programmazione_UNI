/*
Luca Bisognin - 2/11/2026
Es 1 e 2 pag 10 - Var Istanza
*/

package Esercizi.Istanza;

import java.util.*;

public class Swapper {
    void main() {
        Scanner scanner = new Scanner(System.in);
        int i, j;
        int[] a = new int[]{4, 3, 6, 2, 9};
        int[] b = new int[]{6, 2, 8, 1, 3};

        /*
        System.out.println("Stampa Array");
        for (int num : a) System.out.print(num + " ");
        */

        System.out.print("\nindice i: ");
        i = scanner.nextInt();
        System.out.print("indice j: ");
        j = scanner.nextInt();

        System.out.println("risultato swap indici array: " + swap(a, i, j));
        System.out.println("risultato swap array: " + swap2(a, b));

        /*
        if (swap(a, i, j)) {
            System.out.println("Stampa Nuovo Array");
            for (int num : a) System.out.print(num + " ");
        }
        */
    }

    // metodo per invertire due indici di un array
    public static boolean swap(int[] a, int i, int j) {
        if ((i<0 || i>a.length) || (j<0 || j>a.length)) return false;

        int var = a[i];
        a[i] = a[j];
        a[j] = var;

        return true;
    }

    // metodo per invertire tutti i valori di 2 array
    public static boolean swap2(int[] a, int[] b) {
        if (a.length != b.length) return false;

        for (int i=0; i<a.length; i++) {
            int temp = a[i];
            b[i] = a[i];
            a[i] = temp;
        }

        return true;
    }
}
