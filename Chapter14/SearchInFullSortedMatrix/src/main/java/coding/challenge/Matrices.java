package coding.challenge;

public final class Matrices {

    private Matrices() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static boolean search(int[][] m, int element) {

        if (m == null || m.length == 0) {
            return false;
        }

        int rows = m.length;    // number of rows
        int cols = m[0].length; // number of columns

        // search space is an array as [0, (rows * cols) - 1]
        int left = 0;
        int right = (rows * cols) - 1;

        // start binary search
        while (left <= right) {

            int mid = (left + right) / 2;
            int midElement = m[mid / cols][mid % cols];

            if (element == midElement) {
                return true;
            } else if (element < midElement) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

}
