package coding.challenge.cinema;

import java.time.LocalTime;
import java.util.List;
 
public final class MovieTicket {
    
    private final Movie movie;
    private final LocalTime startTime;
    private final LocalTime endTime;    
    private final String roomName;
    private final List<String> seatNumbers;
    private final int price;

    protected MovieTicket(Movie movie, LocalTime startTime, int price, 
            String roomName, List<String> seatNumbers) {
        this.movie = movie;
        this.startTime = startTime;
        this.price = price;
        this.roomName = roomName;
        this.seatNumbers = seatNumbers;
        this.endTime = this.startTime.plusMinutes(movie.getMinutes());
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }      

    public int getPrice() {
        return price;
    }

    public String getRoomName() {
        return roomName;
    }

    public List<String> getSeatNumbers() {
        return seatNumbers;
    }
                
    public boolean isValid() {
        return LocalTime.now().isAfter(startTime) 
                && LocalTime.now().isBefore(endTime);
    }       
}
