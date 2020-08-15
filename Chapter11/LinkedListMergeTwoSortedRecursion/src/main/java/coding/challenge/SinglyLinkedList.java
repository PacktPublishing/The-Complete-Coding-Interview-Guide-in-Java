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

    public void merge(SinglyLinkedList sll) {
        
        if(sll == null) {
            throw new IllegalArgumentException("Cannot merge null linked list");
        }

        head = merge(head, sll.head);
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
