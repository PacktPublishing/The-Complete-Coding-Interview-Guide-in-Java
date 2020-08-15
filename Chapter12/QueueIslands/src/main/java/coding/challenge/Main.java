package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

        int[][] matrix
                = {
                    {1, 1, 1, 0, 0, 0, 1, 1, 0, 1},
                    {0, 1, 1, 0, 1, 0, 1, 0, 0, 0},
                    {1, 1, 1, 1, 0, 0, 1, 0, 1, 0},
                    {1, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                    {1, 1, 1, 1, 1, 1, 0, 0, 0, 1},
                    {0, 0, 0, 1, 0, 0, 1, 1, 0, 1},
                    {0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                    {1, 1, 0, 1, 0, 0, 0, 1, 1, 0},
                    {1, 0, 0, 0, 1, 1, 0, 1, 0, 0},
                    {1, 1, 0, 1, 0, 1, 0, 1, 1, 1}
                };

        int islandsNo = Queues.islands(matrix);
        System.out.println("Number of islands: " + islandsNo);
    }
}

