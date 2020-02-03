package coding.challenge.movie;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

public class Schedule {
    
    private final LocalDate created;       
    private final List<Movie> moviePlaylist;    
    
    private Period validForDays;

    public Schedule(Period validForDays, List<Movie> moviePlaylist) {
        this.created = LocalDate.now();
        this.validForDays = validForDays;
        this.moviePlaylist = moviePlaylist;
    }            
    
    protected List<LocalDateTime> findMovieSchedule(Movie movie) { return null; }
    protected boolean isMovieRunningAtTime(Movie movie, LocalDateTime time) { return true; }    
    
    protected void addMovie(Movie movie) {}
    protected void rescheduleMovie(Movie movie, LocalDateTime startHour) {}
    protected void removeMovie(Movie movie) {}
    
    protected boolean isScheduleValid() { return true; } // compute from 'created' and 'validForDays'
    protected void updateValidity(Period validForDays) { this.validForDays = validForDays; }
}
