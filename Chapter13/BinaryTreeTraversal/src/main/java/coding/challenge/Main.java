package coding.challenge;

public class Main {

    public static void main(String[] args) {

    /*        
              40
            /    \
          47      45
         /  \    /  
        11   3  44         
    */

        BinaryTree<Integer> bt = new BinaryTree<>();
        
        bt.insert(40);
        bt.insert(47);
        bt.insert(45);
        bt.insert(11);
        bt.insert(3);
        bt.insert(44);
          
        System.out.println("Root: " + bt.root() + " Size: " + bt.size());
      
        
        System.out.println("\n\nTraversal LEVEL: ");
        bt.print(BinaryTree.TraversalOrder.LEVEL);
        
        System.out.println("\n\nTraversal IN-ORDER: ");
        bt.print(BinaryTree.TraversalOrder.IN);        
        
        System.out.println("\n\nTraversal PRE-ORDER: ");
        bt.print(BinaryTree.TraversalOrder.PRE);        
        
        System.out.println("\n\nTraversal POST-ORDER: ");
        bt.print(BinaryTree.TraversalOrder.POST);        
        /*
        System.out.println("\n\nDeleting 33, 45, 67 and 5\n\n");
        bt.delete(33);        
        bt.delete(45);
        bt.delete(67);
        bt.delete(5);
        
        System.out.println("Root: " + bt.root());
        System.out.println("Root Height: " + bt.height());
        System.out.println("Min: " + bt.min());
        System.out.println("Max: " + bt.max());
     
        System.out.println("\n\nTraversal LEVEL: ");
        bt.print(BinaryTree.TraversalOrder.LEVEL);
        
        System.out.println("\n\nTraversal IN-ORDER: ");
        bt.print(BinaryTree.TraversalOrder.IN);        
        
        System.out.println("\n\nTraversal PRE-ORDER: ");
        bt.print(BinaryTree.TraversalOrder.PRE);        
        
        System.out.println("\n\nTraversal POST-ORDER: ");
        bt.print(BinaryTree.TraversalOrder.POST);                
*/
    }

}
