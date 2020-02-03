package coding.challenge.movie;

public class Movie {

    private final String title;
    private final String category;
    private final int minutes;

    public Movie(String title, String category, int minutes) {
        this.title = title;
        this.category = category;
        this.minutes = minutes;
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
}
