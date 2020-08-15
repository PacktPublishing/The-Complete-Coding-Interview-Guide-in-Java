package coding.challenge;
 
import coding.challenge.card.Card;
import coding.challenge.card.Pack;
import coding.challenge.card.StandardCard;
import coding.challenge.card.StandardPack;
import coding.challenge.card.StandardSuit;
import coding.challenge.deck.Deck;

public class Main {

    public static void main(String[] args) {

        // create a single classical card
        Card sevenHeart = new StandardCard(StandardSuit.HEARTS, 7);              

        // create a complete deck of standard cards      
        Pack cp = new StandardPack();                   
        Deck deck = new Deck(cp);
        
        System.out.println("Remaining cards: " + deck.remainingCards());
    }
}
