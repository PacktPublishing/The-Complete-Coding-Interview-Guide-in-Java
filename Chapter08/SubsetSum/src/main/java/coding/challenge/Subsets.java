package coding.challenge;

public final class Subsets {

    private Subsets() {
        throw new AssertionError("Cannot be instantiated");
    }

    /* Recursive approach */
    public static void findSumRecursive(int[] arr, int index, 
            int currentSum, int givenSum, int[] subset) {

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

        boolean[][] subset = new boolean[arr.length + 1][givenSum + 1];

        for (int i = 1; i <= givenSum; i++) {
            subset[0][i] = false;
        }

        for (int i = 0; i <= arr.length; i++) {
            subset[i][0] = true;
        }

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= givenSum; j++) {

                // first copy the data from the top
                subset[i][j] = subset[i - 1][j];

                // if subset[i][j] == false check if can be made
                if (subset[i][j] == false && j >= arr[i - 1]) {
                    subset[i][j] = subset[i][j] || subset[i - 1][j - arr[i - 1]];
                }
            }
        }

        printSubsetMatrix(arr, givenSum, subset);

        return subset[arr.length][givenSum];
    }

    private static void printSubsetMatrix(int[] arr, int givenSum, boolean subset[][]) {

        System.out.println("\nSubset matrix for sum " + givenSum + ": ");
        System.out.print("\t");
        for (int j = 0; j <= givenSum; j++) {
            System.out.print(j + "\t");
        }
        System.out.println();

        for (int i = 0; i <= arr.length; i++) {
            System.out.print(i == 0 ? 0 + "\t" : arr[i - 1] + "\t");
            for (int j = 0; j <= givenSum; j++) {
                System.out.print(subset[i][j] ? "T\t" : "F\t");
            }
            System.out.println();
        }
    }
}
