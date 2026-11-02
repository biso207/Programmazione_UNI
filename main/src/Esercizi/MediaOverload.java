/*
Luca Bisognin - 26/10/2026
Es 1 pag 66 - Metodi
*/

package Esercizi;

import java.util.*;

public class MediaOverload {
    void main() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> a = new ArrayList<>();

        do {
            System.out.print("Inserisci numero (0 per fermarti): ");
            int num = scanner.nextInt();

            if (num==0) break;

            a.add(num);
        } while(true);

        int[][] matrix = createMatrix();

        System.out.println("media 3 numeri: " + getMedia(1, 5, 9));
        System.out.println("media dei tuoi numeri: " + getMedia(a));
        System.out.println("media valori di una matrice: " + getMedia(matrix));
    }

    // media di 3 interi //
    public static double getMedia(int a, int b, int c) {
        return (double) (a+b+c) /3;
    }


    // media di X interi //
    public static double getMedia(ArrayList<Integer> arrayList) {
        int sum=0;
        for (int num : arrayList) sum += num;

        return (double) sum/arrayList.size();
    }


    // media numero indefinito di interi //
    public static double getMedia(int[][] matrix) {
        int sum=0, cont=0;
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) sum += matrix[i][j];
            cont+= matrix[i].length;
        }

        return (double) sum/cont;
    }


    // creazione matrice con numeri random 1-10 //
    public static int[][] createMatrix() {
        int [][] matrix = new int[5][5];

        Random rnd = new Random();

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix.length; j++) matrix[i][j] = rnd.nextInt(1,11);
        }

        return matrix;
    }
}
