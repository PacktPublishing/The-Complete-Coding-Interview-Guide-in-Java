package coding.challenge.movie;

import java.time.LocalTime;
import java.util.List;

public class Movie {

    private final String title;
    private final String category;
    private final int minutes;
    
    private CinemaRoom room;
    private List<LocalTime> startTimes;

    public Movie(String title, String category, int minutes) {
        this.title = title;
        this.category = category;
        this.minutes = minutes;
    }

    public CinemaRoom getRoom() {
        return room;
    }

    public List<LocalTime> getStartTimes() {
        return startTimes;
    }        

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public int getMinutes() {
        return minutes;
    }

    protected void setRoom(CinemaRoom room) {
        this.room = room;
    }

    protected void setStartTimes(List<LocalTime> startTimes) {
        this.startTimes = startTimes;
    }        
}
