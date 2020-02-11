package coding.challenge;

public class Main {
    
    public static final int GRID_SIZE = 5; // minim 5
    
    public static void main(String[] args) {

        KnightTour knightTour = new KnightTour(GRID_SIZE);
        
        // visited[][] serves two purpose -
        // 1. It keep track of squares involved the Knight's tour.
        // 2. It stores the order in which the squares are visited
        int visited[][] = new int[GRID_SIZE][GRID_SIZE];
        int cell = 1;

        // start knight tour from corner square (0, 0)
        knightTour.knightTour(2, 2, cell, visited);       
    }

}
