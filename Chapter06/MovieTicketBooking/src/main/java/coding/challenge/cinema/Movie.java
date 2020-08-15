package coding.challenge.cinema;

import java.util.Objects;
 
public class Movie {

    private final int id;
    private final String title;
    private final String category;
    private final int minutes;    
    
    protected Movie(int id, String title, String category, int minutes) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.minutes = minutes;
    }
       
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public int getMinutes() { return minutes; }  

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.id;
        hash = 47 * hash + Objects.hashCode(this.title);
        hash = 47 * hash + Objects.hashCode(this.category);
        hash = 47 * hash + this.minutes;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
    
        if (this == obj) {
            return true;
        }
        
        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Movie other = (Movie) obj;
        if (this.id != other.id) {
            return false;
        }
        
        if (this.minutes != other.minutes) {
            return false;
        }
        
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        
        return true;
    }
        
}
