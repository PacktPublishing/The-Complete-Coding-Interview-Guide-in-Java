package coding.challenge;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;

public final class MyQueue<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private int front;
    private int rear;
    private int count;
    private int capacity;

    private E[] queue;

    // constructor to initialize the queue
    MyQueue() {
        queue = (E[]) Array.newInstance(
                Object[].class.getComponentType(), DEFAULT_CAPACITY);

        count = 0; // queue size
        front = 0; // front of the queue 
        rear = -1; // back of the queue

        capacity = DEFAULT_CAPACITY;
    }

    // add an element e in the queue
    public void enqueue(E e) {

        // if the queue is full, we double its capacity
        if (isFull()) {
            ensureCapacity();
        }

        rear = (rear + 1) % capacity;
        queue[rear] = e;
        count++;
    }

    // remove and return the front element from the queue
    public E dequeue() {

        if (isEmpty()) {
            throw new EmptyStackException();
        }

        E e = queue[front];
        front = (front + 1) % capacity;
        count--;

        return e;
    }

    // return but not remove the front element in the queue
    public E peek() {
        if (!isEmpty()) {
            return queue[front];
        }

        throw new EmptyStackException();
    }

    // size of the queue
    public int size() {
        return count;
    }

    // check if the queue is empty or not
    public boolean isEmpty() {
        return size() == 0;
    }

    // check if the queue is full or not
    public boolean isFull() {
        return size() == capacity;
    }

    private void ensureCapacity() {       
        int newSize = queue.length * 2;
        queue = Arrays.copyOf(queue, newSize);
        capacity = newSize;
    }
}
