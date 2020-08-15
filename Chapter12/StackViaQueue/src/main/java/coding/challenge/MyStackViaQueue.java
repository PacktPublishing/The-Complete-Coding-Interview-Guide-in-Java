package coding.challenge;
 
import java.util.ArrayDeque;
import java.util.EmptyStackException;
import java.util.Queue;

public class MyStackViaQueue<E> {

    private final Queue<E> queue1;
    private final Queue<E> queue2;
    private E peek;
    private int size;

    public MyStackViaQueue() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }

    public void push(E e) {

        if (!queue1.isEmpty()) {
            if (peek != null) {
                queue1.add(peek);
            }
            queue1.add(e);
        } else {
            if (peek != null) {
                queue2.add(peek);
            }
            queue2.add(e);
        }

        size++;
        peek = null;
    }

    public E pop() {

        if (size() == 0) {
            throw new EmptyStackException();
        }

        if (peek != null) {
            E e = peek;
            peek = null;

            size--;

            return e;
        }

        E e;
        if (!queue1.isEmpty()) {
            e = switchQueue(queue1, queue2);
        } else {
            e = switchQueue(queue2, queue1);
        }

        size--;

        return e;
    }

    public E peek() {

        if (size() == 0) {
            throw new EmptyStackException();
        }

        if (peek == null) {
            if (!queue1.isEmpty()) {
                peek = switchQueue(queue1, queue2);
            } else {
                peek = switchQueue(queue2, queue1);
            }
        }

        return peek;
    }

    public int size() {
        return size;
    }

    private E switchQueue(Queue from, Queue to) {

        while (from.size() > 1) {
            to.add(from.poll());
        }

        return (E) from.poll();
    }
}
