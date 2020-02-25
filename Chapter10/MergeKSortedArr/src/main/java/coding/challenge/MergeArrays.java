package coding.challenge;

import java.util.Arrays;

public class MergeArrays {

    public static int[] merge(int[][] arrs, int k) {

        // compute the total length of the resulting array
        int len = 0;
        for (int i = 0; i < arrs.length; i++) {
            len += arrs[i].length;
        }

        // create the result array
        int[] result = new int[len];

        // create the min heap
        MinHeap[] heap = new MinHeap[k];

        // add in the heap first element from each array
        for (int i = 0; i < k; i++) {
            heap[i] = new MinHeap(arrs[i][0], i, 0);
        }

        //
        for (int i = 0; i < result.length; i++) {

            heapify(heap, 0, k);

            // add an element in the final result
            result[i] = heap[0].data;

            heap[0].currentIndex++;
            int[] subarray = arrs[heap[0].heapIndex];
            if (heap[0].currentIndex >= subarray.length) {
                heap[0].data = Integer.MAX_VALUE;
            } else {
                heap[0].data = subarray[heap[0].currentIndex];
            }
        }

        return result;
    }

    private static void heapify(MinHeap[] heap, int root, int len) {

        int smallest = root;
        int indexAtTwoRootPlusOne = 2 * root + 1;
        int indexAtTwoRootPlusTwo = 2 * root + 2;

        if (indexAtTwoRootPlusOne < len && heap[smallest].data > heap[indexAtTwoRootPlusOne].data) {
            smallest = indexAtTwoRootPlusOne;
        }

        if (indexAtTwoRootPlusTwo < len && heap[smallest].data > heap[indexAtTwoRootPlusTwo].data) {
            smallest = indexAtTwoRootPlusTwo;
        }

        // swap smallest with root
        if (smallest != root) {
            MinHeap aux = heap[smallest];
            heap[smallest] = heap[root];
            heap[root] = aux;

            heapify(heap, smallest, len);
        }
    }
}
