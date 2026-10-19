package Esame_2023;

import java.util.*;

public class Es3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random r = new Random();

        System.out.println("Definiamo le dimensioni della matrice A");

        System.out.print("Numero righe: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Hai inserito un valore non consentito.");
            scanner.next();
            System.out.print("Numero righe: ");
        }
        int rA = scanner.nextInt();

        System.out.print("Numero colonne: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Hai inserito un valore non consentito.");
            scanner.next();
            System.out.print("Numero colonne: ");
        }
        int cA = scanner.nextInt();


        System.out.println("\nDefiniamo le dimensioni della matrice B");

        System.out.print("Numero righe: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Hai inserito un valore non consentito.");
            scanner.next();
            System.out.print("Numero righe: ");
        }
        int rB = scanner.nextInt();

        System.out.print("Numero colonne: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Hai inserito un valore non consentito.");
            scanner.next();
            System.out.print("Numero colonne: ");
        }
        int cB = scanner.nextInt();


        if (rA != rB || cA != cB) {

            System.out.println("Le matrici hanno dimensioni differenti.");

        } else {

            double[][] matrixA = new double[rA][cA];
            double[][] matrixB = new double[rB][cB];

            // riempio le matrici
            for (int i = 0; i < rA; i++) {
                for (int j = 0; j < cA; j++) {
                    matrixA[i][j] = r.nextDouble(10);
                    matrixB[i][j] = r.nextDouble(10);
                }
            }
            
            // stampa matrici A e B
            System.out.println("Matrice A");
            for (int i = 0; i < rA; i++) {
                for (int j = 0; j < cA; j++) {
                    System.out.print(matrixA[i][j] + " ");
                }
                System.out.println();
            }
            
            System.out.println("\nMatrice B");
            for (int i = 0; i < rB; i++) {
                for (int j = 0; j < cB; j++) {
                    System.out.print(matrixB[i][j] + " ");
                }
                System.out.println();
            }

            // somma ricorsiva
            double[][] matrixC = sumMatrix(matrixA, matrixB);

            System.out.println("\nMatrice C: somma dei valori di matrice A e matrice B");
            // stampo il risultato
            for (int i = 0; i < rA; i++) {
                for (int j = 0; j < cA; j++) {
                    System.out.print(matrixC[i][j] + " ");
                }
                System.out.println();
            }
        }

        scanner.close();
    }


    public static double[][] sumMatrix(double[][] mA, double[][] mB) {

        double[][] mC = new double[mA.length][mA[0].length];

        return sumMatrix(mA, mB, mC, 0, 0);
    }


    public static double[][] sumMatrix(double[][] mA, double[][] mB,
                                       double[][] mC, int i, int j) {

        mC[i][j] = mA[i][j] + mB[i][j];

        if (j < mA[0].length - 1) {

            return sumMatrix(mA, mB, mC, i, j + 1);

        } else if (i < mA.length - 1) {

            return sumMatrix(mA, mB, mC, i + 1, 0);

        } else {

            return mC;
        }
    }
}