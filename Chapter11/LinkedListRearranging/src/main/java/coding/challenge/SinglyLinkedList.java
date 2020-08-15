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

    public void rearrange(int n) {

        Node currentNode = head;
        head = currentNode;
        tail = currentNode;

        while (currentNode != null) {
            
            Node nextNode = currentNode.next;
            
            if (currentNode.data < n) {
                // insert node at the head
                currentNode.next = head;
                head = currentNode;
            } else {
                // insert node at the tail
                tail.next = currentNode;
                tail = currentNode;
            }
            
            currentNode = nextNode;
        }
        
        tail.next = null;
    }

    public void print() {

        System.out.println("Head (" + head + ") ----------> Last (" + tail + "):");

        Node currentNode = head;
        while (currentNode != null) {

            System.out.print(currentNode);
            currentNode = currentNode.next;
        }

        System.out.println();
        System.out.println();
    }

}
