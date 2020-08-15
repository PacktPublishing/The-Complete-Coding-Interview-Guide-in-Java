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

    private final class PairNode {

        private final Node head;
        private final Node tail;

        public PairNode(Node head, Node tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    private Node head;
    private Node tail;

    public int intersection() {

        // this is not part of solution
        // we call it to generate two random-size linked list with an intersection node        
        PairNode pair = generateTwoLinkedListWithInterection();

        Node currentNode1 = pair.head; // this is the head of first list
        Node currentNode2 = pair.tail; // this is the head of the second list

        // we compute the size of both linked lists
        int s1 = linkedListSize(currentNode1);
        int s2 = linkedListSize(currentNode2);

        // the first linked list is longer than the second one
        if (s1 > s2) {
            for (int i = 0; i < (s1 - s2); i++) {
                currentNode1 = currentNode1.next;
            }
        } else {
            // the second linked list is longer than the first one
            for (int i = 0; i < (s2 - s1); i++) {
                currentNode2 = currentNode2.next;
            }
        }

        // we iterate both lists until the end or the intersection node
        while (currentNode1 != null && currentNode2 != null) {

            // we compare references not values!
            if (currentNode1 == currentNode2) {
                return currentNode1.data;
            }

            currentNode1 = currentNode1.next;
            currentNode2 = currentNode2.next;
        }

        return -1;
    }

    private PairNode generateTwoLinkedListWithInterection() {

        // we choose a random size for the lists between 1 and 10 nodes
        int size1 = new Random().nextInt(10) + 1;
        int size2 = new Random().nextInt(10) + 1;
        int size3 = new Random().nextInt(10) + 1;

        PairNode firstList = generateLinkedList(size1);
        PairNode secondList = generateLinkedList(size2);

        PairNode commonList = generateLinkedList(size3);

        // set a dummy value to the intersection node 
        commonList.head.data = 9999;

        // create intersection
        firstList.tail.next = commonList.head;
        secondList.tail.next = commonList.head;

        System.out.println("\nFirst linked list size: " + (size1 + size3));
        print(firstList.head, commonList.tail);

        System.out.println("\nSecond linked list size: " + (size2 + size3));
        print(secondList.head, commonList.tail);

        return new PairNode(firstList.head, secondList.head);
    }

    private PairNode generateLinkedList(int size) {

        head = null;
        tail = null;

        for (int i = 1; i <= size; i++) {

            Node newNode = new Node();

            newNode.data = i;
            newNode.next = head;
            head = newNode;

            if (tail == null) {
                tail = newNode;
            }
        }

        return new PairNode(head, tail);
    }

    private int linkedListSize(Node head) {
        Node currentNode = head;
        int count = 0;

        while (currentNode != null) {
            count++;
            currentNode = currentNode.next;
        }

        return count;
    }

    private void print(Node head, Node tail) {

        System.out.println("\nHead (" + head + ") ----------> Last (" + tail + "):");

        Node currentNode = head;
        while (currentNode != null) {

            System.out.print(currentNode);
            currentNode = currentNode.next;
        }

        System.out.println();
    }
}
