package coding.challenge;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int cols = 5;
        int rows = 5;
        int elevation = 5; // a cell can have the elevation 1, 2, 3, 4 or 5 (the highest)

        Random rnd = new Random();

        int[][] elevations = new int[rows][cols];

        // add random elevations
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                elevations[i][j] = 1 + rnd.nextInt(elevation);
            }
        }

        // show the grid on screen        
        System.out.println("Initial grid:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.format("%2s", elevations[i][j]);
            }
            System.out.println();
        }
        
        System.out.println("Middle cell has elevation: " 
                + elevations[rows / 2][cols / 2]);
        FallingBall.computePath(elevations[rows / 2][cols / 2], 
                rows / 2, cols / 2, rows, cols, elevations);

        System.out.println("Result grid:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.format("%2s", elevations[i][j]);
            }
            System.out.println();
        }
    }

}
