package coding.challenge;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;

public final class MyStack<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private int top;   // the top element from the stack
    private E[] stack; // the array that sits behind the stack

    // constructor to initialize the stack
    MyStack() {

        // we use Java Reflection since Java doesn't allow us to instantiate a generic array
        stack = (E[]) Array.newInstance(
                Object[].class.getComponentType(), DEFAULT_CAPACITY);

        top = 0; // the initial size is 0
    }

    // add an element 'e' in the stack
    public void push(E e) {

        // if the stack is full, we double its capacity
        if (isFull()) {
            ensureCapacity();
        }

        // adding the element at the top of the stack
        stack[top++] = e;
    }

    // pop top element from the stack
    public E pop() {

        // if the stack is empty then just throw a meaningful exception
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        // extract the top element from the stack                
        E e = stack[--top];

        // avoid memory leaks
        stack[top] = null;

        return e;
    }

    // return but not remove the top element in the stack
    public E peek() {

        // if the stack is empty then just throw a meaningful exception
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack[top - 1];
    }

    // size of the stack
    public int size() {
        return top;
    }

    // check if the stack is empty or not
    public boolean isEmpty() {
        return top == 0;
    }

    // check if the stack is full or not
    public boolean isFull() {
        return top == stack.length;
    }

    // used internally for doubling the stack capacity
    private void ensureCapacity() {
        int newSize = stack.length * 2;
        stack = Arrays.copyOf(stack, newSize);
    }
}
