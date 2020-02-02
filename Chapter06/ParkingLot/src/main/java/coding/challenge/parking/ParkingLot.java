package coding.challenge.parking;

import coding.challenge.vehicle.Vehicle;
import coding.challenge.vehicle.VehicleType;
import java.util.List;

public class ParkingLot {

    private String name;
    private List<ParkingFloor> floors;

    public ParkingLot(String name) {
        this.name = name;
    }

    public ParkingLot(String name, List<ParkingFloor> floors) {
        this.name = name;
        this.floors = floors;
    }    

    // delegate to the proper ParkingFloor
    public ParkingTicket parkVehicle(Vehicle vehicle) {

        for (ParkingFloor pf : floors) {
            if (!pf.isFull(vehicle.getType())) {
                ParkingTicket parkingTicket = pf.parkVehicle(vehicle);
                if(parkingTicket != null) {
                    return parkingTicket;
                }
            }
        }

        return null;
    }
    
    protected boolean unparkVehicle(Vehicle vehicle) { return false; } // we have to find vehicle by looping floors  
    protected boolean unparkVehicle(Vehicle vehicle, String location) { return false; } // we have the spots       

    public boolean isFull(VehicleType type) { return false; }
    protected void addPArkingFloor(ParkingFloor floor) {}

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected List<ParkingFloor> getFloors() {
        return floors;
    }

    protected void setFloors(List<ParkingFloor> floors) {
        this.floors = floors;
    }
}
