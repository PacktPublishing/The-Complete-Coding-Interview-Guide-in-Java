package coding.challenge;

public interface Vehicle {

    public void speedUp();

    public void slowDown();

    default double computeConsumption(int fuel, int distance, int horsePower) {        
        return Math.random() * 10d;
    }
    
    static void description() {
        System.out.println("This interface control steam, petrol and electric cars");
    }
}
