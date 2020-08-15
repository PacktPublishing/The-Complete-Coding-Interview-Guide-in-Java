package coding.challenge;
 
public final class Containers {

    private Containers() {
        throw new AssertionError("Cannot be instantiated");
    }

    /* O(n^2) */
    public static int maxArea(int[] heights) {

        if (heights == null) {
            throw new IllegalArgumentException("The given array cannot be null");
        }

        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                // traverse each (i, j) pair
                maxArea = Math.max(maxArea, Math.min(heights[i], heights[j]) * (j - i));
            }
        }

        return maxArea;
    }

    /* O(n) */
    public static int maxAreaOptimized(int[] heights) {

        if (heights == null) {
            throw new IllegalArgumentException("The given array cannot be null");
        }

        int maxArea = 0;

        int i = 0; // left-hand side pointer            
        int j = heights.length - 1; // right-hand side pointer

        // area cannot be negative, therefore i should not be greater than j
        while (i < j) {

            // calculate area for each pair
            maxArea = Math.max(maxArea, Math.min(heights[i], heights[j]) * (j - i));

            if (heights[i] <= heights[j]) {
                i++; // left pointer is small than right pointer
            } else {
                j--; // right pointer is small than left pointer
            }
        }

        return maxArea;
    }
}
