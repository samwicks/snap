package snap;

public class Card {
    private final char cardNumber;
    private final char cardSuit;

    /**
     * @param number Number of card
     * @param suit   Suit of card
     */
    public Card(Character number, Character suit) {
        // Set card values at creation
        cardNumber = number;
        cardSuit = suit;
    }

    /**
     * @return Number of card
     */
    public char getNumber() {
        return this.cardNumber;
    }

    /**
     * @return Suit of card
     */
    public char getSuit() {
        return this.cardSuit;
    }

    /**
     * @return Card value
     */
    public String toString() {
        return "Card[" + this.getNumber() + "," + this.getSuit() + "]";
    }

    /**
     * @return Easily readable value of card
     */
    public String display() {
        return String.format("%c%c", this.getNumber(), this.getSuit());
    }
}
