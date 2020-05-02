package snap;

import java.util.*;

public class Deck {

//    private final List<Card> cards = new ArrayList<>();
    private final LinkedList<Card> cards = new LinkedList<>();
    private final List<String> values;
    private final List<Character> suits;

    /**
     * Generate default deck of cards on construction
     */
    public Deck () {
        values = Arrays.asList("A","2","3","4","5","6","7","8","9","10","J","Q","K");
        suits = Arrays.asList('C','D','H','S');
        generateDeck();
    }

    /**
     * Generate custom deck of cards with given values and suits
     *
     * @param values List of valid card values
     * @param suits List of valid suits
     */
    public Deck (List<String> values, List<Character> suits) {
        this.values = values;
        this.suits = suits;
    }

    /**
     * Generate a deck of cards with given values and suits
     */
    private void generateDeck() {
        for (Character s : suits) {
            for (String n : values) {
                cards.add(new Card(n, s));
            }
        }
    }

    /**
     * @return List of all cards in the deck
     */
    public LinkedList<Card> getDeck() {
        return cards;
    }

    /**
     * Shuffle the deck of cards
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Deal top card in deck to player
     *
     * @return Top card in deck
     */
    public Card deal() {
        // Return top card in deck
        return cards.pop();
    }

}
