package coding.challenge;
 
import java.awt.Point;
import java.util.Set;

public final class RobotGrid {

    private RobotGrid() {
        throw new AssertionError("Cannot be instantiated");
    }

    // Plain recursion
    // we go recursively from [m, n] (top-left corner) and try to reach [0, 0] (bottom-right corner)
    public static boolean computePath(int m, int n, boolean[][] maze, Set<Point> path) {

        if (path == null || maze == null) {
            throw new IllegalArgumentException("Path and maze cannot be null");
        }

        // we fell off the grid so we return
        if (m < 0 || n < 0) {
            return false;
        }

        // we cannot step at this cell
        if (maze[m][n]) {
            return false;
        }

        if (((m == 0) && (n == 0)) // we reached the target (this is the bottom-right corner)
                || computePath(m, n - 1, maze, path) // try to go to the right
                || computePath(m - 1, n, maze, path)) { // try to go to down

            // we add the cell to the path
            path.add(new Point(m, n));

            return true;
        }

        return false;
    }

    // Memoization
    // we go recursively from [m, n](top-left corner) and try to reach [0, 0] (bottom-right corner)
    public static boolean computePath(int m, int n, boolean[][] maze, Set<Point> path, Set<Point> visitFailed) {

        if (path == null || maze ==null || visitFailed == null) {
            throw new IllegalArgumentException("Path, maze and visitFailed cannot be null");
        }
        
        // we fell off the grid so we return
        if (m < 0 || n < 0) {
            return false;
        }

        // we cannot step at this cell
        if (maze[m][n]) {
            return false;
        }

        Point cell = new Point(m, n);

        // Check if we've already visited this cell
        if (visitFailed.contains(cell)) {
            return false;
        }

        if (((m == 0) && (n == 0)) // we reached the target (this is the bottom-right corner)
                || computePath(m, n - 1, maze, path, visitFailed) // try to go to the right
                || computePath(m - 1, n, maze, path, visitFailed)) { // try to go to down

            // we add the cell to the path
            path.add(cell);

            return true;
        }

        visitFailed.add(cell);
        return false;
    }
}
