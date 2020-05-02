package snap;

import java.util.concurrent.ThreadLocalRandom;

public class Snap {

    public static void main(String[] args) {

        // Create deck of cards and shuffle
        Deck deck = new Deck();
        deck.shuffle();

        // Create list of players
        Player[] players = {new Player("George"), new Player("Desmond")};

        // Generate random number to determine who plays first
        int turn = ThreadLocalRandom.current().nextInt(0, players.length);

        // Begin game
        play(turn, players, deck);
    }

    private static void play(int turn, Player[] players, Deck deck) {
        Card previous = null;
        Card card;
        Player currentPlayer;

        // Continue playing while deck still has cards
        while (!deck.getDeck().isEmpty()) {
            currentPlayer = players[turn % players.length];
            card = deck.deal();
            System.out.format("%s turns card '%s'\n", currentPlayer.getName(), card.display());

            // If there is no previous card, continue to next player
            if (previous == null) {
                previous = card;
                turn++;
                continue;
            }

            // If there's a snap
            if (card.getNumber() == previous.getNumber()) {

                // All players 'think' to decide winner
                // Array of winning player's index and their think time
                Integer[] winner = {0, players[0].think()};

                // Go through rest of players
                for (int i = 1; i < players.length; i++) {
                    int think = players[i].think();
                    if (think < winner[1]) {
                        winner[0] = i;
                        winner[1] = think;
                    }
                }

                System.out.format("SNAP! %s is the winner!!", players[winner[0]].getName());
                // Game is over, return
                return;
            }
//            System.out.format("%s %s\n", card.getNumber(), previous.getNumber());
            // Continue to next player
            previous = card;
            turn++;
        }

        // No more cards in deck... draw
        System.out.println("No more cards in the deck! It's a draw!");
    }
}
