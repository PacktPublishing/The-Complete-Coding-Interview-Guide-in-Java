package coding.challenge;

import java.awt.Point;
import java.util.Set;

public class RobotGrid {

    // Plain recursion
    // we go recursively from [m, n](bottom-right corner) and try to reach [0, 0] (up-left corner)
    boolean computePath(int m, int n, boolean[][] maze, Set<Point> path) {

        // we fell off the grid so we return
        if (m < 0 || n < 0) {
            return false;
        }

        // we cannot step at this cell
        if (maze[m][n]) {
            return false;
        }

        if (((m == 0) && (n == 0))                      // we reached the target (this is the top-left corner)
                || computePath(m, n - 1, maze, path)    // try to go to the left (remember that we go backward)
                || computePath(m - 1, n, maze, path)) { // try to go to up (remember that we go backward) 

            // we add the cell to the path
            path.add(new Point(m, n));

            return true;
        }

        return false;
    }
    
    // Memoization
    // we go recursively from [m, n](bottom-right corner) and try to reach [0, 0] (up-left corner)
    boolean computePath(int m, int n, boolean[][] maze, Set<Point> path, Set<Point> visited) {

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
        if (visited.contains(cell)) {            
            return false;
        }

        if (((m == 0) && (n == 0))                               // we reached the target (this is the top-left corner)
                || computePath(m, n - 1, maze, path, visited)    // try to go to the left (remember that we go backward)
                || computePath(m - 1, n, maze, path, visited)) { // try to go to up (remember that we go backward) 

            // we add the cell to the path
            path.add(cell);

            return true;
        }

        visited.add(cell);
        return false;
    }
}
