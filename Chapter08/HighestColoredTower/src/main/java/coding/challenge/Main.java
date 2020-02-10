package coding.challenge;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Box b1 = new Box(10, 5, 2);
        Box b2 = new Box(10, 7, 1);
        Box b3 = new Box(10, 3, 1);
        Box b4 = new Box(14, 10, 3);
        Box b5 = new Box(5, 7, 1);
        Box b6 = new Box(7, 5, 1);
        Box b7 = new Box(2, 8, 1);

        List<Box> boxes = Arrays.asList(b1, b2, b3, b4, b5, b6, b7);

        Tower tower = new Tower();
        int highest = tower.build(boxes);

        System.out.println("\nThe highest tower of colored boxes has a high of: " + highest);
    }

}
