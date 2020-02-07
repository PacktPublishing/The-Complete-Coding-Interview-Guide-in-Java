package coding.challenge;

public class RobotGrid {

    // Plain recursion    
    int countPaths(int m, int n) {

        // go in any cell of the first column/row is 1
        if (m == 1 || n == 1) {
            return 1;
        }

        return countPaths(m - 1, n) + countPaths(m, n - 1);
        // if diagonal movements are allowed then add: + numberOfPaths(m-1, n-1);
    }

    // Memoization
    int countPathsBottomUp(int m, int n) {
        // cache the results of subproblems
        int[][] count = new int[m][n];

        // go in any cell of the first row is 1
        for (int j = 0; j < n; j++) {
            count[0][j] = 1;
        }

        // go in any cell of the first column is 1
        for (int i = 0; i < m; i++) {
            count[i][0] = 1;
        }

        // determine the paths for other cells in bottom-up manner
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                count[i][j] = count[i - 1][j] + count[i][j - 1]; 
                // if diagonal movements are allowed then add: + count[i-1][j-1];
            }
        }

        return count[m - 1][n - 1];
    }
}
