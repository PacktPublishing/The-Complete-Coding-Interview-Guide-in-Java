package coding.challenge;

public class Main {

    public static void main(String[] args) {

       DoublyLinkedList dll = new DoublyLinkedList();
                    
       dll.insertFirst(28);
       dll.insertAt(0, -1);
       dll.insertFirst(27);
       dll.insertAt(2, -2);   
       dll.delete(28);
       dll.delete(27);
       dll.delete(-2);
       dll.delete(-1);
      // dll.insertAt(0, 23);
      // dll.insertFirst(2);
      // boolean b2=dll.delete(27);
       dll.printHeadToLast();
      // boolean b1=dll.deleteByIndex(-1);
       
       dll.printLastToHead();
       //System.out.println("x="+b1);
       
      // System.out.println("\nSize: " + dll.size());
       
    }

}
