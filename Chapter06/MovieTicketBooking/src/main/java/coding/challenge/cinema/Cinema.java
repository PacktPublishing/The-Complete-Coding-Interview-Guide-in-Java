package coding.challenge.cinema;
 
import coding.challenge.cinema.CinemaRoom.Cartridge;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Cinema {

    private final String name;
    
    private Map<String, CinemaRoom> rooms;    
    
    // a cartridge holds information of a single movie 
    // and it known the rooms and start times when it is played
    private final List<Cartridge> cartridges = new ArrayList<>();

    protected Cinema(String name) {
        this.name = name;
    }   
    
    protected Cinema(String name, Map<String, CinemaRoom> rooms) {        
        this.name = name;
        this.rooms = rooms;
    }   
        
    public List<Seat> getFreeSeatsOfRoom(CinemaRoom room, Movie movie) { return null; }
    public MovieTicket buyTicket(CinemaRoom room, Movie movie, LocalTime startTime, List<Seat> seats) { return null; }            
                
    protected boolean addNewMovie(CinemaRoom room, Movie movie) {
        
        // check if this movie has a cartridge
            // if yes call room.addMovie(movie, cartridge)
            // else 
               // 1. call Cartridge cartridge = room.addMovie(movie);
               // 2. this.cartridges.add(cartridge);
       
        return false; 
    }
    
    protected boolean addNewMovie(Movie movie) { return false; } // add in all rooms
    protected boolean addNewMovie(List<CinemaRoom> room, Movie movie) { return false; }
    
    protected boolean removeMovie(Movie movie) {
        
        // check if this movie has a cartridge
            // if it does not then return false
            // else 
                // 1. List<CinemaRoom> rooms = cartridge.fetchRooms();
                // 2. iterate 'rooms' and call room.removeMovie(movie, cartridge);
                // 3. cartridge.fetchRooms() should be empty
                      // now you can delete the cartridge itself
                             // cartridges.remove(cartridge);
                             // cartridge = null;          
                      // or keep it to use later for the same movie
        
        return false;
    }
    
    protected boolean removeMovieFromRooms(Movie movie, List<CinemaRoom> rooms) {
        
        // check if this movie has a cartridge
            // if it does not then return false
            // else                 
                // iterate 'rooms' and call room.removeMovie(movie, cartridge);                
                
        return false;
    }
    
    protected boolean removeMovieStartTimes(Movie movie, List<LocalTime> startTimes) {
        
        // check if this movie has a cartridge
            // if it does not then return false
            // else 
                // 1. List<CinemaRoom> rooms = cartridge.fetchRooms();
                // 2. iterate 'rooms' and call room.removeMovieStartTimes(movie, cartridge, startTimes);
               
        return false;
    }
    
    protected boolean removeMovieFromRoomsStartTimes(Movie movie, List<CinemaRoom> rooms, List<LocalTime> startTimes) {
        
        // check if this movie has a cartridge
            // if it does not then return false
            // else 
                // 1. iterate 'rooms' and call room.removeMovie(movie, cartridge);                
                // 2. for each room call room.removeMovieStartTimes(movie, cartridge, startTimes);
               
        return false;
    }
    
    public String getName() {
        return name;
    } 

    public List<Cartridge> getCartridges() {
        return List.copyOf(cartridges);        
    }        

    protected Map<String, CinemaRoom> getRooms() {        
        return rooms;
    }

    protected void setRooms(Map<String, CinemaRoom> rooms) {
        this.rooms = rooms;
    }
        
    protected CinemaRoom getRoom(String name) { return null; }
    protected boolean addRoom(CinemaRoom room) { return false; }
    protected boolean removeRoom(CinemaRoom room) { return false; }
}
