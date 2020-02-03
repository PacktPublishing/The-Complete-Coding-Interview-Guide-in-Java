package coding.challenge.movie;

import java.util.ArrayList;
import java.util.List;

public class CinemaRoom {
    
    private final List<Seat> seats;

    public CinemaRoom() {
        seats = new ArrayList<>();
    }

    public CinemaRoom(List<Seat> seats) {
        this.seats = seats;
    }
    
    
}
