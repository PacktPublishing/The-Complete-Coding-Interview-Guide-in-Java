package coding.challenge;
 
public final class DoublyLinkedList {

    private final class Node {

        private int data;
        private Node next;
        private Node prev;

        @Override
        public String toString() {
            return " " + data + " ";
        }
    }

    private Node head;

    public void insertFirst(int data) {

        Node newNode = new Node();

        newNode.data = data;
        newNode.next = head;

        if (head != null) {
            head.prev = newNode;
        }

        head = newNode;
    }

    public void reverse() {

        Node currentNode = head;
        Node prevNode = null;

        while (currentNode != null) {

            // swap next and prev pointers of the current node
            Node prev = currentNode.prev;
            currentNode.prev = currentNode.next;
            currentNode.next = prev;

            // update the previous node before moving to the next node
            prevNode = currentNode;

            // move to the next node in the doubly linked list            
            currentNode = currentNode.prev;
        }

        // update the head to point to the last node
        if (prevNode != null) {
            head = prevNode;
        }
    }

    public void print() {

        System.out.println("\nHead (" + head + ") ----------> Last:");

        Node currentNode = head;
        while (currentNode != null) {

            System.out.print(currentNode);
            currentNode = currentNode.next;
        }

        System.out.println();
    }
}
