package coding.challenge;

public class Main {

    public static void main(String[] args) {

       DoublyLinkedList dll = new DoublyLinkedList();
                    
       dll.insertFirst(2);       
       dll.insertLast(12);
       dll.insertAt(1, 23);
       dll.insertAt(0, -1);
       dll.insertAt(2, -5);
       dll.insertFirst(9);
       dll.insertLast(44);
       dll.insertAt(dll.size(), -7);       
       
       dll.printHeadToLast();
       dll.printLastToHead();
       
       dll.delete(9);
       dll.delete(44);
       
       dll.printHeadToLast();
       dll.printLastToHead();
              
       dll.deleteByIndex(0);
       dll.deleteByIndex(dll.size() - 1);
       
       dll.printHeadToLast();
       dll.printLastToHead();
              
       dll.deleteByIndex(dll.size());
       dll.insertLast(5);  
       dll.insertFirst(10);
       dll.insertAt(2, -8);
       
       dll.printHeadToLast();
       dll.printLastToHead();       
              
       dll.deleteByIndex(0);
       dll.deleteByIndex(0);
       dll.deleteByIndex(0);
       
       dll.printHeadToLast();
       dll.printLastToHead();
              
       dll.deleteByIndex(dll.size() - 1);
       dll.deleteByIndex(dll.size() - 1);
       dll.deleteByIndex(dll.size() - 1);
       
       dll.printHeadToLast();
       dll.printLastToHead();
              
       dll.delete(-5);
       
       dll.printHeadToLast();
       dll.printLastToHead();      
       
       System.out.println("\nSize: " + dll.size());
    }

}
