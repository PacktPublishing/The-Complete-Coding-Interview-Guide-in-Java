package coding.challenge.vehicle;

public class Car extends Vehicle {
    
    private final static int SPOTS_NEEDED = 1;
    
    public Car(String licenseNumber) {
        super(licenseNumber, SPOTS_NEEDED, VehicleType.CAR);
    }        
}
