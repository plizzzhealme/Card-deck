package deck;

import java.util.Arrays;
import java.util.Random;

public class Main {

    private static final int HANDS = 4;
    private static final int CARDS_PER_HAND = 13;

    public static void main(String[] args) {
        Card[] deck = Card.values();
        printDeck(deck);

        shuffle(deck);
        printDeck(deck);

        Card[][] hands = new Card[HANDS][CARDS_PER_HAND];
        cardsToHands(hands, deck);
        printCardsOnHands(hands);

        sortCardsOnHands(hands);
        printCardsOnHands(hands);
    }

    static void shuffle(Card[] deck) {
        Random rnd = new Random();
        for (int i = 1; i < deck.length; i++) {
            int j = rnd.nextInt(i);
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    static void cardsToHands(Card[][] hands, Card[] deck) {
        int from = 0;
        int to = CARDS_PER_HAND;
        for (int i = 0; i < HANDS; i++) {
            hands[i] = Arrays.copyOfRange(deck, from, to) ;
            from += CARDS_PER_HAND;
            to += CARDS_PER_HAND;
        }
    }

    static void sortCardsOnHands (Card[][] hands) {
        for (Card[] card:
             hands) {
            Arrays.sort(card);
        }
    }

    static void printCardsOnHands(Card[][] hands) {
        System.out.println("Cards on hands:");
        for (Card[] hand : hands) {
            System.out.println(Arrays.toString(hand));
        }
    }

    static void printDeck(Card[] deck) {
        System.out.println("Your deck:");
        System.out.println(Arrays.toString(deck));
    }
}
