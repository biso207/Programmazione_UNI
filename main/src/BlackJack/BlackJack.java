package BlackJack;

import java.util.*;

public class BlackJack {
    private final Scanner scanner = new Scanner(System.in);
    // deck //
    private final HashMap<String, Integer> deck = new HashMap<>();
    private final ArrayList<Integer> playerDeck, dealerDeck, matchDeck;

    private final Player p;

    private int sumPlayerCards, sumDealerCards;

    private boolean dealerWin, playerWin, push, dealerBJ, playerBJ;

    public BlackJack() {
        playerDeck = new ArrayList<>();
        dealerDeck = new ArrayList<>();
        matchDeck = new ArrayList<>();

        // Inserimento dei 13 valori del mazzo con i rispettivi punteggi (da 2 a 14)
        deck.put("2", 2);
        deck.put("3", 3);
        deck.put("4", 4);
        deck.put("5", 5);
        deck.put("6", 6);
        deck.put("7", 7);
        deck.put("8", 8);
        deck.put("9", 9);
        deck.put("10", 10);
        deck.put("J", 10); // Jack
        deck.put("Q", 10); // Donna
        deck.put("K", 10); // Re
        deck.put("A", 11); // Asso

        p = createPlayer();
        createMatchDeck();

        dealerWin=playerWin=push=dealerBJ=playerBJ=false;
    }

    // metodo per giocare una partita //
    public boolean playMatch() {
        System.out.println("""
                [1] Make a bet
                [2] Esci dal Gioco
                """);
        int choice;
        do {
            System.out.print("Scelta: ");
            choice = scanner.nextInt();
        } while (choice < 1 || choice > 2);

        switch (choice) {
            case 1 -> {} // make a bet //
            case 2 -> { return false; } // quit the game
        }

        // let's make a bet to the player //
        while (!makeABet(p)) {
            System.out.println("Hey" + p.getUsername() + " il saldo è insufficiente!");
            System.out.print("Ricarica [€]: ");
            int newBalance = scanner.nextInt();
            p.updateBalance(newBalance);
        }

        // the match starts //
        System.out.println("Iniziamo la partita");

        // reset decks sums //
        sumDealerCards=sumPlayerCards=0;

        // shuffle or create the match deck //
        // todo: aggiungere la creazione in caso di carte insufficienti
        Collections.shuffle(matchDeck);

        // 2 initial cards to the player //
        addCardToPlayer();
        addCardToPlayer();

        // 2 initial cards to the dealer //
        addCardToDealer();
        addCardToDealer();

        // printing dealer cards //
        System.out.println("Carte Dealer:");
        System.out.println(dealerDeck.getFirst());
        System.out.println("?");

        // PLAYER LOOP //
        boolean keepPlaying;
        do {
            keepPlaying=playerTurn();
        } while (keepPlaying);

        // DEALER LOOP //
        do {
            keepPlaying=dealerTurn();
        } while (keepPlaying);

        // checking the tie //
        if (sumDealerCards==sumPlayerCards && !push && !dealerBJ && !playerBJ) {
            System.out.println("Avete Pareggiato!");
            p.setTie();

            // updating balance //
            p.updateBalance(p.getBet()); // returning the bet to the player //
        }

        // checking winner //
        if (!dealerBJ && !playerBJ && !playerWin && !dealerWin) {
            playerWin = sumPlayerCards > sumDealerCards;
            dealerWin = !playerWin;

            if (playerWin) {
                System.out.println("Fortunato " + p.getUsername() + "... Hai Vinto!");
                p.setWin();

                // updating balance //
                p.updateBalance(p.getBet()*2); // winning the bet //
            }
            if (dealerWin) {
                System.out.println("Mi spiace " + p.getUsername() + "... Hai Perso!");
                p.setLoss();
            }
        }

        // resetting decks //
        playerDeck.clear();
        dealerDeck.clear();

        return true;
    }

    // create player //
    public Player createPlayer() {
        System.out.println("- Crea il tuo utente -");

        // nome utente
        System.out.print("Nome: ");
        String username = scanner.nextLine();

        // bilancio iniziale
        System.out.print("Saldo [€]: ");
        int balance = scanner.nextInt();

        return new Player(username, balance);
    }

