package coding.challenge;
 
public class Main {

    public static void main(String[] args) {        

        SinglyLinkedList sll1 = new SinglyLinkedList();      
        sll1.insertFirst(2);
        sll1.insertFirst(1);
        sll1.insertFirst(4);
        sll1.insertFirst(9);
        sll1.insertFirst(8);
        sll1.insertFirst(3);
        sll1.insertFirst(7);
        
        SinglyLinkedList sll2 = new SinglyLinkedList();      
        sll2.insertFirst(4);
        sll2.insertFirst(8);
        sll2.insertFirst(9);
        sll2.insertFirst(7);
        
        sll1.sum(sll2);
    }
}
