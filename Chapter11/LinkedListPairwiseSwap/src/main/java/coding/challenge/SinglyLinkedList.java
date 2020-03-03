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

    public void swap() {

        if (head == null || head.next == null) {
            return;
        }

        Node currentNode = head;
        Node prevNode = null;

        // consider two nodes at a time and swap their links
        while (currentNode != null && currentNode.next != null) {

            Node auxNode = currentNode.next;
            currentNode.next = auxNode.next;
            auxNode.next = currentNode;

            if (prevNode == null) {
                head = auxNode;
            } else {
                prevNode.next = auxNode;
            }

            if (currentNode.next == null) {
                tail = currentNode;
            }

            prevNode = currentNode;
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
}
