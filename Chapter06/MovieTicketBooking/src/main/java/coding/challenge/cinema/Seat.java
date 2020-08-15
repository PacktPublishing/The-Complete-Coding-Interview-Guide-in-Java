package coding.challenge.cinema;

public class Seat {
     
    private final CinemaRoom room;
    private final String number;
    private final SeatType type;
    private boolean free = true;

    protected Seat(CinemaRoom room, String number, SeatType type) {
        this.room = room;
        this.number = number;
        this.type = type;
    }

    protected CinemaRoom getRoom() {
        return room;
    }

    protected String getNumber() {
        return number;
    }

    protected SeatType getType() {
        return type;
    }        

    protected boolean isFree() {
        return free;
    }            
    
    protected void assignSeat() { free = false; }
    protected void releaseSeat() { free = true; }
    protected int seatPrice() { return this.type.getPrice(); }
}
