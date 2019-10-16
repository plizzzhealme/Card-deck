package deck;

import java.util.Arrays;
import java.util.Random;

class Main {

    private static final int HANDS = 4;
    private static final int CARDS_PER_HAND = 13;

    public static void main(String[] args) {
        Card[] deck = Card.values();
        shuffle(deck);
        Card[][] hands = new Card[HANDS][CARDS_PER_HAND];
        cardsToHands(hands, deck);
        sortCardsOnHands(hands);
        printCardsOnHands(hands);
    }

    private static void shuffle(Card[] deck) {
        Random rnd = new Random();
        for (int i = 1; i < deck.length; i++) {
            int j = rnd.nextInt(i);
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    private static void printDeck(Card[] deck) {
        System.out.println(Arrays.toString(deck));
    }

    private static void cardsToHands(Card[][] hands, Card[] deck) {
        int from = 0;
        int to = CARDS_PER_HAND;
        for (int i = 0; i < HANDS; i++) {
            hands[i] = Arrays.copyOfRange(deck, from, to) ;
            from += CARDS_PER_HAND;
            to += CARDS_PER_HAND;
        }
    }

    private static void printHandInfo(Card[] hand) {
        int spade = 0;
        int heart = 0;
        int diamond = 0;
        int club = 0;
        for (Card card : hand) {
            if (card.compareTo(Card.HA) < 0) {
                spade++;
            } else if (card.compareTo(Card.DA) < 0) {
                heart++;
            } else if (card.compareTo(Card.CA) < 0) {
                diamond++;
            } else {
                club++;
            }
        }
        System.out.println(spade + " - " + heart + " - " + diamond + " - " + club);
    }

    private static void printCardsOnHands(Card[][] hands) {
        for (Card[] hand : hands) {
            printDeck(hand);
            printHandInfo(hand);
        }
    }

    private static void sortCardsOnHands(Card[][] hands) {
        for (Card[] card: hands) {
            Arrays.sort(card);
        }
    }
}