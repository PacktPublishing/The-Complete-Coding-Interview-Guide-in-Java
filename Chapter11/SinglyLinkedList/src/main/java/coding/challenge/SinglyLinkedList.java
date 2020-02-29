package coding.challenge;

public final class SinglyLinkedList {

    // this is a single node of a singly linked list
    private final class Node {

        private int data;  // the information        
        private Node next; // pointer to the next node

        @Override
        public String toString() {
            return " " + data + " ";
        }
    }

    private Node head; // left-hand head of the linked list
    private Node tail; // right-hand head of the linked list
    private int size;  // size of the linked list (number of nodes)

    // if head is null then the linked list is empty
    public boolean isEmpty() {
        return (head == null);
    }

    // insert a node at the start of linked list
    public void insertFirst(int data) {

        // create a new node
        Node newNode = new Node();

        // set the data of the new node
        newNode.data = data;

        // link the new node to the list as the first node
        // newNode points to the current head (which can be null if the linked list is empty)
        newNode.next = head;

        // the newNode become the head
        head = newNode;

        // if this is the first node then it is the tail as well
        if (tail == null) {
            tail = newNode;
        }

        // set the new size
        size++;
    }

    // insert a node at the end of linked list
    public void insertLast(int data) {

        // create new node
        Node newNode = new Node();

        // set the data of the new node
        newNode.data = data;

        // link the new node to the list as the last node  
        // the current tail points to the new tail (newNode)
        if (tail != null) {
            tail.next = newNode;
        }

        // newNode becomes the tail
        tail = newNode;

        // if this is the first node then it is the head as well
        if (head == null) {
            head = newNode;
        }

        // set the new size
        size++;
    }

    // insert at a certain index
    public void insertAt(int index, int data) {

        // store head node 
        Node currentNode = head;
        
        // store the previous node to the current node
        Node prevNode = null;

        // if index is 0 then head node itself is to be inserted 
        if (index == 0 && currentNode != null) {
            insertFirst(data);
            return;
        }

        // if index = size then last node (the tail) itself is to be inserted         
        if (index == size && currentNode != null) {
            insertLast(data);
            return;
        }

        // index cannot be larger than size
        if (index > size) {
            throw new RuntimeException("Index is larger than size!");
        }

        // if the index > 0 and index <= size
        int pointer = 0;
        while (currentNode != null) {

            if (pointer == index) {
                // create a new node
                Node newNode = new Node();

                // set the data of the new node
                newNode.data = data;

                // link the new node to the list (prev -> newNode -> currentNode)
                prevNode.next = newNode;
                newNode.next = currentNode;

                // set the new size
                size++;

                return;
            } else {
                // continue searching to next node 
                prevNode = currentNode;
                currentNode = currentNode.next;

                pointer++;
            }
        }
    }

    // delete a node by data
    public boolean delete(int data) {

        // store head node 
        Node currentNode = head;

        // store the previous node to the current node
        Node prevNode = null;

        // check if data belongs to the head
        if (currentNode != null && currentNode.data == data) {
            head = currentNode.next;

            // if the head is null then the tail is null as well
            if (head == null) {
                tail = null;
            }

            // set the new size
            size--;

            return true;
        }

        // check if the data is somewhere other than at head 
        // keep track of the previous node as it is needed to change currentNode.next 
        while (currentNode != null && currentNode.data != data) {

            // go to the next node
            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        // if the data was present, it should be at currentNode         
        if (currentNode != null) {

            // unlink currentNode from linked list 
            prevNode.next = currentNode.next;

            // prev becomes the tail
            if (prevNode.next == null) {
                tail = prevNode;
            }

            // set the new size
            size--;

            return true;
        }

        // we cannot find the given data
        return false;
    }

    // delete node by index (position)
    public boolean deleteByIndex(int index) {

        // store head node 
        Node currentNode = head;

        // store the previous node to the current one
        Node prevNode = null;

        // if index is 0 then head node itself is to be deleted 
        if (index == 0 && currentNode != null) {
            head = currentNode.next;

            // if the head is null then the tail is null as well
            if (head == null) {
                tail = null;
            }

            // set the new size
            size--;

            return true;
        }

        // if index > 0 
        int pointer = 0;
        while (currentNode != null) {

            if (pointer == index) {
                // unlink currentNode from linked list 
                prevNode.next = currentNode.next;

                // prev becomes null
                if (prevNode.next == null) {
                    tail = prevNode;
                }

                // set the new size
                size--;

                return true;
            } else {
                // continue searching to next node 
                prevNode = currentNode;
                currentNode = currentNode.next;

                pointer++;
            }
        }

        // we cannot find the given index
        return false;
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

    public int size() {
        return size;
    }
}
