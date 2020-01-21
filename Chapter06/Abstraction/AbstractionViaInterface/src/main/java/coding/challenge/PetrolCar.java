package coding.challenge;

public class PetrolCar implements Car {

    private final String carType;

    public PetrolCar(String carType) {
        this.carType = carType;
    }

    @Override
    public void speedUp() {
        System.out.println("Speed up the petrol car");
    }

    @Override
    public void slowDown() {
        System.out.println("Slow down the petrol car");
    }

    @Override
    public void turnRight() {
        System.out.println("Turn right the petrol car");
    }

    @Override
    public void turnLeft() {
        System.out.println("Turn left the petrol car");
    }

    @Override
    public String getCarType() {
        return this.carType;
    }
}
