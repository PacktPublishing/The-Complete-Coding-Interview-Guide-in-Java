package coding.challenge;
 
public class Main {

    public static void main(String[] args) {        

        SinglyLinkedList sll = new SinglyLinkedList();

        sll.insertFirst(11);
        sll.insertFirst(10);
        sll.insertFirst(9);
        sll.insertFirst(8);
        sll.insertFirst(8);
        sll.insertFirst(8);
        sll.insertFirst(7);
        sll.insertFirst(6);
        sll.insertFirst(5);
        sll.insertFirst(4);
        sll.insertFirst(-3);
        sll.insertFirst(2);
        sll.insertFirst(1);
        sll.insertFirst(11);
        sll.insertFirst(90);

        sll.print();    
        
        sll.rearrange(7);
        
        sll.print();
    }
    
}
