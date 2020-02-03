package coding.challenge.movie;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class Cinema {

    private final String name;
    private final Map<String, CinemaRoom> rooms;
    
    private List<Movie> movies;

    public Cinema(String name, Map<String, CinemaRoom> rooms) {
        this.name = name;
        this.rooms = rooms;
    }

    public List<LocalDateTime> getMovieStartTime(Movie movie) { return null; }
    
    protected boolean registerMovieInCinema(Movie movie) { return true; }
    protected boolean deleteMovieFromCinema(Movie movie) { return true; } 
    
    protected boolean closeRoom(CinemaRoom room) { return true; } 
    protected boolean openRoom(CinemaRoom room) { return true; } 
    
    protected boolean isMovieRunningInThisCinema(Movie movie) { return true; }    

    protected MovieTicket reserveSeat(Movie movie, SeatType seatType) { return null; }

    protected  Map<String, CinemaRoom> getRooms() {
        return rooms;
    }           
    
    protected CinemaRoom getRoom(String name) {
        return rooms.get(name);
    }

    protected List<Movie> getMovies() {
        return movies;
    }
    
    public String getName() {
        return name;
    } 
}
