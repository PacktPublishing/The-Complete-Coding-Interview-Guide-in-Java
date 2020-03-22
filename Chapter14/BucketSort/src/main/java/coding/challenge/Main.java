package coding.challenge;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // initialize an array integers        
        int[] integers = {4, 5, 2, 7, 1};

        System.out.println("\n\nSort via Bucket sort:");
        System.out.println("-------------------------");

        BucketSort.sort(integers);
        System.out.println("Sorted: " + Arrays.toString(integers));
    }
}
