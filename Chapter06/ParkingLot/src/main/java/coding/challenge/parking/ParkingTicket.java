package coding.challenge.parking;

import java.time.LocalDateTime;
import java.util.List;

public final class ParkingTicket {

    private final ParkingFloor floor;
    private final List<ParkingSpot> location;
    private final LocalDateTime releaseDate;

    public ParkingTicket(ParkingFloor floor, List<ParkingSpot> location) {
        this.floor = floor;
        this.location = location;
        this.releaseDate = LocalDateTime.now();
    }

    protected List<ParkingSpot> getLocation() {
        return location;
    }

    protected LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    protected ParkingFloor getFloor() {
        return floor;
    }

    @Override
    public String toString() {
        return "ParkingTicket{" + "floor=" + floor.getName() +
                ", location=" + location + ", releaseDate=" + releaseDate + '}';
    }        
}
