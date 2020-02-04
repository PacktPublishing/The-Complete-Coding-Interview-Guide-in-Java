package coding.challenge.ticketing;

import coding.challenge.cinema.Movie;
import coding.challenge.cinema.MovieTicket;

public interface MovieTicketing {
    
    // this is like the Template design pattern
    public boolean selectMovieBtn(Movie movie);   
    public boolean selectStartTimeBtn();    
    public boolean selectCinemaRoom();
    public boolean selectSeats();       
    
    public MovieTicket buyTicketBtn();
}
