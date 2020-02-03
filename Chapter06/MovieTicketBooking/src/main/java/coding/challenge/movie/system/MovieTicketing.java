package coding.challenge.movie.system;

import coding.challenge.movie.Movie;
import coding.challenge.movie.MovieTicket;
import coding.challenge.movie.SeatType;
import java.time.LocalDateTime;
import java.util.List;

public interface MovieTicketing {
    
    public List<LocalDateTime> selectMovieBtn(Movie movie);
    public boolean selectMovieStartTimeBtn(LocalDateTime startTime);    
    public int reserveSeatsBtn(int nrOfSeats, SeatType seatType); 
    
    public MovieTicket buyTicket(int price);
}
