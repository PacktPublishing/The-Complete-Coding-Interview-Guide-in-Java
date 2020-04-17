package coding.challenge.jukebox;
 
import java.util.List;

public class CD {

    private List<Song> songs;
   
    // more details about CDs         

    public List<Song> getSongs() {
        return songs;
    }  

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }                
}
