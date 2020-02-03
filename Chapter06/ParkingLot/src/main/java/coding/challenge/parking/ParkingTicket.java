package coding.challenge.parking;

import coding.challenge.vehicle.Vehicle;
import java.time.LocalDateTime;
import java.util.List;

public final class ParkingTicket {
    
    private final ParkingFloor floor;
    private final List<ParkingSpot> spots;
    private final Vehicle vehicle;
    private final LocalDateTime releaseDate;

    protected ParkingTicket(ParkingFloor floor, List<ParkingSpot> spots, Vehicle vehicle) {
        this.floor = floor;
        this.spots = spots;
        this.vehicle = vehicle;
        this.releaseDate = LocalDateTime.now();
    }

    protected List<ParkingSpot> getSpots() {
        return spots;
    }

    protected LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    protected ParkingFloor getFloor() {
        return floor;
    }

    protected Vehicle getVehicle() {
        return vehicle;
    }        

    @Override
    public String toString() {
        return "ParkingTicket{" + "floor=" + floor.getName() + ", spots=" + spots 
                + ", vehicle=" + vehicle + ", releaseDate=" + releaseDate + '}';
    }          
}
