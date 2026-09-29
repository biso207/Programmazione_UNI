/*
Luca Bisognin - 17/09/2026
Lezione 3 - Programmazione
*/

package Lezione3;

import java.util.*;

public class AreaTriangolo {
   public static void main(String[] args) {
        // scanner per l'input utente
        Scanner s = new Scanner(System.in);

        // variabili per i vari calcoli
        double base, altezza;

        System.out.println("Calcolo area del triangolo");

        // INPUT UTENTE //

        // base
        while (true) {
            try {
                System.out.println("Inserire valore per la base:");
                base = s.nextDouble();

                break;
            } catch (InputMismatchException e) {
                System.out.println("Hai inserito un valore non valido.");
                s.next();
            }
        }

        // altezza
        while (true) {
            try {
                System.out.println("Inserire valore per l'altezza:");
                altezza = s.nextDouble();

                break;
            } catch (InputMismatchException e) {
                System.out.println("Hai inserito un valore non valido.");
                s.next();
            }
        }


        double area = (base*altezza)/2;
        System.out.println("Il valore dell'area del triangolo è: " + area);

        s.close(); // chiusura buffer scrittura
    }
}
