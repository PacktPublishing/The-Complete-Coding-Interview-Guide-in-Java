package coding.challenge;

public final class FallingBall {

    private FallingBall() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void computePath(int prevElevation, int i, int j,
            int rows, int cols, int[][] elevations) {

        if (elevations == null) {
            throw new IllegalArgumentException("Elevations cannot be null");
        }

        // we ensure the ball is still on the grid
        if (i >= 0 && i <= (rows - 1) && j >= 0 && j <= (cols - 1)) {

            int currentElevation = elevations[i][j];
            // we check if the ball can fall from the previous cell to this cell
            if (prevElevation >= currentElevation && currentElevation > 0) {

                // we store the current elevation because we needed it for the next move
                prevElevation = currentElevation;

                // we mark this cell as visited
                elevations[i][j] = 0;

                // try to move the ball 
                computePath(prevElevation, i, j - 1, rows, cols, elevations);
                computePath(prevElevation, i - 1, j, rows, cols, elevations);
                computePath(prevElevation, i, j + 1, rows, cols, elevations);
                computePath(prevElevation, i + 1, j, rows, cols, elevations);
            }
        }
    }
}
