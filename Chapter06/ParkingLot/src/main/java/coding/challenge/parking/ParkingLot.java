package coding.challenge.parking;
 
import java.util.Map;

public class ParkingLot {

    private String name;
    private Map<String, ParkingFloor> floors;        

    public ParkingLot(String name) {
        this.name = name;
    }

    public ParkingLot(String name, Map<String, ParkingFloor> floors) {
        this.name = name;
        this.floors = floors;
    }    

    // delegate to the proper ParkingFloor
    public ParkingTicket parkVehicle(Vehicle vehicle) {

        for (ParkingFloor pf : floors.values()) {            
            if (!pf.isFull(vehicle.getType())) {
                ParkingTicket parkingTicket = pf.parkVehicle(vehicle);
                if(parkingTicket != null) {
                    return parkingTicket;
                }
            }
        }

        return null; // returning null is not a good practice
    }
    
    // we have to find vehicle by looping floors  
    public boolean unparkVehicle(Vehicle vehicle) {  
        for (ParkingFloor pf : floors.values()) {            
            boolean success = pf.unparkVehicle(vehicle);
            if(success) {
                return true;
            }
        }
        
        return false;
    } 
    
    // we have the ticket, so we have all the needed information
    public boolean unparkVehicle(ParkingTicket parkingTicket) { 
        
        return floors.get(parkingTicket.getFloorName()).unparkVehicle(parkingTicket);        
    } 
    
    public boolean isFull() { return false; }
        
    protected boolean isFull(VehicleType type) { return false; } 

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }
    
    protected void setFloors(Map<String, ParkingFloor> floors) {
        this.floors = floors;
    }
    
    protected boolean addFloor(ParkingFloor floor) { return false; }
    protected boolean removeFloor(ParkingFloor floor) { return false; }
}