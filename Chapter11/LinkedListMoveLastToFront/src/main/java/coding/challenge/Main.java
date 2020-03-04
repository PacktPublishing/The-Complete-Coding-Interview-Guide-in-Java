package coding.challenge;

public class Main {

    public static void main(String[] args) {

        SinglyLinkedList sll = new SinglyLinkedList();

        sll.insertFirst(7);
        sll.insertFirst(10);
        sll.insertFirst(3);
        sll.insertFirst(9);
        sll.insertFirst(1);

        System.out.println("\nInitial:");
        sll.print();

        sll.moveLastToFront1();
        // sll.moveLastToFront2();

        System.out.println("\nResult:");
        sll.print();
    }

}
