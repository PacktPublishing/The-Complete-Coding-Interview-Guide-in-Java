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
        Node prevPair = null;

        // consider two nodes at a time and swap their links
        while (currentNode != null && currentNode.next != null) {

            Node node1 = currentNode;           // first node
            Node node2 = currentNode.next;      // second node                    
            Node node3 = currentNode.next.next; // third node            

            // swap the first node (node1) with the second node (node2)
            Node auxNode = node1;
            node1 = node2;
            node2 = auxNode;

            // repair the links broken by swapping
            node1.next = node2;
            node2.next = node3;

            // if we are at the first swap we set the head
            if (prevPair == null) {
                head = node1;
            } else {
                // we link the previous pair to this pair
                prevPair.next = node1;
            }

            // there are no more nodes, therefore set the tail
            if (currentNode.next == null) {
                tail = currentNode;
            }

            // prepare the prevNode of the current pair
            prevPair = node2;

            // advance to the next pair
            currentNode = node3;
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
