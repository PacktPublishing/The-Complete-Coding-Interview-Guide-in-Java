package coding.challenge;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] firstArr = {4, 1, 8, 1, 3, 8, 6, 7, 4, 9, 8, 2, 5, 3};
        int[] secondArr = {7, 4, 8, 11, 2};

        System.out.println("Before: " + Arrays.toString(firstArr));
        Sorts.custom(firstArr, secondArr);
        System.out.println("After: " + Arrays.toString(firstArr));
    }
}
