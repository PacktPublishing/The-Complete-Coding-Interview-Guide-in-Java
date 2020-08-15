package coding.challenge;
 
public class Main {

    public static void main(String[] args) {        

        SinglyLinkedList sll = new SinglyLinkedList();

        int intersection = sll.intersection();
        
        System.out.println("\nIntersection node has the value (-1 means no intersection): " + intersection);
    }

}
