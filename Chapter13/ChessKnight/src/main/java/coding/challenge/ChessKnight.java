package coding.challenge;
 
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class ChessKnight {

    private class Node {

        // (r, c): chess board coordinates, (row, column)
        // distance: minimum distance from the source (from the starting cell)
        private final int r;
        private final int c;
        private int distance;

        private Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        private Node(int r, int c, int distance) {
            this.r = r;
            this.c = c;
            this.distance = distance;
        }
    }

    // all 8 possible movements for a knight
    private static final int[] ROW = {2, 2, -2, -2, 1, 1, -1, -1};
    private static final int[] COL = {-1, 1, 1, -1, 2, -2, 2, -2};

    public int countknightMoves(int rs, int cs, int rt, int ct, int n) {

        // source (start cell) coordinates
        Node startCell = new Node(rs, cs);

        // destination (end cell) coordinates
        Node targetCell = new Node(rt, ct);

        return countknightMoves(startCell, targetCell, n);
    }

    // Find minimum number of steps taken by the knight
    // from the start cell to the target cell using BFS
    private int countknightMoves(Node startCell, Node targetCell, int n) {

        // store the visited cells
        Set<Node> visited = new HashSet<>();

        // create a queue and enqueue the first cell (the starting cell)
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(startCell);

        while (!queue.isEmpty()) {

            Node cell = queue.poll();

            int r = cell.r;
            int c = cell.c;
            int distance = cell.distance;

            // if destination is reached, return the distance
            if (r == targetCell.r && c == targetCell.c) {
                return distance;
            }

            // the cell was not visited
            if (!visited.contains(cell)) {

                // mark current cell as visited
                visited.add(cell);

                // enqueue each valid movement into the queue (there are 8 possible movements)                
                for (int i = 0; i < 8; ++i) {

                    // get the new valid position of knight from current
                    // position on chessboard and enqueue it in the queue with +1 distance
                    int rt = r + ROW[i];
                    int ct = c + COL[i];

                    if (valid(rt, ct, n)) {
                        queue.add(new Node(rt, ct, distance + 1));
                    }
                }
            }
        }

        // if path is not possible
        return Integer.MAX_VALUE;
    }

    // Check if (r, c) is valid (the knight cannot go out of the chessboard)
    private static boolean valid(int r, int c, int n) {
        if (r < 0 || c < 0 || r >= n || c >= n) {
            return false;
        }

        return true;
    }
}
