package coding.challenge;

public class Main {

    public static void main(String[] args) {

       SinglyLinkedList sll = new SinglyLinkedList();              
       
       sll.insertFirst(2);       
       sll.insertLast(12);
       sll.insertAt(1, 23);
       sll.insertAt(0, -1);
       sll.insertAt(2, -5);
       sll.insertFirst(9);
       sll.insertLast(44);
       sll.insertAt(sll.size(), -7);       
       
       sll.print();
       
       sll.delete(9);
       sll.delete(44);
       
       sll.print();
       
       sll.deleteByIndex(0);
       sll.deleteByIndex(sll.size() - 1);
       
       sll.print();
       
       sll.deleteByIndex(sll.size());
       sll.insertLast(5);  
       sll.insertFirst(10);
       sll.insertAt(2, -8);
       
       sll.print();
              
       sll.deleteByIndex(0);
       sll.deleteByIndex(0);
       sll.deleteByIndex(0);
       
       sll.print();
       
       sll.deleteByIndex(sll.size() - 1);
       sll.deleteByIndex(sll.size() - 1);
       sll.deleteByIndex(sll.size() - 1);
       
       sll.print();
       
       sll.delete(-5);
       
       sll.print();
       
       System.out.println("\nSize: " + sll.size());
       
    }

}
