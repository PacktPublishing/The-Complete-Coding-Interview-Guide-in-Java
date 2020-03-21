package coding.challenge;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // initialize an array integers        
        int[] integers = {4, 5, 2, 7, 1};

        System.out.println("\n\nSort via Merge sort:");
        System.out.println("----------------------");

        MergeSort.sort(integers);
        System.out.println("Sorted: " + Arrays.toString(integers));
    }
}
