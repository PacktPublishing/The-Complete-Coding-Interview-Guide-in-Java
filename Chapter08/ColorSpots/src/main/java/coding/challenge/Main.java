package coding.challenge;

import java.util.Random;
 
public class Main {

    public static void main(String[] args) {

        int cols = 5;
        int rows = 5;
        int colors = 3; // a spot can have the colors 1, 2 or 3
        
        Random rnd = new Random();

        int[][] a = new int[rows][cols];

        // add random colors
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                a[i][j] = 1 + rnd.nextInt(colors);
            }
        }

        // show the surface on screen
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }

        BiggestColorSpot spots = new BiggestColorSpot();
        spots.determineBiggestColorSpot(cols, rows, a);                
    }
 
}
