package coding.challenge;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // initialize an array integers        
        int[] integers = {4, 1, 8, 3, 8, 2, 6, 7, 4, 9};

        System.out.println("\n\nSort via Bucket sort:");
        System.out.println("-------------------------");

        int[] integersC1 = integers.clone();
        int[] integersC2 = integers.clone();
        
        BucketSort.sort1(integersC1);
        BucketSort.sort1(integersC2);
        System.out.println("Sorted C1: " + Arrays.toString(integersC1));
        System.out.println("Sorted C2: " + Arrays.toString(integersC2));
    }
}
