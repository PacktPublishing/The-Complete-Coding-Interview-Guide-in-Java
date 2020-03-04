package coding.challenge;

public class Main {

    public static void main(String[] args) {        

        SinglyLinkedList sll = new SinglyLinkedList();

        sll.insertFirst(7, 15);
        sll.insertFirst(7, 14);
        sll.insertFirst(7, 13);               
        sll.insertFirst(5, 8);
        sll.insertFirst(4, 8);
        sll.insertFirst(3, 8);
        sll.insertFirst(2, 8);
        sll.insertFirst(2, 7);
        sll.insertFirst(2, 6);
        sll.insertFirst(2, 5);
        sll.insertFirst(2, 4);
        
        System.out.println("\nInitial");
        sll.print();

        sll.removeRedundantPath();
        System.out.println("\nAfter");
        sll.print();
        
    }

}
