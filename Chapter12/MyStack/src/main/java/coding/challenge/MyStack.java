package coding.challenge;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;

public final class MyStack<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private int top;
    private E[] stack;

    // constructor to initialize the stack
    MyStack() {
        stack = (E[]) Array.newInstance(
                Object[].class.getComponentType(), DEFAULT_CAPACITY);

        top = 0; // the initial size is 0
    }

    // add an element e in the stack
    public void push(E e) {

        // if the stack is full, we double its capacity
        if (isFull()) {
            ensureCapacity();
        }

        stack[top++] = e;
    }

    // pop top element from the stack
    public E pop() {

        if (isEmpty()) {
            throw new EmptyStackException();
        }

        E e = stack[--top];
        stack[top] = null;

        return e;
    }

    // return but not remove the top element in the stack
    public E peek() {
        if (!isEmpty()) {
            return stack[top - 1];
        }

        throw new EmptyStackException();
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

    private void ensureCapacity() {
        int newSize = stack.length * 2;
        stack = Arrays.copyOf(stack, newSize);
    }
}
