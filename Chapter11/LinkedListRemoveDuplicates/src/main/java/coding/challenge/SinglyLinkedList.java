package coding.challenge;

import java.util.HashSet;
import java.util.Set;

public final class SinglyLinkedList {

    private class Node {

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

    // insert a node at the start of linked list
    public void insertFirst(int data) {

        // create a new node
        Node newNode = new Node();

        // set the data of the new node
        newNode.data = data;

        // link the new node to the list as the first node
        // then newNode points to the current head (which can be null)
        newNode.next = head;

        // the newNode become the head
        head = newNode;

        // if this is the first node then it is the tail as well
        if (tail == null) {
            tail = newNode;
        }

        // set the new size
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
