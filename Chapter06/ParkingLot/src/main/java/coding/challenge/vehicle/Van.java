package coding.challenge.vehicle;

public class Van extends Vehicle {
    
    private final static int SPOTS_NEEDED = 2;
    
    public Van(String licenseNumber) {
        super(licenseNumber, SPOTS_NEEDED, VehicleType.VAN);
    }        
}
