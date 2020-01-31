package coding.challenge.cards;

public class ClassicalCard extends Card {
   
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 13;
    
    public ClassicalCard(ClassicalSuit suit, int value) {
        super(suit, value);
    }

    public static int getMinValue() {
        return MIN_VALUE;
    }

    public static int getMaxValue() {
        return MAX_VALUE;
    }        
}
