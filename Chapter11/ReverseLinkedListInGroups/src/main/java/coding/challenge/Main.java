package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

       SinglyLinkedList sll = new SinglyLinkedList();              
       
       sll.insertFirst(0);       
       sll.insertFirst(9);       
       sll.insertFirst(2);       
       sll.insertFirst(8);       
       sll.insertFirst(1);
       sll.insertFirst(3);
       sll.insertFirst(4);
       sll.insertFirst(7);
              
       sll.print();
       
       sll.reverseInKGroups(3);
       
       sll.print();       
    }

}
