package coding.challenge;
 
import java.util.Random;

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

    // loop example, the loop start at node with value 3
    // 0 -> 1 -> 2 -> 3 -> 4 -> 5
    //               /           \
    //              10            6
    //               \           /
    //                9 <- 8 <- 7        
    // this is just a helper method for generating a random loop
    public void generateLoop() {

        if (size < 2) {
            throw new RuntimeException("The linked list size must be at least 2");
        }

        Node currentNode = head;
        int rnd = new Random().nextInt(size - 1);

        for (int i = 0; i < rnd; i++) {
            currentNode = currentNode.next;
        }

        System.out.println("The generated loop starts at the node with value: " + currentNode);

        // create a loop        
        tail.next = currentNode;
    }

    public void findLoopStartNode() {

        Node slowRunner = head;
        Node fastRunner = head;

        // fastRunner meets slowRunner
        while (fastRunner != null && fastRunner.next != null) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
            if (slowRunner == fastRunner) { // they met
                System.out.println("\nThe meet point is at the node with value: " + slowRunner);
                break;
            }
        }

        // if no meeting point was found then there is no loop
        if (fastRunner == null || fastRunner.next == null) {
            return;
        }

        // the slowRunner moves to the head of the linked list
        // the fastRunner remains at the meeting point
        // they move simultaneously node-by-node and they should meet at the loop start
        slowRunner = head;
        while (slowRunner != fastRunner) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next;
        }

        // both pointers points to the start of the loop
        System.out.println("\nLoop start detected at the node with value: " + fastRunner);
    }

    public void print() {

        System.out.println("\nHead (" + head + ") ----------> Last (" + tail + "):");

        Node currentNode = head;
        for (int i = 0; i < size; i++) {

            System.out.print(currentNode);
            currentNode = currentNode.next;
        }

        System.out.println();
    }
}
