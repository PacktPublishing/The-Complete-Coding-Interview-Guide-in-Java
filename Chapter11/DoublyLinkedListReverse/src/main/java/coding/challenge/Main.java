package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertFirst(122);
        dll.insertFirst(4);
        dll.insertFirst(7);
        dll.insertFirst(-2);
        dll.insertFirst(2);
        dll.insertFirst(21);
        dll.insertFirst(22);

        System.out.println("\nInitial:");
        dll.print();

        dll.reverse();

        System.out.println("\nReversed:");
        dll.print();
    }

}
