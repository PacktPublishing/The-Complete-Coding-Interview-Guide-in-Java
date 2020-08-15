package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

       SinglyLinkedList sll = new SinglyLinkedList();              
       
       sll.insertFirst(5);
       sll.insertFirst(2);             
       sll.insertFirst(12);
       sll.insertFirst(2);
       sll.insertFirst(12);
       sll.insertFirst(5);
       sll.insertFirst(5);
       sll.insertFirst(12);
       sll.insertFirst(1);
       sll.insertFirst(4);
       sll.insertFirst(12);
       
       System.out.println("\nLinked list before removing duplicates:");
       sll.print();
       sll.removeDuplicates1();
       // sll.removeDuplicates2();
       System.out.println("\nLinked list after removing duplicates:");
       sll.print();
     
       System.out.println("\nSize: " + sll.size());
       
    }

}
