package coding.challenge.vehicle;

public abstract class Vehicle {

    private final String licenseNumber;
    private final int spotsNeeded;
    private final VehicleType type;

    public Vehicle(String licenseNumber, int spotsNeeded, VehicleType type) {
        this.licenseNumber = licenseNumber;
        this.spotsNeeded = spotsNeeded;
        this.type = type;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    public VehicleType getType() {
        return type;
    }
    
    
}
