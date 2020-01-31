package coding.challenge.card;

import java.util.ArrayList;
import java.util.List;

public final class ClassicalPack extends Pack {
    
    public ClassicalPack() {
        super.setCards(build());
    }
    
    @Override
    protected List<ClassicalCard> build() {
        
        List<ClassicalCard> cards = new ArrayList<>();
        
        for (ClassicalSuit suit : ClassicalSuit.values()) {
            for (int rank = ClassicalCard.getMinValue();
                    rank <= ClassicalCard.getMaxValue(); rank++) {
                cards.add(new ClassicalCard(suit, rank));
            }
        }
        
        return cards;
    }
}
