package coding.challenge.card;
 
import java.util.ArrayList;
import java.util.List;

public abstract class Pack<T extends Card> {

    private List<T> cards;

    protected abstract List<T> build();

    public int packSize() {
        return cards.size();
    }

    public List<T> getCards() {
        return new ArrayList<>(cards);
    }

    protected void setCards(List<T> cards) {
        this.cards = cards;
    }
}
