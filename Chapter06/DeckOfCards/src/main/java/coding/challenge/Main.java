package coding.challenge;

import coding.challenge.card.ClassicalCard;
import coding.challenge.card.ClassicalPack;
import coding.challenge.card.ClassicalSuit;
import coding.challenge.deck.Deck;

public class Main {

    public static void main(String[] args) {

        // create a single classical card
        ClassicalCard sevenHeart = new ClassicalCard(ClassicalSuit.HEARTS, 7);       

        // create a complete deck of classical cards      
        ClassicalPack cp = new ClassicalPack();                   
        Deck deck = new Deck(cp);
        
        System.out.println("Remaining cards: " + deck.remainingCards());
    }
}
