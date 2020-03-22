package coding.challenge;

public final class BucketSort {

    private BucketSort() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void sort(int[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int[] bucket = new int[max + 1];

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = 0;
        }

        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }

        int p = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                arr[p++] = i;
            }
        }
    }
}
