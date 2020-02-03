package coding.challenge.movie;

public class Seat {
    
    private final CinemaRoom room;
    private final String number;
    private final boolean free = true;

    public Seat(CinemaRoom room, String number) {
        this.room = room;
        this.number = number;
    }

    protected CinemaRoom getRoom() {
        return room;
    }

    protected String getNumber() {
        return number;
    }

    protected boolean isFree() {
        return free;
    }            
}
