/*
Luca Bisognin - 2/11/2026
Es 3 pag 10 - Var Istanza
*/

package Esercizi.Istanza;

import java.util.*;

public class PrintDiagonalMatrix {
    private final String RESET = "\u001B[0m";
    private final String COLOR = "\u001B[33m"; // yellow
    private Object[][] matrix;

    // IMPOSTARE QUA LA DIMENSIONE DELLA MATRICE //
    private final int N = 20;

    // range generatore - max è escluso //
    private final int MIN = 100, MAX = 128;

    // entry point //
    void main() {
        PrintDiagonalMatrix p = new PrintDiagonalMatrix();

        p.setMatrix(); // riempimento matrice con numeri random 0-9
        Object[] diagonal = p.getDiagonal(); // recupero diagonale principale

        // stampa matrice //
        System.out.println("Matrice");
        p.printMatrix();

        // stampa diagonale secondaria //
        System.out.println("\nDiagonale Secondaria");
        for (Object o : diagonal) System.out.print(o + " ");
    }

    // metodo per riempire con valori random la matrice //
    public void setMatrix() {
        Random rnd = new Random();
        matrix = new Object[N][N];
        for (int i=0; i< N; i++) {
            for (int j=0; j<N; j++) matrix[i][j] = rnd.nextInt(MIN, MAX);
        }
    }

    // metodo per stampare la matrice //
    public void printMatrix() {
        for (int i=0; i< N; i++) {
            for (int j=0; j<N; j++) {
                if (i+j == i+(N-i-1)) System.out.print(COLOR + "["+ matrix[i][j] + "] " + RESET);
                else System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // metodo per recuperare la diagonale secondaria //
    public Object[] getDiagonal() {
        Object[] array = new Object[N];

        for (int i=0; i<N; i++) array[i] = matrix[i][N-i-1];

        return array;
    }
}
