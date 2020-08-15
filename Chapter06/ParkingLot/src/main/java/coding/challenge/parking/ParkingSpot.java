package coding.challenge.parking;
 
public class ParkingSpot {
    
    private boolean free = true;
    private Vehicle vehicle;
    
    private final String label;
    private final ParkingFloor parkingFloor;    

    protected ParkingSpot(ParkingFloor parkingFloor, String label) {
        this.parkingFloor = parkingFloor;
        this.label = label;
    }

    protected boolean assignVehicle(Vehicle vehicle) { 
                     
        System.out.println("Assign " + label + " at floor "
                + parkingFloor.getName() +  " to " + vehicle);                
        
        this.free = false; 
        this.vehicle = vehicle;
        
        return true; 
    }

    protected boolean removeVehicle() { 
        
        System.out.println("Free " + label
                + " at floor " + parkingFloor.getName() +" of " + vehicle);
        
        this.free = true; 
        this.vehicle = null;
        
        return true; 
    }

    protected String getLabel() {
        return label;
    }

    protected Vehicle getVehicle() {
        return vehicle;
    }
    
    protected boolean isFree() {
        return free;
    }
        
    @Override
    public String toString() {
        return "ParkingSpot{" + "label=" + label + '}';
    }        
}
