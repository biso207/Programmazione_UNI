package BlackJack;

public class Player {
    private final String username;
    private int balance;
    private int bet;

    private int wins, losses, ties;

    // constructor //
    public Player(String username, int balance) {
        this.username = username;
        this.balance = balance;

        wins=losses=ties=0;
    }

    // SETTERS //
    public void updateBalance(int newBalance) {
        balance += newBalance;
    }

    public boolean setBet(int bet) {
        if (bet>balance) return false;

        this.bet = bet;
        balance -= bet; // riduzione saldo

        return true;
    }

    // GETTERS //
    public String getUsername() { return username; }
    public int getBalance() { return balance; }
    public int getBet() { return bet; }

    public int getTies() { return ties; }

    public int getLosses() { return losses; }

    public int getWins() { return wins; }

    // UPDATE STATS //
    public void setWin() { wins++; }
    public void setTie() { ties++; }
    public void setLoss() { losses++; }
}
