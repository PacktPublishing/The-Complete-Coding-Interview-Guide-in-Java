package coding.challenge;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;

public final class MyQueue<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private int front;    // elements are removed or peeked from the front
    private int rear;     // elements are added in the rear
    private int count;    // size of the queue
    private int capacity; // capacity of the queue (this is doubled when is exceeded)

    private E[] queue;    // the array that sits behind the queue

    // constructor to initialize the queue
    MyQueue() {
        // we use Java Reflection since Java doesn't allow us to instantiate a generic array
        queue = (E[]) Array.newInstance(
                Object[].class.getComponentType(), DEFAULT_CAPACITY);

        count = 0; // initially, the size of the queue is 0
        front = 0; // the index of the first element is 0
        rear = -1; // initially, there is no element in the queue

        capacity = DEFAULT_CAPACITY; // initially, the capacity is of 10 elements
    }

    // add an element 'e' in the queue
    public void enqueue(E e) {

        // if the queue is full, we double its capacity
        if (isFull()) {
            ensureCapacity();
        }

        // adding the element in the rear of the queue
        rear = (rear + 1) % capacity;       
        queue[rear] = e;
        
        // update the size of the queue
        count++;
    }

    // remove and return the front element from the queue
    public E dequeue() {

        // if the queue is empty we just throw a meaningful exception
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        // extract the element from the front
        E e = queue[front];    
        queue[front] = null;        
        
        // set the new front
        front = (front + 1) % capacity;      
        
        // decrease the size of the queue
        count--;
       
        return e;
    }

    // return but not remove the front element in the queue
    public E peek() {
        
        // if the queue is empty we just throw a meaningful exception
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        
            return queue[front];        
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

    // used internally for doubling the queue capacity
    private void ensureCapacity() {       
        int newSize = queue.length * 2;
        queue = Arrays.copyOf(queue, newSize);
        
        // setting the new capacity
        capacity = newSize;
    }
}
