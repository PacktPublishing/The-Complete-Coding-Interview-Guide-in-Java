package coding.challenge.parking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ParkingFloor {

    private final String name;
    private final int totalSpots;    
    private final Map<String, ParkingSpot> parkingSpots = new HashMap<>();
    private final Set<ParkingTicket> parkingTickets = new HashSet<>();
    
    private int totalFreeSpots;    

    public ParkingFloor(String name, int totalSpots) {
        this.name = name;
        this.totalSpots = totalSpots;
        
        initialize(); // create the parking spots
    }
       
    protected ParkingTicket parkVehicle(Vehicle vehicle) { 
        
        List<ParkingSpot> spots = findSpotsToFitVehicle(vehicle); 
        if(spots.isEmpty()) { return null; } // returning null is not a good practice
        
        vehicle.setParkingFloorName(name);       
        assignVehicleToParkingSpots(spots, vehicle);        
        
        ParkingTicket parkingTicket = releaseParkingTicket(vehicle);        
        registerParkingTicket(parkingTicket);
        
        return parkingTicket;
    }     
    
    // we have to find vehicle by looping the parking spots  
    protected boolean unparkVehicle(Vehicle vehicle) { 
        
        ParkingTicket parkingTicket = findParkingTicket(vehicle);        
        
        if(!parkingTickets.contains(parkingTicket)) {
            return false;
        }
        
        for(ParkingSpot pl: parkingSpots.values()) {
            if(pl.getVehicle()!= null && pl.getVehicle().equals(vehicle)) {
                boolean success = pl.removeVehicle();
                if(!success) {
                    return false;
                }
            }
        }
                       
        unregisterParkingTicket(parkingTicket);       
                
        return true;
    } 
    
    // we have the ticket, so we have all the needed information
    protected boolean unparkVehicle(ParkingTicket parkingTicket) { 
                
        if(!parkingTickets.contains(parkingTicket)) {
            throw new RuntimeException("This ticket is not in our system!");
        }
        
        List<String> spots = parkingTicket.getSpotsLabels();
        for(String spot: spots) {            
            boolean success = parkingSpots.get(spot).removeVehicle();
            if(!success) {
                return false;
            }
        }
        
        unregisterParkingTicket(parkingTicket);
                
        return true; 
        
    } 
    
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

        int count = 0;        
        List<ParkingSpot> freeSpots = new ArrayList<>();
        int neededSpots = vehicle.getSpotsNeeded();
        
        for(int i = 1; i <= totalSpots; i++){
            if(parkingSpots.get("#" + i).isFree()) {
                count ++;                
                freeSpots.add(parkingSpots.get("#" + i));
            } else {
                count = 0;
                freeSpots.clear();
            }           
            
            if(count == neededSpots) {
                return freeSpots;
            }
        }
        
        freeSpots.clear();
        return freeSpots;
    }
    
    private void assignVehicleToParkingSpots(List<ParkingSpot> spots, Vehicle vehicle) {
        spots.forEach(s -> s.assignVehicle(vehicle));
    }
    
    private ParkingTicket releaseParkingTicket(Vehicle vehicle) {
        return new ParkingTicket(vehicle);
    }
    
    private void registerParkingTicket(ParkingTicket parkingTicket) {
        this.parkingTickets.add(parkingTicket);                
    }
       
    private ParkingTicket findParkingTicket(Vehicle vehicle) {
        for(ParkingTicket pt: parkingTickets) {
            if(pt.getVehicle().equals(vehicle)) {                
                return pt;                                
            }
        }
        
        return null;
    }
    
    private boolean unregisterParkingTicket(ParkingTicket parkingTicket) {
        return this.parkingTickets.remove(parkingTicket);                
    }
                
    private void initialize() {
        for(int i = 1; i <= totalSpots; i++) {
            parkingSpots.put("#" + i, new ParkingSpot(this, "#" + i));                
        }
    }
}
