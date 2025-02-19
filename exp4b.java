import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Card {
    String suit;
    String rank;

    // Constructor
    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    // Display Card
    public void displayCard() {
        System.out.println(rank + " of " + suit);
    }

    // Getter for suit
    public String getSuit() {
        return suit;
    }

    // Getter for rank
    public String getRank() {
        return rank;
    }
}

public class CardCollection {

    private static List<Card> deck = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize deck with 52 cards
        initializeDeck();
        
        int choice;
        do {
            System.out.println("\nCard Management System");
            System.out.println("1. Add Card");
            System.out.println("2. Search Cards by Suit");
            System.out.println("3. Display All Cards");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addCard();
                    break;
                case 2:
                    searchCardsBySuit();
                    break;
                case 3:
                    displayAllCards();
                    break;
                case 4:
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);
    }

    // Initialize deck with 52 cards
    private static void initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(new Card(suit, rank));
            }
        }
    }

    // Add a new card to the deck
    private static void addCard() {
        scanner.nextLine(); // Consume the newline
        System.out.print("Enter Card Suit (Hearts, Diamonds, Clubs, Spades): ");
        String suit = scanner.nextLine();
        System.out.print("Enter Card Rank (Ace, 2, 3, ..., King): ");
        String rank = scanner.nextLine();

        // Validate and add the card
        if (isValidSuit(suit) && isValidRank(rank)) {
            deck.add(new Card(suit, rank));
            System.out.println("Card added successfully.");
        } else {
            System.out.println("Invalid card details. Please try again.");
        }
    }

    // Check if the suit is valid
    private static boolean isValidSuit(String suit) {
        return suit.equalsIgnoreCase("Hearts") || suit.equalsIgnoreCase("Diamonds") || 
               suit.equalsIgnoreCase("Clubs") || suit.equalsIgnoreCase("Spades");
    }

    // Check if the rank is valid
    private static boolean isValidRank(String rank) {
        String[] validRanks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        for (String validRank : validRanks) {
            if (validRank.equalsIgnoreCase(rank)) {
                return true;
            }
        }
        return false;
    }

    // Search cards by suit
    private static void searchCardsBySuit() {
        scanner.nextLine(); // Consume the newline
        System.out.print("Enter Suit to Search (Hearts, Diamonds, Clubs, Spades): ");
        String suit = scanner.nextLine();

        boolean found = false;
        for (Card card : deck) {
            if (card.getSuit().equalsIgnoreCase(suit)) {
                card.displayCard();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No cards found for the suit " + suit + ".");
        }
    }

    // Display all cards in the deck
    private static void displayAllCards() {
        if (deck.isEmpty()) {
            System.out.println("No cards in the deck.");
        } else {
            for (Card card : deck) {
                card.displayCard();
            }
        }
    }
}
