package coding.challenge.deck;

import coding.challenge.card.Card;
import coding.challenge.card.Pack;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
 
public class Deck<T extends Card> implements Iterable<T> {

    private final List<T> cards; // all cards    

    public Deck(Pack pack) {
        this.cards = pack.getCards();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public List<T> dealHand(int numberOfCards) {
        // code for dealing a hand
        return null;
    }

    public T dealCard() {
        // code for dealing a single card
        return null;
    }

    public int remainingCards() {
        return cards.size();
    }

    public void removeCards(List<T> cards) {
        // code for removing cards
    }

    @Override
    public Iterator<T> iterator() {
        // implementing a cards iterator
        return null;
    }
}
