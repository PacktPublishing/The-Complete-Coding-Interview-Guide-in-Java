package coding.challenge.movie;

import java.util.ArrayList;
import java.util.List;

public class CinemaRoom {
    
    private String name;
    
    private Schedule schedule;
    private boolean open = true;
    
    private final List<Seat> seats;   

    public CinemaRoom(String name) {
        this.name = name;
        seats = new ArrayList<>();
    }
        
    public CinemaRoom(String name, List<Seat> seats) {        
        this.name = name;
        this.seats = seats;
    }
    
    protected boolean close() { open = false; return open; }
    protected boolean open() { open = true; return open; }
    
    protected int addSeat(Seat seat) { return 0; }
    protected int removeSeat(Seat seat) { return 0; }
    protected int countAllSeats() { return 0; }
    protected int countFreeSeats(SeatType seat, Movie movie) { return 0; } 
    protected MovieTicket reserveSeat(Movie movie, SeatType seatType) { return null; }

    protected Schedule getSchedule() {
        return schedule;
    }

    protected List<Seat> getSeats() {
        return seats;
    }        

    protected void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }        

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }        
}
