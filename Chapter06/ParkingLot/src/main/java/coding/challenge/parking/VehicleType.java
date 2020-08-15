package coding.challenge.parking;
 
public enum VehicleType {

    CAR(1), VAN(2), TRUCK(5);

    private final int spotsNeeded;

    private VehicleType(int spotsNeeded) {
        this.spotsNeeded = spotsNeeded;
    }

    public int getSpotsNeeded() {
        return spotsNeeded;
    }
}
