package coding.challenge.jukebox;

import java.util.Set;

public class CDPlayer {
        
    private CD cd;
    
    private final Set<CD> cds;  
    private final Playlist playlist;       

    public CDPlayer(Playlist playlist, Set<CD> cds) {
        this.playlist = playlist;
        this.cds = cds;
    }                
            
    public void playNextSong() {}
    public void playPrevSong() {}   
    public void addCD(CD cd) {}
    public void removeCD(CD cd) {}

    public Playlist getPlaylist() {
        return playlist;
    }

    public CD getCd() {
        return cd;
    }                

    public Set<CD> getCds() {
        return cds;
    }        
}
