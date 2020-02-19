package coding.challenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Set<Integer[]> solutions = new HashSet<>();
       
        FiveTower.buildTowers(0, new Integer[FiveTower.GRID_SIZE], solutions);

        System.out.println("Solutions:");
        for (Integer[] solution : solutions) {
            System.out.println(Arrays.toString(solution));
        }
    }

}
