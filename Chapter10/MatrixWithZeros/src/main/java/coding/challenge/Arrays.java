package coding.challenge;

public final class Arrays {

    private Arrays() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void alignZeros(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException("The given matrix cannot be null or empty");
        }

        boolean firstRowHasZeros = false;
        boolean firstColumnHasZeros = false;

        // Search at least a zero on first row
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                firstRowHasZeros = true;
                break;
            }
        }

        // Search at least a zero on first column
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstColumnHasZeros = true;
                break;
            }
        }

        // Search all zeros in the rest of the matrix
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Loop first column and propagate each found zero on the row
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                setRowOfZero(matrix, i);
            }
        }

        // Loop first row and propagate each found zero on the column
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                setColumnOfZero(matrix, j);
            }
        }

        // If the first row has at least one 0 then set the entire row to 0
        if (firstRowHasZeros) {
            setRowOfZero(matrix, 0);
        }

        // If the first column has at least one 0 then set the entire column to 0
        if (firstColumnHasZeros) {
            setColumnOfZero(matrix, 0);
        }

    }

    private static void setRowOfZero(int[][] matrix, int r) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[r][j] = 0;
        }
    }

    private static void setColumnOfZero(int[][] matrix, int c) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][c] = 0;
        }
    }

}
