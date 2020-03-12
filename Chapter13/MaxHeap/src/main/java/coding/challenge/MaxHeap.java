package coding.challenge;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class MaxHeap<T extends Comparable<T>> {

    private static final int DEFAULT_CAPACITY = 5;

    private int capacity;
    private int size;
    private T[] heap;

    public MaxHeap() {

        capacity = DEFAULT_CAPACITY;
        this.heap = (T[]) Array.newInstance(
                Comparable[].class.getComponentType(), DEFAULT_CAPACITY);
    }

    // Adding is done in O(log n) time
    public void add(T element) {

        ensureCapacity();

        heap[size] = element;
        size++;

        heapifyUp();
    }

    private void ensureCapacity() {

        if (size == capacity) {
            heap = Arrays.copyOf(heap, capacity * 2);
            capacity = capacity * 2;
        }
    }

    // Peeking is done in O(1) time
    public T peek() {

        if (size == 0) {
            throw new NoSuchElementException();
        }

        return heap[0];
    }

    // Polling is done in O(log n) time
    public T poll() {

        if (size == 0) {
            throw new NoSuchElementException();
        }

        T element = heap[0];

        heap[0] = heap[size - 1];
        heap[size - 1] = null;

        size--;

        heapifyDown();

        return element;
    }

    public void printHeap() {
        System.out.print("ROOT NODE: " + heap[0] + "\n");
        for (int i = 0; i < size; i++) {
            System.out.print("NODE: " + heap[i]);
            if (hasLeftChild(i)) {
                System.out.print(" LEFT NODE: " + heap[getLeftChildIndex(i)]);
            }
            if (hasRightChild(i)) {
                System.out.print(" RIGHT NODE: " + heap[getRightChildIndex(i)]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private void heapifyDown() {
        int index = 0;

        while (hasLeftChild(index)) {
            int largestChildIndex = getLeftChildIndex(index);

            if (hasRightChild(index) && rightChild(index).compareTo(leftChild(index)) > 0) {
                largestChildIndex = getRightChildIndex(index);
            }

            if (heap[index].compareTo(heap[largestChildIndex]) < 0) {
                swap(index, largestChildIndex);
            } else {
                break;
            }

            index = largestChildIndex;
        }
    }

    private void heapifyUp() {
        int index = size - 1;

        while (hasParent(index) && parent(index).compareTo(heap[index]) < 0) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private T leftChild(int parentIndex) {
        return heap[getLeftChildIndex(parentIndex)];
    }

    private T rightChild(int parentIndex) {
        return heap[getRightChildIndex(parentIndex)];
    }

    private T parent(int childIndex) {
        return heap[getParentIndex(childIndex)];
    }

    private void swap(int index1, int index2) {
        T element = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = element;
    }

    public int size() {
        return size;
    }
}
