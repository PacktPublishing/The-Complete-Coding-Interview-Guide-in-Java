package coding.challenge.actor;

import coding.challenge.parking.ParkingLot;
import coding.challenge.parking.ParkingTicket;
import coding.challenge.vehicle.Vehicle;

public class ParkingSystem {

    private final String id;
    private final ParkingLot parkingLot;

    public ParkingSystem(String id, ParkingLot parkingLot) {
        this.id = id;
        this.parkingLot = parkingLot;
    }

    public ParkingTicket parkVehicle(Vehicle vehicle) {
        if (!parkingLot.isFull(vehicle.getType())) {
            return parkingLot.parkVehicle(vehicle);
        }

        return null; // returning null is a bad practice, there is room to improve
    }
    
    public void unparkVehicle(Vehicle vehicle) {}
    public void unparkVehicle(Vehicle vehicle, ParkingTicket parkingTicket) {}   

    public String getId() {
        return id;
    }        
}
