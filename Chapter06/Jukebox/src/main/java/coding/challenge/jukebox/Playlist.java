package coding.challenge.jukebox;

import java.util.List;

public class Playlist {
    
    private Song song;
    private List<Song> songs; // or Queue

    public Playlist(List<Song> songs) {
        this.songs = songs;
    }   
    
    public Playlist(Song song, List<Song> songs) {
        this.song = song;
        this.songs = songs;
    }        
    
    public void addSong(Song song) {}
    public void removeSong(Song song) {}
    public void shuffle() {}    
    public Song getNextSong() { return null; };
    public Song getPrevSong() { return null; };

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }       

    public List<Song> getSongs() {
        return songs;
    }        
}
