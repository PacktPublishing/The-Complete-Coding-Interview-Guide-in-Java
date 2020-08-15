package coding.challenge.parking;
 
import java.time.LocalDateTime;
import java.util.List;

public final class ParkingTicket {
    
    private final Vehicle vehicle;
    private final LocalDateTime releaseDate;    
    private final List<String> parkingSpotsLabels;
    private final String floorName;

    protected ParkingTicket(Vehicle vehicle, List<String> parkingSpotsLabels, String floorName) {       
        this.vehicle = vehicle;
        this.parkingSpotsLabels = parkingSpotsLabels;
        this.floorName = floorName;
        this.releaseDate = LocalDateTime.now();
    }    

    protected LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public List<String> getParkingSpotsLabels() {
        return parkingSpotsLabels;
    }

    public String getFloorName() {
        return floorName;
    }   

    protected Vehicle getVehicle() {
        return vehicle;
    }        

    @Override
    public String toString() {
        return "ParkingTicket{" + "floor=" + getFloorName() + ", spots=" + getParkingSpotsLabels() 
                + ", vehicle=" + vehicle + ", releaseDate=" + releaseDate + '}';
    }          
}
