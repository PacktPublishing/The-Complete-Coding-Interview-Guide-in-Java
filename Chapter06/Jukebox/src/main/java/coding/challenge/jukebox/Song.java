package coding.challenge.jukebox;
 
public class Song {
    
    private final String title;
    private final CD cd;        
    
    // more song details            

    public Song(String title, CD cd) {
        this.title = title;
        this.cd = cd;            
    }   

    public CD getCd() {
        return cd;
    }       
    
    public String getTitle() {
        return title;
    }
}
