package coding.challenge.vehicle;

public abstract class Vehicle {

    private final String licensePlate;
    private final int spotsNeeded;
    private final VehicleType type;

    public Vehicle(String licensePlate, int spotsNeeded, VehicleType type) {
        this.licensePlate = licensePlate;
        this.spotsNeeded = spotsNeeded;
        this.type = type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    public VehicleType getType() {
        return type;
    }
    
    
}