    // method to make a bet //
    public boolean makeABet(Player p) {
        System.out.println(p.getUsername() + ", seleziona una puntata:");
        System.out.println("""
                [1] € 1
                [2] € 5
                [3] € 10
                [4] € All in
                [5] Scegli
                """);
        int choice;
        do {
            System.out.print("Scelta: ");
            choice = scanner.nextInt();
        } while (choice < 1 || choice > 5);

        // setting puntata //
        switch (choice) {
            case 1 -> { return p.setBet(1); }
            case 2 -> { return p.setBet(5); }
            case 3 -> { return p.setBet(10); }
            case 4 -> { return p.setBet(p.getBalance()); }
            case 5 -> {
                System.out.println("Puntata: ");
                int bet = scanner.nextInt();
                return p.setBet(bet);
            }
        }

        return true;
    }

    // method to create the deck for the match //
    public void createMatchDeck() {
        // filling the deck of the match with 132 cards //
        for (int i=0; i<6; i++) {
            for (int j=0; j<52; j++) matchDeck.add(deck.get(i));
        }

        // shuffle of the deck //
        Collections.shuffle(matchDeck);
    }

    // method to add a card to the player //
    public void addCardToPlayer() {
        playerDeck.add(matchDeck.getFirst());
        matchDeck.remove(matchDeck.getFirst()); // removing the drawn card //
    }

    // method to add a card to the dealer //
    public void addCardToDealer() {
        dealerDeck.add(matchDeck.getFirst());
        matchDeck.remove(matchDeck.getFirst()); // removing the drawn card //
    }

    // method for the player turn //
    public boolean playerTurn() {
        System.out.println("Carte " + p.getUsername() + ":");
        for (int playerCard : playerDeck) {
            System.out.println(playerDeck.get(playerCard));
            sumPlayerCards += calculateScore(playerDeck);
        }

        // blackjack => the player wins
        if (sumPlayerCards==21 && playerDeck.size()==2) {
            playerBJ=true;
            return false; // stop player turn //
        }

        // busted //
        if (sumPlayerCards>21) {
            dealerWin=true;
            return false; // stop player turn //
        }

        System.out.println("Your turn");
        System.out.println("""
                    [1] Draw
                    [2] Stay
                    """);
        if (p.getBet()*2<=p.getBalance()) System.out.println("[3] Double Down");

        int choice2;
        do {
            System.out.print("Choice: ");
            choice2 = scanner.nextInt();
        } while (choice2 < 1 || choice2 > 3);

        switch (choice2) {
            case 1 -> addCardToPlayer();
            case 2 -> { return false; } // stop player turn //
            case 3 -> {
                addCardToPlayer(); // drawing a card
                p.setBet(p.getBet()*2); // doubling the bet
                return false; // stop player turn //
            }
        }

        return true;
    }

    // method for the dealer turn //
    public boolean dealerTurn() {
        System.out.println("Dealer Deck:");
        for (int dealerCard : dealerDeck) {
            System.out.println(dealerDeck.get(dealerCard));
            sumDealerCards += calculateScore(dealerDeck);
        }

        // blackjack => the player wins
        if (sumDealerCards==21) {
            if (playerBJ && dealerDeck.size()==2) { // both blackjacks //
                System.out.println("Push!!! Entrambi avete fatto BlackJack");
                push=true;
            }
            else if (dealerDeck.size()==2) { // dealer blackjack //
                System.out.println("BlackJack Dealer! Hai Perso!");
                dealerBJ = true;
            }
            else if (playerBJ) { // player blackjack //
                System.out.println("BlackJack!!! Hai Vinto!");

                // updating balance //
                p.updateBalance((int) Math.round(p.getBet()*1.5));
            }
            return false; // stop dealer turn //
        }

        // busted //
        if (sumDealerCards>21) {
            if (dealerWin) { // player busted //
                System.out.println("Hai Sballato! Hai Perso!");
                return false; // stop dealer turn //
            }

            // player didn't bust //
            System.out.println("Il Banco ha sballato! Hai Vinto!");
            playerWin = true;

            // updating balance //
            p.updateBalance(p.getBet()*2); // winning the bet //
            return false; // stop dealer turn //
        }

        return sumDealerCards <= 16;
    }

    // method to calculate the score of a deck //
    public int calculateScore(ArrayList<Integer> deck) {

        int score = 0;
        int aces = 0;

        for (int card : deck) {

            if (card == 1) {
                score += 11;
                aces++;
            } else {
                score += card;
            }
        }

        while (score > 21 && aces > 0) {
            score -= 10;
            aces--;
        }

        return score;
    }


    // metodo per chiusura e pulizia //
    public void close() {
        scanner.close();
    }
}
