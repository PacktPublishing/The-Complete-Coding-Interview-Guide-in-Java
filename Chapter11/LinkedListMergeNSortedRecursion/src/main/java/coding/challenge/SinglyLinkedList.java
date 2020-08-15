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

    public void insertFirst(int data) {

        Node newNode = new Node();

        newNode.data = data;
        newNode.next = head;
        head = newNode;
    }

    public void merge(SinglyLinkedList[] slls, int n) {

        if (slls == null) {
            throw new IllegalArgumentException("Cannot merge null linked lists");
        }

        head = mergeLists(slls, n);
    }

    private Node mergeLists(SinglyLinkedList linkedlists[], int n) {
        
        int last = n - 1;

        // repeat until only one list is left
        while (last != 0) {
            int p = 0;
            int q = last;
 
            // (p, q) forms a pair of linked lists
            while (p < q) {
                // merge list p with list q and store the merged list in list p
                linkedlists[p].head = merge(linkedlists[p].head, linkedlists[q].head);

                // go to the next pair
                p++;
                q--;

                // all pairs are merged, threfore update the last
                if (p >= q) {
                    last = q;
                }
            }
        }

        return linkedlists[0].head;
    }

    private Node merge(Node list1, Node list2) {

        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        Node resultNode;

        if (list1.data <= list2.data) {
            resultNode = list1;
            resultNode.next = merge(list1.next, list2);
        } else {
            resultNode = list2;
            resultNode.next = merge(list1, list2.next);
        }

        return resultNode;
    }

    public void print() {
        Node currentNode = head;
        while (currentNode != null) {

            System.out.print(currentNode);
            currentNode = currentNode.next;
        }

        System.out.println();
    }
}
