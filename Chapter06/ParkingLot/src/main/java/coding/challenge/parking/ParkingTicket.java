package coding.challenge.parking;

import java.time.LocalDateTime;
import java.util.List;

public final class ParkingTicket {
    
    private final Vehicle vehicle;
    private final LocalDateTime releaseDate;

    protected ParkingTicket(Vehicle vehicle) {       
        this.vehicle = vehicle;
        this.releaseDate = LocalDateTime.now();
    }

    protected List<String> getSpotsLabels() {
        return vehicle.getParkingSpotsLabels();
    }

    protected LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    protected String getFloorName() {
        return vehicle.getParkingFloorName();
    }

    protected Vehicle getVehicle() {
        return vehicle;
    }        

    @Override
    public String toString() {
        return "ParkingTicket{" + "floor=" + getFloorName() + ", spots=" + getSpotsLabels() 
                + ", vehicle=" + vehicle + ", releaseDate=" + releaseDate + '}';
    }          
}
