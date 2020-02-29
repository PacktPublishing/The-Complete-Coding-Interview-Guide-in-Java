package coding.challenge;

public class Main {

    public static void main(String[] args) {

        int n = 2;

        SinglyLinkedList sll = new SinglyLinkedList();

        sll.insertFirst(11);
        sll.insertFirst(10);
        sll.insertFirst(9);
        sll.insertFirst(8);
        sll.insertFirst(7);
        sll.insertFirst(6);
        sll.insertFirst(5);
        sll.insertFirst(4);
        sll.insertFirst(3);
        sll.insertFirst(2);
        sll.insertFirst(1);

        sll.print();

        int result = sll.nthToLast(1);

        System.out.println("\nThe " + n + "th to last node has the value: " + result);

    }

}
