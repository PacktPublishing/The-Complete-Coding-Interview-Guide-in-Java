package coding.challenge;

public class Main {

    public static void main(String[] args) {        

        SinglyLinkedList sll = new SinglyLinkedList();

        sll.insertFirst(4, 5);
        sll.insertFirst(4, 4);
        sll.insertFirst(4, 3);               
        sll.insertFirst(4, 2);
        sll.insertFirst(3, 2);
        sll.insertFirst(2, 2);
        sll.insertFirst(1, 2);
        sll.insertFirst(0, 2);
        sll.insertFirst(0, 1);
        sll.insertFirst(0, 0);       
        
        System.out.println("\nInitial");
        sll.print();

        sll.removeRedundantPath();
        System.out.println("\nAfter");
        sll.print();
        
    }

}
