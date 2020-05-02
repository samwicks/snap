package snap;

import java.util.concurrent.ThreadLocalRandom;

public class Snap {

    public static void main(String[] args) throws InterruptedException {

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

    private static void play(int turn, Player[] players, Deck deck) throws InterruptedException {
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

            // All players 'think' before next turn
            // Array of player's index and their think time
            Integer[] winner = {0, players[0].think()};

            // Go through rest of players
            for (int i = 1; i < players.length; i++) {
                int think = players[i].think();
                if (think < winner[1]) {
                    winner[0] = i;
                    winner[1] = think;
                }
            }

            // Sleep for quickest player's thinking time
            Thread.sleep(winner[1]);
            // Check if it's a snap
            if (card.equalValue(previous)) {
                // Game is over, return
                System.out.format("SNAP! %s is the winner!!", players[winner[0]].getName());
                return;
            }

            // Continue to next player
            previous = card;
            turn++;
        }

        // No more cards in deck... draw
        System.out.println("No more cards in the deck! It's a draw!");
    }
}
