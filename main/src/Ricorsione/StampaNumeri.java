package Ricorsione;

public class StampaNumeri {

    void main() {
        printWord(7123);
    }

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
}
