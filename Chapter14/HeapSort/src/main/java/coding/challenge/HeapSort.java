package coding.challenge;

import java.util.Comparator;

public final class HeapSort {

    private HeapSort() {
        throw new AssertionError("Cannot be instantiated");
    }

    /* Heap sort for primitives (e.g., integers) */
    public static void sort(int[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        if (arr.length == 0) {
            throw new IllegalArgumentException("Array length cannot be 0");
        }

        int n = arr.length;
        buildHeap(arr, n);
        while (n > 1) {
            swap(arr, 0, n - 1);
            n--;
            heapify(arr, n, 0);
        }
    }

    private static void buildHeap(int[] arr, int n) {
        for (int i = arr.length / 2; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    private static void heapify(int[] arr, int n, int i) {

        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int greater;

        if (left < n && arr[left] > arr[i]) {
            greater = left;
        } else {
            greater = i;
        }

        if (right < n && arr[right] > arr[greater]) {
            greater = right;
        }

        if (greater != i) {
            swap(arr, i, greater);
            heapify(arr, n, greater);
        }
    }

    /* Heap sort with Comparator */
    public static <T> void sortWithComparator(T[] arr, Comparator<? super T> c) {

        if (arr == null || c == null) {
            throw new IllegalArgumentException("Array/Comparator cannot be null");
        }

        if (arr.length == 0) {
            throw new IllegalArgumentException("Array length cannot be 0");
        }

        int n = arr.length;
        buildHeap(arr, n, c);
        while (n > 1) {
            swap(arr, 0, n - 1);
            n--;
            heapify(arr, n, 0, c);
        }
    }

    private static <T> void buildHeap(T[] arr, int n, Comparator<? super T> c) {
        for (int i = arr.length / 2; i >= 0; i--) {
            heapify(arr, n, i, c);
        }
    }

    private static <T> void heapify(T[] arr, int n, int i, Comparator<? super T> c) {

        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int greater;

        if (left < n && c.compare(arr[left], arr[i]) > 0) {
            greater = left;
        } else {
            greater = i;
        }

        if (right < n && c.compare(arr[right], arr[greater]) > 0) {
            greater = right;
        }

        if (greater != i) {
            swap(arr, i, greater);
            heapify(arr, n, greater, c);
        }
    }

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
