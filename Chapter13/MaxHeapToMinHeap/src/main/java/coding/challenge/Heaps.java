package coding.challenge;
 
public class Heaps {

    // convert max heap to min heap (O(n))
    public static void convertToMinHeap(int[] maxHeap) {

        if (maxHeap == null) {
            throw new IllegalArgumentException("The given max heap cannot be null");
        }

        // build heap from last node to all the way up to the root node
        int p = (maxHeap.length - 2) / 2;
        while (p >= 0) {
            heapifyMin(maxHeap, p--, maxHeap.length);
        }
    }

    // heapify the node at index p and its two direct children    
    private static void heapifyMin(int[] maxHeap, int p, int size) {

        // get left and right child of node at index p
        int left = leftChild(p);
        int right = rightChild(p);

        int smallest = p;

        // compare maxHeap[p] with its left and 
        // right child and find the smallest value
        if ((left < size) && (maxHeap[left] < maxHeap[p])) {
            smallest = left;
        }

        if ((right < size) && (maxHeap[right] < maxHeap[smallest])) {
            smallest = right;
        }

        // swap 'smallest' with 'p' and heapify
        if (smallest != p) {
            swap(maxHeap, p, smallest);
            heapifyMin(maxHeap, smallest, size);
        }
    }

    // convert min heap to max heap (O(n))
    public static void convertToMaxHeap(int[] minHeap) {

        if (minHeap == null) {
            throw new IllegalArgumentException("The given min heap cannot be null");
        }

        // build heap from last node to all the way up to the root node
        int p = (minHeap.length - 2) / 2;
        while (p >= 0) {
            heapifyMax(minHeap, p--, minHeap.length);
        }
    }

    // heapify the node at index p and its two direct children    
    private static void heapifyMax(int[] minHeap, int p, int size) {

        // get left and right child of node at index p
        int left = leftChild(p);
        int right = rightChild(p);

        int largest = p;

        // compare minHeap[p] with its left and 
        // right child and find the largest value
        if ((left < size) && (minHeap[left] > minHeap[p])) {
            largest = left;
        }

        if ((right < size) && (minHeap[right] > minHeap[largest])) {
            largest = right;
        }

        // swap 'largest' with 'p' and heapify
        if (largest != p) {
            swap(minHeap, p, largest);
            heapifyMax(minHeap, largest, size);
        }
    }

    /* Helper methods */
    private static int leftChild(int parentIndex) {
        return (2 * parentIndex + 1);
    }

    private static int rightChild(int parentIndex) {
        return (2 * parentIndex + 2);
    }

    // utility function to swap two indices in the array
    private static void swap(int heap[], int i, int j) {
        int aux = heap[i];
        heap[i] = heap[j];
        heap[j] = aux;
    }
}
