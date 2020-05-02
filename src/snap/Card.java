package snap;

public class Card {
    private final String value;
    private final char suit;

    /**
     * @param value  Value of card
     * @param suit   Suit of card
     */
    public Card(String value, char suit) {
        // Set card values at creation
        this.value = value;
        this.suit = suit;
    }

    /**
     * @return Value of card
     */
    public String getValue() {
        return this.value;
    }

    /**
     * @return Suit of card
     */
    public char getSuit() {
        return this.suit;
    }

    /**
     * @return Card value
     */
    public String toString() {
        return "Card[" + this.getValue() + "," + this.getSuit() + "]";
    }

    /**
     * @return Easily readable value of card
     */
    public String display() {
        return String.format("%s%c", this.getValue(), this.getSuit());
    }

    public boolean equalValue(Card card) {
        return this.getValue().equals(card.getValue());
    }
}
