package coding.challenge;
 
public class Main {

    public static void main(String[] args) {        
 
        SinglyLinkedList sll1 = new SinglyLinkedList();

        sll1.insertFirst(10);
        sll1.insertFirst(8);
        sll1.insertFirst(7);        
        sll1.insertFirst(4);
        
        SinglyLinkedList sll2 = new SinglyLinkedList();
        
        sll2.insertFirst(11);
        sll2.insertFirst(9);        
        sll2.insertFirst(5);
        
        SinglyLinkedList sll3 = new SinglyLinkedList();
        
        sll3.insertFirst(15);
        sll3.insertFirst(14);
        sll3.insertFirst(3);        
        sll3.insertFirst(1);
        
        sll1.print();
        sll2.print();
        sll3.print();
        
        sll1.merge(new SinglyLinkedList[]{sll1, sll2, sll3}, 3);
        
        System.out.println("\nAfter merging:");

        sll1.print();                       
    }

}
