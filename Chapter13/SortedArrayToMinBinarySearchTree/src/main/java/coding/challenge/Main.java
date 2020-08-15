package coding.challenge;
 
public class Main {

    public static void main(String[] args) {
    
        Integer[] m = {-2, 3, 4, 6, 7, 8, 12, 23, 90};
        
        BinarySearchTree<Integer> bt = new BinarySearchTree<>();
        
        bt.minimalBst(m);
        
        System.out.println("Root: " + bt.root());
        System.out.println("Root Height: " + bt.height());
        System.out.println("Number of nodes: " + bt.size());
     
        System.out.println("\n\nTraversal LEVEL: ");
        bt.print(BinarySearchTree.TraversalOrder.LEVEL);
        
        System.out.println("\n\nTraversal IN-ORDER: ");
        bt.print(BinarySearchTree.TraversalOrder.IN);        
        
        System.out.println("\n\nTraversal PRE-ORDER: ");
        bt.print(BinarySearchTree.TraversalOrder.PRE);        
        
        System.out.println("\n\nTraversal POST-ORDER: ");
        bt.print(BinarySearchTree.TraversalOrder.POST);                
    }

}
