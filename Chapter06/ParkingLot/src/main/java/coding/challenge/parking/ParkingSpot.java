package coding.challenge.parking;

import coding.challenge.vehicle.Vehicle;

public class ParkingSpot {

    private String label;
    private boolean free;
    private Vehicle vehicle;
    private final ParkingFloor parkingFloor;

    public boolean isFree() {
        return free;
    }

    public ParkingSpot(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }

    protected boolean assignVehicle(Vehicle vehicle) { return false; }

    protected boolean removeVehicle() { return false; }

    protected String getLabel() {
        return label;
    }

    protected Vehicle getVehicle() {
        return vehicle;
    }

    protected ParkingFloor getParkingFloor() {
        return parkingFloor;
    }
}
