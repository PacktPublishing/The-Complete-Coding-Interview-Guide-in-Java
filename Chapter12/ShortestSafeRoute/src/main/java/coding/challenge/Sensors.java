package coding.challenge;
 
import java.util.ArrayDeque;
import java.util.Queue;

public class Sensors {

    private Sensors() {
        throw new AssertionError("Cannot be instantiated");
    }

    // a board cell
    private static class Cell {

        int r;        // row
        int c;        // column
        int distance; // distance from current cell to the start cell

        Cell(int r, int c, int distance) {
            this.r = r;
            this.c = c;
            this.distance = distance;
        }
    };

    // m x n board
    private static final int M = 10;
    private static final int N = 10;

    // the 4 possible movements from a cell (top, right, bottom, left)
    private static final int ROW_4[] = {-1, 0, 0, 1};
    private static final int COL_4[] = {0, -1, 1, 0};

    // the 8 possible movements from a cell (top, right, bottom, left and diagonals)
    private static final int ROW_8[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int COL_8[] = {-1, 0, 1, -1, 1, -1, 0, 1};

    // find the shortest path from first column to last column in given board
    public static int shortestPath(int[][] board) {

        // mark adjacent cells of sensors as unsafe
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 8; k++) {
                    if (board[i][j] == 0 && isValid(i + ROW_8[k], j + COL_8[k])
                            && board[i + ROW_8[k]][j + COL_8[k]] == 1) {
                        board[i + ROW_8[k]][j + COL_8[k]] = -1;
                    }
                }
            }
        }

        // update the field
        for (int i = 0; i < M; i++) {
            System.out.println();
            for (int j = 0; j < N; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
                System.out.print(board[i][j] + "  ");
            }
        }

        // call BFS traversal to fins the shortes path
        return findShortestPath(board);
    }

    // Find minimum number of steps (shortest path or distance) required 
    // to traverse the board from first to the last column
    private static int findShortestPath(int[][] board) {

        // stores if cell is visited or not
        boolean[][] visited = new boolean[M][N];

        Queue<Cell> queue = new ArrayDeque<>();

        // process every cell of first column
        for (int r1 = 0; r1 < M; r1++) {
            // if the cell is safe, mark it as visited and
            // enqueue it by assigning it distance as 0 from itself
            if (board[r1][0] == 1) {
                queue.add(new Cell(r1, 0, 0));
                visited[r1][0] = true;
            }
        }

        while (!queue.isEmpty()) {

            // pop the front node from queue and process it
            int rIdx = queue.peek().r;
            int cIdx = queue.peek().c;
            int dist = queue.peek().distance;

            queue.poll();

            // if destination is found then return minimum distance
            if (cIdx == N - 1) {
                return (dist + 1);
            }

            // check for all 4 possible movements from 
            // current cell and enqueue each valid movement
            for (int k = 0; k < 4; k++) {
                if (isValid(rIdx + ROW_4[k], cIdx + COL_4[k])
                        && isSafe(board, visited, rIdx + ROW_4[k], cIdx + COL_4[k])) {

                    // mark it as visited and push it into queue with (+1) distance
                    visited[rIdx + ROW_4[k]][cIdx + COL_4[k]] = true;
                    queue.add(new Cell(rIdx + ROW_4[k], cIdx + COL_4[k], dist + 1));
                }
            }
        }

        return -1;
    }

    // check if it is safe to go to position (r, c) from current position    
    private static boolean isSafe(int[][] board,
            boolean visited[][], int r, int c) {
        return (board[r][c] == 1 && !visited[r][c]);
    }

    // check if (r, c) is on the board 
    private static boolean isValid(int r, int c) {
        return (r < M && c < N && r >= 0 && c >= 0);
    }
}
