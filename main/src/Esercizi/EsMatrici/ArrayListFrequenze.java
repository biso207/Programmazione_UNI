/*
Luca Bisognin - 12/11/2026
Es ArrayListFrequenze
*/

package Esercizi.EsMatrici;

import java.util.*;

public class ArrayListFrequenze {
    void main() {
        ArrayList<Integer> lista = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int n;
        do {
            System.out.print("numero: ");
            n = scanner.nextInt();
            if (n<1 || n>10) break;
            lista.add(n);
        } while(true);

        // SOLUZIONE BASE //
        int[] conteggi = new int[9];
        for (int num : lista) conteggi[num]++;

        // stampa occorrenze //
        for (int i=0; i<lista.size(); i++) {
            if (conteggi[i]==0) continue;
            System.out.println(i + " -> " + conteggi[i]);
        }

        // OTTIMIZZATO //
        HashMap<Integer, Integer> frequenze = new HashMap<>();

        for (int num : lista) {
            frequenze.put(
                    num,
                    frequenze.getOrDefault(num, 0) + 1
            );
        }

        for (Map.Entry<Integer, Integer> entry : frequenze.entrySet()) {
            System.out.println(
                    "Il numero " + entry.getKey() +
                            " compare " + entry.getValue() + " volte"
            );
        }
    }
}
