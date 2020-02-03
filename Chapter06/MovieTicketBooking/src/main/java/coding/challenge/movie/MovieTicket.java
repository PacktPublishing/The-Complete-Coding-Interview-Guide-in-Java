package coding.challenge.movie;

import java.time.LocalDateTime;

public final class MovieTicket {
    
    private final Movie movie;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;    
    private final int price;

    public MovieTicket(Movie movie, LocalDateTime startTime, int price) {
        this.movie = movie;
        this.startTime = startTime;
        this.price = price;
        this.endTime = this.startTime.plusMinutes(movie.getMinutes());
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }      

    public int getPrice() {
        return price;
    }
        
    public boolean isValid() {
        return LocalDateTime.now().isAfter(startTime) 
                && LocalDateTime.now().isBefore(endTime);
    }       
}
