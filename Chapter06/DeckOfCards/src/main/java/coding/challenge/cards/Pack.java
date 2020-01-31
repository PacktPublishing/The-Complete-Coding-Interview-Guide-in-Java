package coding.challenge.cards;

import java.util.List;

public interface Pack<T extends Card> {

    public List<T> build();
}
