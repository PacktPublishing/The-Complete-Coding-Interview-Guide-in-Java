package coding.challenge;

public final class MergeSort {

    private MergeSort() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void sort(int[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        if (arr.length > 1) {
            int[] left = leftHalf(arr);
            int[] right = rightHalf(arr);

            sort(left);
            sort(right);

            merge(arr, left, right);
        }
    }

    private static int[] leftHalf(int[] arr) {

        int size = arr.length / 2;
        int[] left = new int[size];
        System.arraycopy(arr, 0, left, 0, size);

        return left;
    }

    private static int[] rightHalf(int[] arr) {

        int size1 = arr.length / 2;
        int size2 = arr.length - size1;
        int[] right = new int[size2];
        for (int i = 0; i < size2; i++) {
            right[i] = arr[i + size1];
        }

        return right;
    }

    private static void merge(int[] result, int[] left, int[] right) {

        int t1 = 0;
        int t2 = 0;

        for (int i = 0; i < result.length; i++) {
            if (t2 >= right.length || (t1 < left.length && left[t1] <= right[t2])) {
                result[i] = left[t1];
                t1++;
            } else {
                result[i] = right[t2];
                t2++;
            }
        }
    }
}
