package coding.challenge.vending.machine;

public enum Coin {
    
    PENNY(1), NICKEL(5), DIME(10), QUARTER(25);
     
    private final int denomination;

    private Coin(int denomination) {
        this.denomination = denomination;
    }

    public int getDenomination() {
        return denomination;
    }
}
