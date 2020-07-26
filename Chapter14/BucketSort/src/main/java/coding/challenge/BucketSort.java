package coding.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class BucketSort {

    private BucketSort() {
        throw new AssertionError("Cannot be instantiated");
    }

    /* Scatter-Sort-Gather approach */
    public static void sort1(int[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        // get the hash codes 
        int[] hashes = hash(arr);

        // create and initialize buckets
        List<Integer>[] buckets = new List[hashes[1]];
        for (int i = 0; i < hashes[1]; i++) {
            buckets[i] = new ArrayList();
        }

        // scatter elements into buckets
        for (int e : arr) {
            buckets[hash(e, hashes)].add(e);
        }

        // sort each bucket
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        // gather elements from the buckets
        int p = 0;
        for (List<Integer> bucket : buckets) {
            for (int j : bucket) {
                arr[p++] = j;
            }
        }
    }

    private static int[] hash(int[] arr) {

        int m = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (m < arr[i]) {
                m = arr[i];
            }
        }

        return new int[]{m, (int) Math.sqrt(arr.length)};
    }

    private static int hash(int num, int[] hashes) {
        return (int) ((double) num / hashes[0] * (hashes[1] - 1));
    }

    /* Scatter-Gather approach */
    public static void sort2(int[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        // get the maximum value of the given array
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // create max buckets
        int[] bucket = new int[max + 1];

        // in Java, the bucket[] is automatically initialized with 0s, 
        // therefore this step is redundant
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = 0;
        }

        // scatter elements in buckets
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }

        // gather elements from the buckets
        int p = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                arr[p++] = i;
            }
        }
    }
}
