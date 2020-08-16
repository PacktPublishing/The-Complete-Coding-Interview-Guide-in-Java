package coding.challenge;
 
public final class Matrices {

    private Matrices() {
        throw new AssertionError("Cannot be instantiated");
    }

    /* Iterative approach (searchRecursive() listed below is the recursive code) */
    public static boolean search(int[][] matrix, int element) {

        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            
            if (matrix[row][col] == element) {
                return true;
            } else if (matrix[row][col] > element) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }

    /* Search via recursion - this is the recursive approach of the above search() method */
    public static boolean searchRecursive(int[][] matrix, int element) {

        if (matrix == null || matrix.length == 0) {
            return false;
        }

        return searchRecursive(matrix, matrix.length - 1, 0, matrix[0].length - 1, element);
    }

    private static boolean searchRecursive(int[][] matrix, int row, int col,
            int cols, int element) {

        if (row < 0 || col > cols) {
            return false;
        }

        if (matrix[row][col] == element) {
            return true;
        } else {
            if (element > matrix[row][col]) {
                return searchRecursive(matrix, row, col + 1, cols, element);
            } else {
                return searchRecursive(matrix, row - 1, col, cols, element);
            }
        }
    }
}
