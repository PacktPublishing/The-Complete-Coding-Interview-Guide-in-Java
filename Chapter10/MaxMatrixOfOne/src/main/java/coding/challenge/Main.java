package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

        int[][] matrix = {
            {0, 0, 1, 1, 0, 0, 0}, 
            {0, 0, 1, 1, 1, 1, 1}, 
            {1, 1, 0, 0, 1, 1, 1}, 
            {1, 1, 0, 0, 1, 1, 1}, 
            {0, 1, 1, 0, 0, 0, 0}, 
        };

        // int max = Matrices.ofOne(matrix);
        int max = Matrices.ofOneOptimized(matrix);
        System.out.println("\n\nMax: " + max);
    }

}
