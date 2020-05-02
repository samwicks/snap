package snap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {

    private final List<Card> cards = new ArrayList<>();
    private final List<String> validNumbers;
    private final List<Character> validSuits;

    /**
     * Generate default deck of cards on construction
     */
    public Deck () {
        validNumbers = Arrays.asList("A","2","3","4","5","6","7","8","9","10","J","Q","K");
        validSuits = Arrays.asList('C','D','H','S');
        generateDeck();
    }

    /**
     * Generate custom deck of cards with given numbers and suits
     *
     * @param numbers List of valid card numbers
     * @param suits List of valid suits
     */
    public Deck (List<String> numbers, List<Character> suits) {
        validNumbers = numbers;
        validSuits = suits;
    }

    /**
     * Generate a deck of cards with given numbers and suits
     */
    private void generateDeck() {
        int count = 0;
        for (Character s : validSuits) {
            for (String n : validNumbers) {
                cards.add(new Card(n, s));
                count++;
            }
        }
    }

    /**
     * @return List of all cards in the deck
     */
    public List<Card> getDeck() {
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
        // Return null if no cards left in deck
        Card result = null;

        // Check if deck has any cards left to deal
        if (!getDeck().isEmpty()) {
            // Return top card in deck
            Card card = getDeck().get(0);
            cards.remove(0);
            result = card;
        }
        return result;
    }

}
