package coding.challenge;

public class Main {

    public static void main(String[] args) {

    /*        
              40
            /    \
          30      45
         /  \    /  \
        15  33  42  56
       / \      /     \    
      5  17    41      67
        
    */

        BinarySearchTree<Integer> bt = new BinarySearchTree<>();
        
        bt.add(40);
        bt.add(30);
        bt.add(45);
        bt.add(15);
        bt.add(33);
        bt.add(42);
        bt.add(56);
        bt.add(5);
        bt.add(17);
        bt.add(41);
        bt.add(67);             
                  
        System.out.println("Root: " + bt.root());
        System.out.println("Root Height: " + bt.height());
        System.out.println("Min: " + bt.min());
        System.out.println("Max: " + bt.max());
        
        System.out.println("\n\nTraversal LEVEL: ");
        bt.print(BinarySearchTree.TraversalOrder.LEVEL);
        
        System.out.println("\n\nTraversal IN-ORDER: ");
        bt.print(BinarySearchTree.TraversalOrder.IN);        
        
        System.out.println("\n\nTraversal PRE-ORDER: ");
        bt.print(BinarySearchTree.TraversalOrder.PRE);        
        
        System.out.println("\n\nTraversal POST-ORDER: ");
        bt.print(BinarySearchTree.TraversalOrder.POST);        
        
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
        bt.print(BinarySearchTree.TraversalOrder.LEVEL);
        
        System.out.println("\n\nTraversal IN-ORDER: ");
        bt.print(BinarySearchTree.TraversalOrder.IN);        
        
        System.out.println("\n\nTraversal PRE-ORDER: ");
        bt.print(BinarySearchTree.TraversalOrder.PRE);        
        
        System.out.println("\n\nTraversal POST-ORDER: ");
        bt.print(BinarySearchTree.TraversalOrder.POST);                
    }

}
