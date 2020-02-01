package coding.challenge.vending.machine;

import java.util.List;
import java.util.Map;

public interface Selector {

    public int checkPrice(Item item);
    public void insertCoin(Coin coin);
    public Map<Item, List<Coin>> getItemAndChange();

    public List<Coin> refund();
    public void reset();    
}
