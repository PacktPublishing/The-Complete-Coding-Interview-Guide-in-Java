package coding.challenge.vending.machine;

import java.util.Collections;
import java.util.List;
import java.util.Map;
 
public class VendingMachine implements Selector {

    private final Inventory<Coin> coinInventory = new Inventory<>();
    private final Inventory<Item> itemInventory = new Inventory<>();
    
    private int totalSales;    
    private int currentBalance;
    
    private Item currentItem;

    public VendingMachine() {
        initMachine();
    }   
    
    @Override
    public int checkPriceBtn(Item item) { return 0; }

    @Override
    public void insertCoinBtn(Coin coin) {}

    @Override
    public Map<Item, List<Coin>> buyBtn() { 
        return Collections.singletonMap(currentItem, collectChange()); 
    }

    @Override
    public List<Coin> refundBtn() { return null; }

    @Override
    public void resetBtn() {}
    
    private void initMachine() {
        System.out.println("Initializing the vending machine with coins and items ...");
    }
    
    private Item collectItem() { return null; }
    private List<Coin> collectChange() { return null; }
    
    private boolean isFullPaid() { return false; }
    private List<Coin> getChange(int amount) { return null; }
    private boolean hasSufficientChange() { return false; }
    private boolean hasSufficientChangeForAmount(long amount) { return false; }
    
    private void updateCoinInventory(List<Coin> coins) {}
    private void updateItemInventory(List<Item> item) {}  

    protected long getTotalSales() {
        return totalSales;
    }

    protected long getCurrentBalance() {
        return currentBalance;
    }
        
}
