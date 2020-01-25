package coding.challenge;

public class ElectricCar implements Vehicle {

    private String name;
    private int horsePower;

    public ElectricCar(String name, int horsePower) {
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
        System.out.println("Speed up the electric car ...");
    }

    @Override
    public void slowDown() {
        System.out.println("Slow down the electric car ...");
    }

    @Override
    public double computeConsumption(int fuel, int distance, int horsePower) {
        return Math.random() * 60d / Math.pow(Math.random(), 3);
    }     

}
