package coding.challenge;
 
import java.util.HashSet;
import java.util.Set;

public final class SinglyLinkedList {

    private final class Node {

        private int data;
        private Node next;

        @Override
        public String toString() {
            return " " + data + " ";
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void insertFirst(int data) {

        Node newNode = new Node();

        newNode.data = data;
        newNode.next = head;
        head = newNode;

        if (tail == null) {
            tail = newNode;
        }

        size++;
    }

    // O(n) solution (time and space)
    public void removeDuplicates1() {

        Set<Integer> dataSet = new HashSet<>();

        Node currentNode = head;
        Node prevNode = null;
        while (currentNode != null) {
            if (dataSet.contains(currentNode.data)) {
                prevNode.next = currentNode.next;

                if (currentNode == tail) {
                    tail = prevNode;
                }

                size--;
            } else {
                dataSet.add(currentNode.data);
                prevNode = currentNode;
            }

            currentNode = currentNode.next;
        }
    }

    // O(n^2) time, O(1) space
    public void removeDuplicates2() {

        Node currentNode = head;

        while (currentNode != null) {

            Node runnerNode = currentNode;

            while (runnerNode.next != null) {
                if (runnerNode.next.data == currentNode.data) {

                    if (runnerNode.next == tail) {
                        tail = runnerNode;
                    }

                    runnerNode.next = runnerNode.next.next;

                    size--;
                } else {
                    runnerNode = runnerNode.next;
                }
            }
            currentNode = currentNode.next;
        }
    }

    public void print() {

        System.out.println("\nHead (" + head + ") ----------> Last (" + tail + "):");

        Node currentNode = head;
        while (currentNode != null) {

            System.out.print(currentNode);
            currentNode = currentNode.next;
        }

        System.out.println();
    }

    public int size() {
        return size;
    }
}
