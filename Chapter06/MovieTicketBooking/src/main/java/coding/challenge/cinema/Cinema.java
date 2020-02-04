package coding.challenge.cinema;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public class Cinema {

    private final String name;
    
    private Map<String, CinemaRoom> rooms;    
    private List<Movie> movies;

    protected Cinema(String name) {
        this.name = name;
    }   
    
    protected Cinema(String name, Map<String, CinemaRoom> rooms) {
        this.name = name;
        this.rooms = rooms;
    }   

    protected Cinema(String name, Map<String, CinemaRoom> rooms, List<Movie> movies) {
        this.name = name;
        this.rooms = rooms;
        this.movies = movies;
    }        
    
    public List<Seat> getFreeSeatsOfRoom(CinemaRoom room, Movie movie) { return null; }
    public MovieTicket buyTicket(CinemaRoom room, Movie movie, LocalTime startTime, List<Seat> seats) { return null; }            
                
    public List<Movie> getMovies() {
        return movies;
    }
    
    public String getName() {
        return name;
    } 

    protected Map<String, CinemaRoom> getRooms() {
        return rooms;
    }

    protected void setRooms(Map<String, CinemaRoom> rooms) {
        this.rooms = rooms;
    }

    protected void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
    
    protected CinemaRoom getRoom(String name) { return null; }
    protected boolean addRoom(CinemaRoom room) { return false; }
    protected boolean removeRoom(CinemaRoom room) { return false; }
    protected boolean addMovie(Movie movie) { return false; }
    protected boolean returnMovie(Movie movie) { return false; }
}
