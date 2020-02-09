package coding.challenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Set<Integer[]> solutions = new HashSet<>();

        Queens queens = new Queens();
        queens.arrangeQueens(0, new Integer[Queens.GRID_SIZE], solutions);

        for (Integer[] solution : solutions) {
            System.out.println(Arrays.toString(solution));
        }
    }

}
