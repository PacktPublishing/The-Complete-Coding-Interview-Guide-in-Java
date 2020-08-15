package coding.challenge;
 
public class MergeArrays {

    public static int[] merge(int[][] arrs, int k) {

        if (arrs == null) {
            throw new IllegalArgumentException("The given arrays cannot be null");
        }

        if (k <= 0) {
            throw new IllegalArgumentException("The number of given arrays cannot be less or equal to 0");
        }

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

        // perform merging
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

    // removes the minimum element from the heap, O(log n)
    private static void heapify(MinHeap[] heap, int root, int len) {

        int smallest = root;
        int leftIndex = left(root);
        int rightIndex = right(root);

        if (leftIndex < len && heap[smallest].data > heap[leftIndex].data) {
            smallest = leftIndex;
        }

        if (rightIndex < len && heap[smallest].data > heap[rightIndex].data) {
            smallest = rightIndex;
        }

        // swap smallest with root
        if (smallest != root) {
            swap(heap, smallest, root);
            heapify(heap, smallest, len);
        }
    }

    private static void swap(MinHeap[] heap, int i, int j) {
        MinHeap aux = heap[i];
        heap[i] = heap[j];
        heap[j] = aux;
    }

    // to get index of left child of node at index i 
    private static int left(int i) {
        return (2 * i + 1);
    }

    // to get index of right child of node at index i 
    private static int right(int i) {
        return (2 * i + 2);
    }
}
