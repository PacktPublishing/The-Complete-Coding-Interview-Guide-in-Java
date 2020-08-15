package coding.challenge;
 
public class Main {
    
    public static final int GRID_SIZE = 5; // minim 5
    
    public static void main(String[] args) {

        KnightTour knightTour = new KnightTour(GRID_SIZE);
        
        // visited[][] stores the current path
        int visited[][] = new int[GRID_SIZE][GRID_SIZE];
        
        int cell = 1;

        // start knight tour from corner cell (0, 0)
        knightTour.knightTour(0, 0, cell, visited);       
    }

}
