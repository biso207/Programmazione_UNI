package BlackJack;

public class Main {
    // entry point //
    void main() {
        BlackJack gioco = new BlackJack();

        System.out.println("=== BLACK JACK ===");
        System.out.println("Benvenuto nel gioco del Black Jack");

        boolean play;
        do {
            play = gioco.playMatch();
        } while (play);

        System.out.println("Ciao e grazie per aver giocato");

        gioco.close();
    }
}
