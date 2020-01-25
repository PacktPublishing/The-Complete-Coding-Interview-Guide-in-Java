package coding.challenge;

public class PetrolCar implements Vehicle {

    private String name;
    private int horsePower;

    public PetrolCar(String name, int horsePower) {
        this.name = name;
        this.horsePower = horsePower;
    }       

    public String getName() {
        return name;
    }

    public int getHorsePower() {
        return horsePower;
    }        
    
    @Override
    public void speedUp() {
        System.out.println("Speed up the petrol car ...");
    }

    @Override
    public void slowDown() {
        System.out.println("Slow down the petrol car ...");
    }    
}
