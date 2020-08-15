package coding.challenge;
 
public final class Subsets {

    private Subsets() {
        throw new AssertionError("Cannot be instantiated");
    }

    /* Recursive approach */
    public static void findSumRecursive(int[] arr, int index,
            int currentSum, int givenSum, int[] subset) {

        if (arr == null || arr.length == 0
                || index < 0 || currentSum < 0 || givenSum < 0
                || subset == null || subset.length != arr.length) {
            throw new IllegalArgumentException("The given argument(s) are wrong");
        }

        if (currentSum == givenSum) {
            System.out.print("\nSubset found: ");
            for (int i = 0; i < subset.length; i++) {
                if (subset[i] == 1) {
                    System.out.print(arr[i] + " ");
                }
            }
        } else if (index != arr.length) {

            subset[index] = 1;
            currentSum += arr[index];

            findSumRecursive(arr, index + 1, currentSum, givenSum, subset);

            currentSum -= arr[index];
            subset[index] = 0;

            findSumRecursive(arr, index + 1, currentSum, givenSum, subset);
        }
    }

    /* Dynamic Programming (Bottom-Up) */
    public static boolean findSumDP(int[] arr, int givenSum) {

        if (arr == null || arr.length == 0 || givenSum < 0) {
            throw new IllegalArgumentException("The given argument(s) are wrong");
        }

        boolean[][] matrix = new boolean[arr.length + 1][givenSum + 1];

        // prepare the first row
        for (int i = 1; i <= givenSum; i++) {
            matrix[0][i] = false;
        }

        // prepare the first column
        for (int i = 0; i <= arr.length; i++) {
            matrix[i][0] = true;
        }

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= givenSum; j++) {

                // first, copy the data from the above row
                matrix[i][j] = matrix[i - 1][j];

                // if matrix[i][j] == false compute if the value should be F or T
                if (matrix[i][j] == false && j >= arr[i - 1]) {
                    matrix[i][j] = matrix[i][j] || matrix[i - 1][j - arr[i - 1]];
                }
            }
        }

        printSubsetMatrix(arr, givenSum, matrix);
        printOneSubset(matrix, arr, arr.length, givenSum);

        return matrix[arr.length][givenSum];
    }

    private static void printOneSubset(boolean[][] matrix, int[] arr, int row, int col) {

        int i = row;
        int j = col;

        System.out.println("\nSubset: ");
        while (i > 0 && j >= 0) {
            int value = arr[i - 1];
            if (j - value >= 0 && matrix[i - 1][j - value] && !matrix[i - 1][j]) {
                i = i - 1;
                j = j - value;
                System.out.print(value + " ");
            } else {
                i--;
            }
        }
    }

    private static void printSubsetMatrix(int[] arr, int givenSum, boolean matrix[][]) {

        System.out.println("\nSubset matrix for sum " + givenSum + ": ");
        System.out.print("\t");
        for (int j = 0; j <= givenSum; j++) {
            System.out.print(j + "\t");
        }
        System.out.println();

        for (int i = 0; i <= arr.length; i++) {
            System.out.print(i == 0 ? 0 + "\t" : arr[i - 1] + "\t");
            for (int j = 0; j <= givenSum; j++) {
                System.out.print(matrix[i][j] ? "T\t" : "F\t");
            }
            System.out.println();
        }
    }
}
