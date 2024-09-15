//Luis Cruz Pereda, Jose Arellano, Adam Barakat, Ethan Smith
// 09/15/2024
// Modify the Black Jack game with a new Card class, added a betting system and made 
// adjustment where if you get an ace it will automaticly swtich to 1 if over 21. Also 
// added a win. lose, and tie tracking for each game. updated game where it will end if 
// player money reaches 0 and if busted will end game and go stright to next game.
// to compile in terminal type: javac BlackJack.java
// to run in terminal type: java BlackJack

public class Card {
    private int value; // The value of the card (e.g., 2 through 10, 10 for face cards, 11 for Ace)
    private String suit; // The suit of the card (e.g., Hearts, Diamonds, Clubs, Spades)
    private String rank; // The rank of the card (e.g., 2, 3, ..., 10, Jack, Queen, King, Ace)

    // Static variable to keep track of the player's balance
    private static int playerBalance = 1000; // Initial balance

    // Variable to store the current bet
    private static int currentBet = 0;

    // Constructor to initialize the card
    public Card(int value, String suit, String rank) {
        this.value = value;
        this.suit = suit;
        this.rank = rank;
    }

    // Accessor for the card's value
    public int getValue() {
        return value;
    }

    // Mutator for the card's value
    public void setValue(int value) {
        this.value = value;
    }

    // Accessor for the card's suit
    public String getSuit() {
        return suit;
    }

    // Mutator for the card's suit
    public void setSuit(String suit) {
        this.suit = suit;
    }

    // Accessor for the card's rank
    public String getRank() {
        return rank;
    }

    // Mutator for the card's rank
    public void setRank(String rank) {
        this.rank = rank;
    }

    // Override toString() method to provide a string representation of the card
    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    // Method to place a bet
    public static void placeBet(int amount) {
        if (amount > playerBalance) {
            throw new IllegalArgumentException("Insufficient funds for this bet.");
        }
        currentBet = amount;
        playerBalance -= amount;
        System.out.println("Bet placed: $" + amount);
    }

    // Method to settle the bet after the game
    public static void settleBet(boolean win, boolean tie) {
        if (tie) {
            // Return the bet amount if it's a tie
            playerBalance += currentBet;
            System.out.println("Bet amount returned. Balance is now: $" + playerBalance);
         }else if (win) {
            playerBalance += currentBet * 2; // Win: double the bet
            System.out.println("Bet settled. Balance is now: $" + playerBalance);
        } else {
            System.out.println("You lost. Balance is now: $" + playerBalance);
        }
        currentBet = 0; // Reset the bet amount after settling
    }

    // Method to check the player's balance
    public static int getPlayerBalance() {
        return playerBalance;
    }

    // Method to display current bet
    public static int getCurrentBet() {
        return currentBet;
    }
}

/*
    1. How did you go about solving this problem?
    
    First we made a class Card we tried to go in a live group however some reason some of us
    couldn't enter to work on one of the days so we were talking in pronto, once we had the 
    class Card we decided to add a betting mechanics, then we wanted to add more to the game,
    like having a ace become a 1 when over 21, or add a second card to say hidden when dealer
    first started. We also added if a player runs out of money game would end. 

    2. What made the problem challenging?

      The problem I ran into was when my a player would tie with the dealer then the program 
    would not return the bet amount would still take the money and consider it a lost. 
    What was happening was I had if player won theis would happen else player tie then this
    else if lost then this would happen, so the program would think that a tie was still a lost
    I had to set it up a if tie situation and blooean tie with a false and ture. in line 85 to 98
    and added the blooean tie in the class Card in other for the program to read ties, loses and wins.

    3.What tasks did you perform in the group?
    I added the betting mechanic in the game, which was when I got it to work it was great until
    I go a tie, I had to look up why it having issues but once I did it made more issue why
    I was getting that issue.
*/