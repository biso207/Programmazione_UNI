/*
Luca Bisognin - 2/11/2026
Es 3 pag 10 - Var Istanza
*/

package Esercizi.Istanza;

import java.util.*;

public class PrintDiagonalMatrix {
    public static final String RESET = "\u001B[0m";
    public static final String COLOR = "\u001B[33m"; // yellow
    private static final Random rnd = new Random();
    private static Object[][] matrix;

    // IMPOSTARE QUA LA DIMENSIONE DELLA MATRICE //
    private static final int N = 20;

    // range generatore - max è escluso //
    private static final int MIN = 100, MAX = 128;

    // entry point //
    void main() {
        matrix = new Object[N][N];
        setMatrix(); // riempimento matrice con numeri random 0-9
        Object[] diagonal = getDiagonal(); // recupero diagonale principale

        // stampa matrice //
        System.out.println("Matrice");
        printMatrix();

        // stampa diagonale secondaria //
        System.out.println("\nDiagonale Secondaria");
        for (Object o : diagonal) System.out.print(o + " ");
    }

    // metodo per riempire con valori random la matrice //
    public static void setMatrix() {
        for (int i=0; i< N; i++) {
            for (int j=0; j<N; j++) matrix[i][j] = rnd.nextInt(MIN, MAX);
        }
    }

    // metodo per stampare la matrice //
    public static void printMatrix() {
        for (int i=0; i< N; i++) {
            for (int j=0; j<N; j++) {
                if (i+j == i+(N-i-1)) System.out.print(COLOR + "["+ matrix[i][j] + "] " + RESET);
                else System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // metodo per recuperare la diagonale secondaria //
    public static Object[] getDiagonal() {
        Object[] array = new Object[N];

        for (int i=0; i<N; i++) array[i] = matrix[i][N-i-1];

        return array;
    }
}
