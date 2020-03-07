package coding.challenge;

import java.util.Stack;

public class MyQueueViaStack<E> {

    Stack<E> stackEnqueue, stackDequeue;

    public MyQueueViaStack() {
        stackEnqueue = new Stack<>();
        stackDequeue = new Stack<>();
    }

    public void enqueue(E value) {
        stackEnqueue.push(value);
    }

    public E dequeue() {
        shiftStacksContent();
        return stackDequeue.pop();
    }

    public E peek() {
        shiftStacksContent();
        return stackDequeue.peek();
    }

    public int size() {
        return stackEnqueue.size() + stackDequeue.size();
    }

    private void shiftStacksContent() {
        if (stackDequeue.isEmpty()) {
            while (!stackEnqueue.isEmpty()) {
                stackDequeue.push(stackEnqueue.pop());
            }
        }
    }
}
