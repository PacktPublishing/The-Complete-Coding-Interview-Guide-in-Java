package coding.challenge;

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

    public void insertFirst(int data) {

        Node newNode = new Node();

        newNode.data = data;
        newNode.next = head;
        head = newNode;

        if (tail == null) {
            tail = newNode;
        }
    }

    // O(n) time and O(1) space
    public int nthToLastIterative(int n) {

        if (n <= 0) { // we could add n > size as well, but we consider the linked list size as unknown
            throw new IllegalArgumentException("The given n index is out of bounds");
        }

        // both runners are set to the start
        Node firstRunner = head;
        Node secondRunner = head;

        // runner1 goes in the nth position
        for (int i = 0; i < n; i++) {
            if (firstRunner == null) {
                throw new IllegalArgumentException("The given n index is out of bounds");
            }
            firstRunner = firstRunner.next;
        }

        // runner2 run as long as runner1 is not null
        // basically, when runner1 cannot run further (is null), 
        // runner2 will be placed on the nth to last node
        while (firstRunner != null) {
            firstRunner = firstRunner.next;
            secondRunner = secondRunner.next;
        }

        return secondRunner.data;
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
}
