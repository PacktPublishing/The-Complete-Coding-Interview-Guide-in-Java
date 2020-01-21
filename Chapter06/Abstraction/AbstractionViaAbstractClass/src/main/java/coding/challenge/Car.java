package coding.challenge;

abstract class Car {

    private final String carType;

    // abstract class can have constructor
    public Car(String carType) {
        this.carType = carType;
    }        
    
    // these are abstract methods
    abstract void speedUp();
    abstract void slowDown();
    abstract void turnRight();
    abstract void turnLeft();

    // this is a concrete method
    public String getCarType() {
        return carType;
    }        
}
