package coding.challenge.jukebox;
 
import java.util.List;

public class Playlist {
    
    private Song song;
    
    private final List<Song> songs; // or Queue

    public Playlist(List<Song> songs) {
        this.songs = songs;
    }   
    
    public Playlist(Song song, List<Song> songs) {
        this.song = song;
        this.songs = songs;
    }        
    
    protected void addSong(Song song) {}
    protected void removeSong(Song song) {}
    protected void shuffle() {}    
    protected Song getNextSong() { return null; };
    protected Song getPrevSong() { return null; };

    protected Song getSong() {
        return song;
    }

    protected void setSong(Song song) {
        this.song = song;
    }       

    protected List<Song> getSongs() {
        return songs;
    }        
}
