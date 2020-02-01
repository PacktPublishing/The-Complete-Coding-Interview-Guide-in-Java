package coding.challenge.vehicle;

public class Truck extends Vehicle {
    
    private final static int SPOTS_NEEDED = 5;
    
    public Truck(String licenseNumber) {
        super(licenseNumber, SPOTS_NEEDED, VehicleType.TRUCK);
    }    
}
