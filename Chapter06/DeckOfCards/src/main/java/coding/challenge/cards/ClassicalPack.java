package coding.challenge.cards;

import java.util.ArrayList;
import java.util.List;

public class ClassicalPack implements Pack<ClassicalCard> {

    @Override
    public List<ClassicalCard> build() {
        List<ClassicalCard> cc = new ArrayList<>();
        for (ClassicalSuit suit : ClassicalSuit.values()) {
            for (int rank = ClassicalCard.getMinValue(); rank <= ClassicalCard.getMaxValue(); rank++) {
                cc.add(new ClassicalCard(suit, rank));
            }
        }        

        return cc;
    }

}
