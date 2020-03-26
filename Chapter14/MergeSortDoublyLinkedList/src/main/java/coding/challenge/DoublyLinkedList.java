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
    private int size;

    public boolean isEmpty() {
        return (head == null);
    }

    public void insertFirst(int data) {

        Node newNode = new Node();

        newNode.data = data;
        newNode.next = head;

        if (head != null) {
            head.prev = newNode;
        }

        head = newNode;

        size++;
    }

    // sort the given linked list via the Merge sort algorithm
    public void sort() {

        head = sort(head);
    }

    private Node sort(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        // split head into 'head1' and 'head2' sublists
        Node head1 = head;
        Node head2;

        Node headResult = divide(head);
        head2 = headResult.next;
        headResult.next = null;

        // recursively sort the sub-lists
        head1 = sort(head1);
        head2 = sort(head2);

        // merge the two sorted lists together
        head = merge(head1, head2);

        return head;
    }

    // Divide the given linked list in two equal sub-lists.
    // If the length of the given linked list is odd, 
    // the extra node will go in the first sublist
    private Node divide(Node sourceNode) {

        Node fastRunner = sourceNode.next;  // this is the fast runner
        Node slowRunner = sourceNode;       // this is the slow runner 

        // advance 'firstRunner' two nodes, 
        // and advance 'secondRunner' one node
        while (fastRunner != null) {
            fastRunner = fastRunner.next;
            if (fastRunner != null) {
                slowRunner = slowRunner.next;
                fastRunner = fastRunner.next;
            }
        }

        return slowRunner;
    }

    // takes two lists sorted in increasing order, and merge 
    // their nodes together (which is returned)
    private Node merge(Node head1, Node head2) {

        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        // pick either 'head1' or 'head2'
        if (head1.data <= head2.data) {
            head1.next = merge(head1.next, head2);
            head1.next.prev = head1;
            head1.prev = null;

            return head1;
        } else {
            head2.next = merge(head1, head2.next);
            head2.next.prev = head2;
            head2.prev = null;

            return head2;
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

    public int size() {
        return size;
    }
}
