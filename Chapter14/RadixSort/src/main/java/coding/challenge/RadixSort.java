package coding.challenge;

public final class RadixSort {

    private RadixSort() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void sort(int[] arr, int radix) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        if (arr.length == 0) {
            throw new IllegalArgumentException("Array length cannot be 0");
        }

        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] > max) {
                max = arr[i];
            }
        }

        int exp = 1;
        while ((max - min) / exp >= 1) {
            countSortByDigit(arr, radix, exp, min);
            exp *= radix;
        }
    }

    private static void countSortByDigit(
            int[] arr, int radix, int exp, int min) {

        int[] buckets = new int[radix];
        for (int i = 0; i < radix; i++) {
            buckets[i] = 0;
        }

        int bucket;
        for (int i = 0; i < arr.length; i++) {
            bucket = (int) (((arr[i] - min) / exp) % radix);
            buckets[bucket]++;
        }

        for (int i = 1; i < radix; i++) {
            buckets[i] += buckets[i - 1];
        }

        int[] out = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            bucket = (int) (((arr[i] - min) / exp) % radix);
            out[--buckets[bucket]] = arr[i];
        }

        System.arraycopy(out, 0, arr, 0, arr.length);
    }
}
