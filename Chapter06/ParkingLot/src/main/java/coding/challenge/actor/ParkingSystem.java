package coding.challenge.actor;

import coding.challenge.parking.ParkingLot;
import coding.challenge.vehicle.Vehicle;

public class ParkingSystem {

    private final String id;
    private final ParkingLot parkingLot;

    public ParkingSystem(String id, ParkingLot parkingLot) {
        this.id = id;
        this.parkingLot = parkingLot;
    }

    public String parkCar(Vehicle vehicle) {
        if (!parkingLot.isFull(vehicle.getType())) {
            return parkingLot.parkVehicle(vehicle);
        }

        return "Sorry, we are full!";
    }

    public String getId() {
        return id;
    }        
}
