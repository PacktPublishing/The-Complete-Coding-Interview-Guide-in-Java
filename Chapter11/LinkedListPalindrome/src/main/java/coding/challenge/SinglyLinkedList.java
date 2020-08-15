package coding.challenge;
 
import java.util.Stack;

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

    public boolean isPalindrome() {

        Node fastRunner = head;
        Node slowRunner = head;

        Stack<Integer> firstHalf = new Stack<>();

        // the first half of the linked list is added into the stack
        while (fastRunner != null && fastRunner.next != null) {

            firstHalf.push(slowRunner.data);

            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
        }

        // for odd number of elements we need to skip the middle node
        if (fastRunner != null) {
            slowRunner = slowRunner.next;
        }

        // pop from the stack and compare with the node by node of the second half of the linked list
        while (slowRunner != null) {
            int top = firstHalf.pop();

            // if we find a mismatch then the linked list is not a palindrome
            if (top != slowRunner.data) {
                return false;
            }

            slowRunner = slowRunner.next;
        }

        return true;
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
