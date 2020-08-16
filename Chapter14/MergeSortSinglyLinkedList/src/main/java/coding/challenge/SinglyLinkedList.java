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
    private int size;

    public boolean isEmpty() {
        return (head == null);
    }

    public void insertFirst(int data) {

        Node newNode = new Node();

        newNode.data = data;
        newNode.next = head;
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

        // split head into two sublists
        Node[] headsOfSublists = divide(head);

        Node head1 = headsOfSublists[0];  // head of the first sublist
        Node head2 = headsOfSublists[1];  // head of the second sublist

        // recursively sort the sublists
        head1 = sort(head1);
        head2 = sort(head2);

        // merge the two sorted lists together
        return merge(head1, head2);
    }

    // Divide the given linked list in two equal sub-lists.
    // If the length of the given linked list is odd, 
    // the extra node will go in the first sublist
    private Node[] divide(Node sourceNode) {

        // length is less than than 2
        if (sourceNode == null || sourceNode.next == null) {
            return new Node[]{sourceNode, null};
        }

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

        // 'secondRunner' is just before the middle point 
        // in the list, so split it in two at that point
        Node[] headsOfSublists = new Node[]{sourceNode, slowRunner.next};
        slowRunner.next = null;

        return headsOfSublists;
    }

    // takes two lists sorted in increasing order, and merge 
    // their nodes together (which is returned)
    private Node merge(Node head1, Node head2) {

        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }

        Node merged;

        // pick either 'head1' or 'head2'
        if (head1.data <= head2.data) {
            merged = head1;
            merged.next = merge(head1.next, head2);
        } else {
            merged = head2;
            merged.next = merge(head1, head2.next);
        }

        return merged;
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
