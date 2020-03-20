package coding.challenge;

public class Main {

    public static void main(String[] args) {

        AVLTree bst = new AVLTree();
        
        bst.insert(11);
        bst.insert(21);
        bst.insert(3);
        bst.insert(34);
        bst.insert(5);
        bst.insert(64);
        bst.insert(7);
        bst.insert(58);
      
        bst.print();
        
        System.out.println("\nDelete 5 and 11: \n");
        bst.delete(5);
        bst.delete(11);
        
        bst.print();
    }
}
