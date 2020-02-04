package coding.challenge.cinema;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CinemaRoom {
    
    private String name;        
    private boolean open = true;
    
    private final Schedule schedule;
    private final List<Seat> seats;   

    protected CinemaRoom(String name) {
        this.name = name;
        
        seats = new ArrayList<>();
        schedule = new Schedule(this);
    }
        
    protected CinemaRoom(String name, List<Seat> seats) {        
        this.name = name;
        this.seats = seats;
        
        schedule = new Schedule(this);
    }
    
    protected boolean close() { open = false; return open; }
    protected boolean open() { open = true; return open; }
    
    protected int addSeat(Seat seat) { return 0; }
    protected int removeSeat(Seat seat) { return 0; }
    
    protected int countAllSeats() { return 0; }
    protected int countFreeSeats(SeatType seat, Movie movie) { return 0; } 
    
    protected List<Seat> getFreeSeats(Movie movie) { return null; } 
    protected List<Seat> getFreeSeatsOfType(SeatType seat, Movie movie) { return null; } 
        
    protected MovieTicket buyTicket(Movie movie, LocalTime startTime, List<Seat> seats) { return null; }

    protected Schedule getSchedule() {        
        return schedule;
    }

    protected List<Seat> getSeats() {
        return seats;
    }                    

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }        
    
    protected static class Schedule {
    
        private final LocalDate created;           
        private final List<LocalTime> freeTimeSlots;
        private final Map<Movie, List<LocalTime>> moviePlaylist;    
        
        private final CinemaRoom room;

        private Schedule(CinemaRoom room) {
             this.created = LocalDate.now();          
             this.room = room;        
        
             this.moviePlaylist = new HashMap<>();        
             this.freeTimeSlots = new ArrayList<>();        
        }            
        
        protected boolean addMovie(Movie movie, int runningNumber) { // runningNumber -> how many times in a day should run this movie         
            // determine start times based on free time slots
            // set movie cinema room
            // update free slots list    
        
            return true;
        }
        
        protected CinemaRoom getRoom() { return room; }   
    
        protected void shuffleSchedule() {}
        protected void rescheduleMovieToTimes(Movie movie, List<LocalTime> startTimes) {}
        protected void removeMovie(Movie movie) {
            // remove rooms
            // remove start times
        } 
       
        protected LocalDate getCreated() { return created; }
        protected List<Movie> getMoviePlaylist() { return moviePlaylist; }
        protected List<LocalTime> getFreeTimeSlots() { return freeTimeSlots; }    
    }

}
