package coding.challenge.cinema;
 
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CinemaRoom {       
    
    private String name;        
    private boolean open = true;        
    
    private final List<Seat> seats;   
    private final Map<Entry<LocalTime, LocalTime>, Movie> schedule  
            = new HashMap<>() {{
                put(Map.entry(LocalTime.of(9, 0), LocalTime.of(11, 0)), null);
                put(Map.entry(LocalTime.of(11, 0), LocalTime.of(13, 0)), null);
                put(Map.entry(LocalTime.of(13, 0), LocalTime.of(15, 0)), null);
                put(Map.entry(LocalTime.of(15, 0), LocalTime.of(17, 0)), null);
                put(Map.entry(LocalTime.of(17, 0), LocalTime.of(19, 0)), null);
                put(Map.entry(LocalTime.of(19, 0), LocalTime.of(21, 0)), null);
            }};
        
    protected CinemaRoom(String name) {
        this.name = name;        
        seats = new ArrayList<>();        
    }
        
    protected CinemaRoom(String name, List<Seat> seats) {        
        this.name = name;
        this.seats = seats;                        
    }
    
    protected Cartridge addMovie(Movie movie, int replayNr) { // replayNr - how many times should be played in a single day
        // find free slot(s) via findFreeSlotInSchedule()
        // create a new Cartridge (only one)
        // add movie to Cartridge (via addNewStartTime()) and to schedule       
       
        return null; // return the created cartridge
    }
    
    protected boolean addMovie(Movie movie, Cartridge cartridge, int replayNr) { // replayNr - how many times should be played in a single day       
        // find free slot(s) via findFreeSlotInSchedule()
        // add movie to Cartridge (via addNewStartTime()) and to schedule
        
        return false;
    }
    
    protected boolean removeMovieStartTimes(Movie movie, Cartridge cartridge, List<LocalTime> startTime) {        
        // remove movie from Cartridge (via removeStartTime()) and from schedule
       
        return false;
    }
    
    protected boolean removeMovie(Movie movie, Cartridge cartridge) {        
        // remove movie from Cartridge (via removeMovie()) and from schedule
       
        return false;
    }

    protected Map<String, String> printSchedule() { return null; } // e.g., Map<9:00-11:00, The Incredible Hulk>
    
    protected boolean close() { open = false; return open; }
    protected boolean open() { open = true; return open; }
    
    protected int addSeat(Seat seat) { return 0; }
    protected int removeSeat(Seat seat) { return 0; }
    
    protected int countAllSeats() { return 0; }
    protected int countFreeSeats(SeatType seat, Movie movie) { return 0; } 
    
    protected List<Seat> getFreeSeats(Movie movie) { return null; } 
    protected List<Seat> getFreeSeatsOfType(SeatType seat, Movie movie) { return null; } 
        
    protected MovieTicket buyTicket(Movie movie, LocalTime startTime, List<Seat> seats) { return null; }
    
    protected List<Seat> getSeats() {
        return seats;
    }                    

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }   
    
    private Map.Entry<LocalTime, LocalTime> findFreeSlotInSchedule() { return null; }

    public final class Cartridge {

        private final Movie movie;
        private final Map<CinemaRoom, List<LocalTime>> playingIn;
            
        private Cartridge(Movie movie) {
            this.movie = movie;
            this.playingIn = new HashMap<>();
        }
        
        public Movie getMovie() { return movie; }
        public List<LocalTime> fetchUniqueStartTimes() { return null; }        
        public List<CinemaRoom> fetchRooms() { return null; }        
        
        protected boolean isFor(Movie movie) { return false; }
        
        private boolean addNewStartTime(CinemaRoom room, LocalTime startTime) { return false; }
        private boolean removeStartTime(CinemaRoom room, LocalTime startTime) { return false; }
        private boolean removeMovie(CinemaRoom room) { return false; }
    }
}
