package coding.challenge.vending.machine;

import java.util.HashMap;
import java.util.Map;

public class Inventory<T> {

    private Map<T, Integer> inventory = new HashMap<>();

    public int getQuantity(T item) {
        Integer quantity = inventory.get(item);
        return quantity == null ? 0 : quantity;
    }   

    public boolean hasItem(T item) {
        return getQuantity(item) > 0;
    }

    public void clear() {}    
    public void add(T item) {}
    public void put(T item, int quantity) {}
    public void deduct(T item) {}
}
