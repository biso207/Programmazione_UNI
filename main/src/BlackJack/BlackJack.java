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
    private boolean firstScreen = true;

    // Numero di mazzi utilizzati e soglia per ricreare la scarpa
    private static final int NUMBER_OF_DECKS = 6;
    private static final int CARDS_PER_DECK = 52;
    private static final int RECREATE_DECK_AT = 60;

    public BlackJack() {
        playerDeck = new ArrayList<>();
        dealerDeck = new ArrayList<>();
        matchDeck = new ArrayList<>();

        // Inserimento dei 13 valori del mazzo con i rispettivi punteggi
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
        deck.put("A", 1); // Asso: il calcolo del punteggio lo considera 1 oppure 11

        p = createPlayer();
        createMatchDeck();

        dealerWin=playerWin=push=dealerBJ=playerBJ=false;
    }

    // metodo per giocare una partita //
    public boolean playMatch() {
        // La schermata viene pulita solo quando si passa a una nuova schermata,
        // mai subito dopo aver stampato un messaggio o una richiesta di input.
        if (!firstScreen) {
            clearConsole();
            System.out.println("=== BLACK JACK ===");
        } else {
            firstScreen = false;
        }

        System.out.println("Benvenuto " + p.getUsername());
        System.out.println("Saldo: € " + p.getBalance());
        System.out.println("\n[1] Make a bet");
        System.out.println("[2] Esci dal Gioco");

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
            clearConsole();
            System.out.println("Hey " + p.getUsername() + " il saldo è insufficiente o la puntata non è valida!");
            System.out.print("Ricarica [€]: ");
            int newBalance = scanner.nextInt();
            if (newBalance > 0) p.updateBalance(newBalance);
        }

        // the match starts //
        // reset decks sums and match status //
        sumDealerCards=sumPlayerCards=0;
        dealerWin=playerWin=push=dealerBJ=playerBJ=false;
        playerDeck.clear();
        dealerDeck.clear();

        // shuffle or create the match deck //
        // Se le carte rimaste non bastano per una nuova partita, ricreo i 6 mazzi.
        if (matchDeck.size() < RECREATE_DECK_AT) createMatchDeck();
        else Collections.shuffle(matchDeck);

        // 2 initial cards to the player //
        addCardToPlayer();
        addCardToPlayer();

        // 2 initial cards to the dealer //
        addCardToDealer();
        addCardToDealer();

        // PLAYER LOOP //
        boolean keepPlaying;
        do {
            keepPlaying=playerTurn();
        } while (keepPlaying);

        // DEALER LOOP //
        // Il banco non gioca se il giocatore ha già sballato.
        if (!dealerWin) {
            do {
                keepPlaying=dealerTurn();
            } while (keepPlaying);
        }

        // checking the winner by comparing the final scores //
        if (!dealerWin && !playerWin && !dealerBJ && !playerBJ && !push) {
            if (sumPlayerCards > sumDealerCards) playerWin = true;
            else if (sumDealerCards > sumPlayerCards) dealerWin = true;
        }

        // checking the tie //
        if (!dealerWin && !playerWin && !dealerBJ && !playerBJ && !push) {
            System.out.println("Avete Pareggiato!");
            p.setTie();

            // updating balance //
            p.updateBalance(p.getBet()); // returning the bet to the player //
        }

        // checking winner //
        if (dealerWin && !dealerBJ) {
            System.out.println("Mi spiace " + p.getUsername() + "... Hai Perso!");
            p.setLoss();
        }
        else if (playerWin && !playerBJ) {
            System.out.println("Fortunato " + p.getUsername() + "... Hai Vinto!");
            p.setWin();

            // updating balance //
            p.updateBalance(p.getBet()*2); // returning the bet and the winning //
        }
        else if (dealerBJ) {
            p.setLoss();
        }
        else if (playerBJ && !push) {
            p.setWin();
        }

        // resetting decks //
        playerDeck.clear();
        dealerDeck.clear();

        System.out.println("\nSaldo attuale: € " + p.getBalance());
        System.out.println("Vittorie: " + p.getWins() + " | Sconfitte: " + p.getLosses() + " | Pareggi: " + p.getTies());
        waitForEnter();

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
        while (balance < 0) {
            System.out.print("Inserisci un saldo non negativo [€]: ");
            balance = scanner.nextInt();
        }

        clearConsole();
        return new Player(username, balance);
    }

    // method to make a bet //
    public boolean makeABet(Player p) {
        clearConsole();
        System.out.println(p.getUsername() + ", seleziona una puntata:");
        System.out.println("[1] € 1");
        System.out.println("[2] € 5");
        System.out.println("[3] € 10");
        System.out.println("[4] € All in");
        System.out.println("[5] Scegli");

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
                System.out.print("Puntata: ");
                int bet = scanner.nextInt();
                return p.setBet(bet);
            }
        }

        return false;
    }

    // method to create the deck for the match //
    public void createMatchDeck() {
        matchDeck.clear();

        // filling the deck of the match with 6 decks (312 cards) //
        // Ogni carta presente nella HashMap viene inserita 4 volte per mazzo,
        // una per ciascun seme. I semi sono trascurati nel progetto.
        for (int i=0; i<NUMBER_OF_DECKS; i++) {
            for (int j=0; j<CARDS_PER_DECK / deck.size(); j++) {
                matchDeck.addAll(deck.values());
            }
        }

        // shuffle of the deck //
        Collections.shuffle(matchDeck);
    }

    // method to add a card to the player //
    public void addCardToPlayer() {
        if (matchDeck.isEmpty()) createMatchDeck();
        playerDeck.add(matchDeck.removeFirst()); // removing the drawn card //
    }

    // method to add a card to the dealer //
    public void addCardToDealer() {
        if (matchDeck.isEmpty()) createMatchDeck();
        dealerDeck.add(matchDeck.removeFirst()); // removing the drawn card //
    }

    // method for the player turn //
    public boolean playerTurn() {
        clearConsole();
        System.out.println("=== BLACK JACK ===");
        System.out.println("Saldo: € " + p.getBalance() + " | Puntata: € " + p.getBet());
        System.out.println("\nCarte Dealer:");
        System.out.println(dealerDeck.getFirst());
        System.out.println("?");

        System.out.println("\nCarte " + p.getUsername() + ":");
        for (int playerCard : playerDeck) {
            System.out.println(playerCard);
        }
        sumPlayerCards = calculateScore(playerDeck);
        System.out.println("Punteggio: " + sumPlayerCards);

        // blackjack => the player wins
        if (sumPlayerCards==21 && playerDeck.size()==2) {
            playerBJ=true;
            System.out.println("Blackjack!");
            return false; // stop player turn //
        }

        // busted //
        if (sumPlayerCards>21) {
            dealerWin=true;
            System.out.println("Hai sballato!");
            return false; // stop player turn //
        }

        System.out.println("\nYour turn");
        System.out.println("[1] Draw");
        System.out.println("[2] Stay");
        boolean canDouble = p.getBet() <= p.getBalance();
        if (canDouble) System.out.println("[3] Double Down");

        int choice2;
        do {
            System.out.print("Choice: ");
            choice2 = scanner.nextInt();
        } while (choice2 < 1 || choice2 > (canDouble ? 3 : 2));

        switch (choice2) {
            case 1 -> addCardToPlayer();
            case 2 -> { return false; } // stop player turn //
            case 3 -> {
                if (p.doubleBet()) {
                    addCardToPlayer(); // drawing a card
                    sumPlayerCards = calculateScore(playerDeck);
                    if (sumPlayerCards > 21) {
                        dealerWin = true;
                        clearConsole();
                        System.out.println("=== BLACK JACK ===");
                        System.out.println("Carte " + p.getUsername() + ":");
                        for (int playerCard : playerDeck) System.out.println(playerCard);
                        System.out.println("Punteggio: " + sumPlayerCards);
                        System.out.println("Hai sballato!");
                    }
                    return false; // stop player turn //
                }
                return true;
            }
        }

        return true;
    }

    // method for the dealer turn //
    public boolean dealerTurn() {
        sumDealerCards = calculateScore(dealerDeck);

        // blackjack => controllo del blackjack naturale del banco
        if (dealerDeck.size()==2 && sumDealerCards==21) {
            clearConsole();
            System.out.println("=== BLACK JACK ===");
            System.out.println("Carte Dealer:");
            for (int dealerCard : dealerDeck) System.out.println(dealerCard);

            if (playerBJ) { // both blackjacks //
                System.out.println("Push!!! Entrambi avete fatto BlackJack");
                push=true;
                p.setTie();
                p.updateBalance(p.getBet()); // returning the bet to the player //
            }
            else { // dealer blackjack //
                System.out.println("BlackJack Dealer! Hai Perso!");
                dealerBJ = true;
            }
            return false; // stop dealer turn //
        }

        // Il blackjack naturale del giocatore vince se il banco non ha blackjack.
        if (playerBJ) {
            clearConsole();
            System.out.println("=== BLACK JACK ===");
            System.out.println("Carte Dealer:");
            for (int dealerCard : dealerDeck) System.out.println(dealerCard);
            System.out.println("BlackJack!!! Hai Vinto!");

            // updating balance //
            p.updateBalance((int) Math.round(p.getBet()*1.5));
            playerWin = true;
            return false; // stop dealer turn //
        }

        // busted //
        if (sumDealerCards>21) {
            clearConsole();
            System.out.println("=== BLACK JACK ===");
            System.out.println("Carte Dealer:");
            for (int dealerCard : dealerDeck) System.out.println(dealerCard);

            System.out.println("Il Banco ha sballato! Hai Vinto!");
            playerWin = true;
            return false; // stop dealer turn //
        }

        // Il banco pesca fino a 16 e si ferma a 17 o più.
        if (sumDealerCards <= 16) {
            addCardToDealer();
            return true;
        }

        // Il banco si è fermato: mostro la mano completa e il risultato verrà calcolato in playMatch().
        clearConsole();
        System.out.println("=== BLACK JACK ===");
        System.out.println("Carte Dealer:");
        for (int dealerCard : dealerDeck) System.out.println(dealerCard);
        System.out.println("Punteggio Dealer: " + sumDealerCards);
        System.out.println("\nCarte " + p.getUsername() + ":");
        for (int playerCard : playerDeck) System.out.println(playerCard);
        System.out.println("Punteggio Giocatore: " + sumPlayerCards);

        return false;
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

    // Pulisce la schermata senza cancellare subito i messaggi appena stampati.
    private void clearConsole() {
        if (!Boolean.getBoolean("blackjack.noClear")) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

    // Mantiene visibile il risultato finché l'utente non decide di continuare.
    private void waitForEnter() {
        scanner.nextLine(); // consuma il carattere INVIO rimasto dopo nextInt()
        System.out.print("Premi INVIO per continuare...");
        scanner.nextLine();
    }

    // metodo per chiusura e pulizia //
    public void close() {
        scanner.close();
    }
}
