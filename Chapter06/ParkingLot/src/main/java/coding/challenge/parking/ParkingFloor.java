package coding.challenge.parking;

import coding.challenge.vehicle.Vehicle;
import coding.challenge.vehicle.VehicleType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingFloor {

    private final String name;
    private final int totalSpots;    
    private final Map<String, ParkingSpot> parkingSpots = new HashMap<>();
    
    private int totalFreeSpots;    

    public ParkingFloor(String name, int totalSpots) {
        this.name = name;
        this.totalSpots = totalSpots;
        
        initialize();
    }
       
    protected ParkingTicket parkVehicle(Vehicle vehicle) { 
        
        List<ParkingSpot> location = findSpotsToFitVehicle(vehicle); 
        if(location.isEmpty()) { return null; } // returning null is not a good practice
        
        location.forEach(s -> s.assignVehicle(vehicle));
        
        return releaseParkingTicket(location);
    }     
    
    protected boolean unparkVehicle(Vehicle vehicle) { return false; } // we have to find vehicle by looping the parking spots  
    protected boolean unparkVehicle(Vehicle vehicle, ParkingTicket parkingTicket) { return false; } // we have the ticket, so we know the parking spots  
    
    protected boolean isFull(VehicleType type) { return false; }
    protected int countFreeSpots(VehicleType vehicleType) { return 0; }
    
    protected int getTotalSpots() {
        return totalSpots;
    }

    protected int getTotalFreeSpots() {
        return totalFreeSpots;
    }    

    protected String getName() {
        return name;
    }
    
    // e.g., we need a List because for a van it returns two ParkingSpot, for truck it returns five
    private List<ParkingSpot> findSpotsToFitVehicle(Vehicle vehicle) {        
        return List.of(parkingSpots.get("#1"), parkingSpots.get("#2"));
    }
    
    private ParkingTicket releaseParkingTicket(List<ParkingSpot> location) {
        return new ParkingTicket(this, location);
    }
    
    private void destroyParkingTicket(ParkingTicket parkingTicker) {}
            
    private void initialize() {
        for(int i=1;i<=totalSpots;i++){
            parkingSpots.put("#" + i, new ParkingSpot(this, "#" + i));                
        }
    }
}
