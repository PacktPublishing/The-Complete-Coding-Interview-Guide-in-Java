package coding.challenge;

public class KnightTour {
 
    private final int n;

    public KnightTour(int n) {

        if (n <= 1) {
            throw new IllegalArgumentException("The grid must be bigger than " + n + "x" + n);
        }

        this.n = n;
    }

    // all 8 possible movements for a knight
    public static final int COL[] = {1, 2, 2, 1, -1, -2, -2, -1, 1};
    public static final int ROW[] = {2, 1, -1, -2, -2, -1, 1, 2, 2};

    public void knightTour(int r, int c, int cell, int visited[][]) {

        if (r < 0 || c < 0 || cell < 0) {
            throw new IllegalArgumentException("The r, c and cell cannot be negative");
        }

        if (visited == null) {
            throw new IllegalArgumentException("The visited[][] cannot be null");
        }

        // mark current cell as visited
        visited[r][c] = cell;

        // we have a solution
        if (cell >= n * n) {
            print(visited);
            // backtrack before returning
            visited[r][c] = 0;
            return;
        }

        // check for all possible movements (8) and recur for each valid movement
        for (int i = 0; i < (ROW.length - 1); i++) {

            int newR = r + ROW[i];
            int newC = c + COL[i];

            // check if the new position is valid un-visited
            if (isValid(newR, newC) && visited[newR][newC] == 0) {
                knightTour(newR, newC, cell + 1, visited);
            }
        }

        // backtrack from current cell and remove it from current path
        visited[r][c] = 0;
    }

    // check if (r, c) is valid chess board coordinates    
    private boolean isValid(int r, int c) {
        return !(r < 0 || c < 0 || r >= n || c >= n);
    }

    // print the solution as a board
    private void print(int[][] visited) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.format("%3s", visited[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

}
