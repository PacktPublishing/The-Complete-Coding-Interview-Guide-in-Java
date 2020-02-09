package coding.challenge;

import java.util.Set;

public class FiveTower {

    protected static final int GRID_SIZE = 5; // (5x5)

    void buildTowers(int row, Integer[] columns, Set<Integer[]> solutions) {
        
        if (row == GRID_SIZE) {
            solutions.add(columns.clone());
        } else {
            for (int col = 0; col < GRID_SIZE; col++) {

                if (success(columns, row, col)) {

                    // place this tower
                    columns[row] = col;
                    
                    // go to the next row
                    buildTowers(row + 1, columns, solutions);
                }
            }
        }
    }

    private boolean success(Integer[] columns, int nextRow, int nextColumn) {

        for (int currentRow = 0; currentRow < nextRow; currentRow++) {
            int currentColumn = columns[currentRow];

            // cannot place on the same column
            if (currentColumn == nextColumn) {
                return false;
            }

            int columnsDistance = Math.abs(currentColumn - nextColumn);
            int rowsDistance = nextRow - currentRow;
            
            // cannot place on the same diagonal
            if (columnsDistance == rowsDistance) {
                return false;
            }
        }
        
        return true;
    }
}
