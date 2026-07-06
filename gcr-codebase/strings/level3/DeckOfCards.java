import java.util.Scanner;

class DeckOfCards {
    public static String[] initializeDeck(String[] suits, String[] ranks) {
        int numberOfCards = suits.length * ranks.length;
        String[] deck = new String[numberOfCards];
        int index = 0;

        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index] = rank + " of " + suit;
                index++;
            }
        }

        return deck;
    }

    public static String[] shuffleDeck(String[] deck) {
        int numberOfCards = deck.length;
        for (int i = 0; i < numberOfCards; i++) {
            int randomCardNumber = i + (int) (Math.random() * (numberOfCards - i));
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
        return deck;
    }

    public static String[][] distributeCards(String[] deck, int numberOfCards, int numberOfPlayers) {
        if (numberOfCards > deck.length || numberOfCards % numberOfPlayers != 0) {
            return new String[0][0];
        }

        int cardsPerPlayer = numberOfCards / numberOfPlayers;
        String[][] players = new String[numberOfPlayers][cardsPerPlayer];
        int cardIndex = 0;

        for (int i = 0; i < numberOfPlayers; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                players[i][j] = deck[cardIndex];
                cardIndex++;
            }
        }

        return players;
    }

    public static void printPlayersCards(String[][] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1) + " cards:");
            for (int j = 0; j < players[i].length; j++) {
                System.out.println("  " + players[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10",
                "Jack", "Queen", "King", "Ace"};

        String[] deck = initializeDeck(suits, ranks);
        shuffleDeck(deck);

        System.out.print("Enter number of cards to distribute: ");
        int numberOfCards = scanner.nextInt();
        System.out.print("Enter number of players: ");
        int numberOfPlayers = scanner.nextInt();

        if (numberOfCards <= 0 || numberOfPlayers <= 0) {
            System.out.println("Number of cards and players must be positive.");
            return;
        }

        String[][] players = distributeCards(deck, numberOfCards, numberOfPlayers);
        if (players.length == 0) {
            System.out.println("Cards cannot be distributed equally to the players.");
            return;
        }

        printPlayersCards(players);
    }
}
