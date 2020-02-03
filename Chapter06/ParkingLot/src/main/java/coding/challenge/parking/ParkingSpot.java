package coding.challenge.parking;

import coding.challenge.vehicle.Vehicle;

public class ParkingSpot {
    
    private boolean free = true;
    private Vehicle vehicle;
    
    private final String label;
    private final ParkingFloor parkingFloor;    

    protected ParkingSpot(ParkingFloor parkingFloor, String label) {
        this.parkingFloor = parkingFloor;
        this.label = label;
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
    
    protected boolean isFree() {
        return free;
    }
        
    @Override
    public String toString() {
        return "ParkingSpot{" + "label=" + label + '}';
    }        
}
