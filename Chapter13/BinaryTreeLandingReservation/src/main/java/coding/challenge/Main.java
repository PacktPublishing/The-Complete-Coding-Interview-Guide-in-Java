package coding.challenge;
 
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree<LocalTime> bst = new BinarySearchTree<>();

        bst.insert(LocalTime.of(10, 10), 3);
        bst.insert(LocalTime.of(10, 14), 3);
        bst.insert(LocalTime.of(9, 55), 2);
        bst.insert(LocalTime.of(10, 18), 1);
        bst.insert(LocalTime.of(9, 58), 5);        
        bst.insert(LocalTime.of(9, 47), 2);        
        bst.insert(LocalTime.of(9, 41), 2);        
        bst.insert(LocalTime.of(10, 22), 1);
        bst.insert(LocalTime.of(9, 50), 6); // cannot do reservation
        bst.insert(LocalTime.of(10, 4), 4);         
        
        System.out.println("\nThe landing schedule is:");
        bst.printInOrder();
    }
}
