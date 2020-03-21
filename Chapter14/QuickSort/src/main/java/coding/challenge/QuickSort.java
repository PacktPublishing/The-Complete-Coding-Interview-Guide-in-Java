package coding.challenge;

import java.util.Comparator;

public final class QuickSort {

    private QuickSort() {
        throw new AssertionError("Cannot be instantiated");
    }

    /* Quick sort for primitives (e.g., integers) */
    public static void sort(int[] arr, int left, int right) {

        if (left < right) {
            int m = partition(arr, left, right);         

            sort(arr, left, m - 1);
            sort(arr, m + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {

        int pivot = arr[right];        
        int m = left;        
        for (int i = m; i < right; i++) {
            if (arr[i] <= pivot) {                
                swap(arr, i, m++);                
            }
        }

        swap(arr, right, m);

        return m;
    }

    /* Quick sort with Comparator */
    public static <T> void sortWithComparator(
            T[] arr, int left, int right, Comparator<? super T> c) {

        if (left < right) {
            int m = partitionWithComparator(arr, left, right, c);

            sortWithComparator(arr, left, m - 1, c);
            sortWithComparator(arr, m + 1, right, c);
        }
    }

    private static <T> int partitionWithComparator(
            T[] arr, int left, int right, Comparator<? super T> c) {

        T pivot = arr[right];
        int m = left;
        for (int i = m; i < right; i++) {
            if (c.compare(arr[i], pivot) <= 0) {
                swap(arr, i, m++);
            }
        }

        swap(arr, right, m);

        return m;
    }

    /* Helper methods */
    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private static <T> void swap(T[] arr, int x, int y) {
        T temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

}
