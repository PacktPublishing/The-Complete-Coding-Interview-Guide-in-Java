package coding.challenge.movie.system;

import coding.challenge.movie.Cinema;
import coding.challenge.movie.Movie;
import coding.challenge.movie.MovieTicket;
import coding.challenge.movie.SeatType;
import java.time.LocalDateTime;
import java.util.List;

public class MovieTicketingMachine implements MovieTicketing {
    
    private final Cinema cinema;

    public MovieTicketingMachine(Cinema cinema) {
        this.cinema = cinema;
    }        

    @Override
    public List<LocalDateTime> selectMovieBtn(Movie movie) {               
    }    

    @Override
    public boolean selectMovieStartTimeBtn(LocalDateTime startTime) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int reserveSeatsBtn(int nrOfSeats, SeatType seatType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MovieTicket buyTicket(int price) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
