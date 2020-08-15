package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

        int[][] board
                = {
                    {0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 0, 1, 1, 0, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                    {1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
                };

        int dist = Sensors.shortestPath(board);

        if (dist != -1) {
            System.out.print("\n\nThe shortest safe path has length of " + dist);
        } else {
            System.out.print("\n\nNo route is safe to reach the destination");
        }
    }
}
