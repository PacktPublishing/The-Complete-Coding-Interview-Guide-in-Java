package coding.challenge;

public class Main {

    public static void main(String[] args) {        

        SinglyLinkedList sll1 = new SinglyLinkedList();      
        sll1.insertFirst(4);
        sll1.insertFirst(6);
        sll1.insertFirst(5);
        sll1.insertFirst(2);
        sll1.insertFirst(0);
        sll1.insertFirst(0);
        
        SinglyLinkedList sll2 = new SinglyLinkedList();      
        sll2.insertFirst(4);
        sll2.insertFirst(3);
        sll2.insertFirst(3);
        sll2.insertFirst(2);
        
        sll1.sum(sll2);
    }
}
