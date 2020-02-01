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
       
    protected String parkVehicle(Vehicle vehicle) { 
        
        List<ParkingSpot> spots = findSpotsToFitVehicle(vehicle); 
        spots.forEach(s -> s.assignVehicle(vehicle));
        
        return name + ":[#1, #2]"; // this is like a parking ticket
    }     
    
    protected boolean removeVehicle(Vehicle vehicle) { return false; } // we have to find vehicle by looping stops  
    protected boolean removeVehicle(Vehicle vehicle, List<String> spots) { return false; } // we have the spots   
    protected boolean isFull(VehicleType type) { return false; }
    protected int countFreeSpots(VehicleType vehicleType) { return 0; }
    
    // e.g., we need a List because for a van it returns two ParkingSpot, for truck it returns five
    private List<ParkingSpot> findSpotsToFitVehicle(Vehicle vehicle) { 
        return List.of(parkingSpots.get("#1"), parkingSpots.get("#2"));
    }
            
    private void initialize() {
        for(int i=1;i<=totalSpots;i++){
            parkingSpots.put("#" + i, new ParkingSpot(this));                
        }
    }

    protected int getTotalSpots() {
        return totalSpots;
    }

    protected int getTotalFreeSpots() {
        return totalFreeSpots;
    }    

    protected String getName() {
        return name;
    }
       
}
