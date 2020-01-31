package coding.challenge;

import coding.challenge.cards.ClassicalCard;
import coding.challenge.cards.ClassicalPack;
import coding.challenge.cards.ClassicalSuit;
import coding.challenge.cards.Deck;

public class Main {

    public static void main(String[] args) {

        // create a single classical card
        ClassicalCard sevenHeart = new ClassicalCard(ClassicalSuit.HEARTS, 7);

        // create a complete deck of classical cards      
        ClassicalPack cp = new ClassicalPack();
        Deck deck = new Deck(cp.build());
        deck.shuffle();

        System.out.println("Remaining cards: " + deck.remainingCards());        
    }
}
