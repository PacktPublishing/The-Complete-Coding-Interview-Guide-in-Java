package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

    /*                          
              40                40
            /    \            /    \
          47      45         45    47
         /  \    /            \   /  \
        11   3  44            44 3    11
    */

        BinaryTree<Integer> bt = new BinaryTree<>();
        
        bt.insert(40);
        bt.insert(47);
        bt.insert(45);
        bt.insert(11);
        bt.insert(3);
        bt.insert(44);
                      
        System.out.println("Given tree");
        System.out.println("----------");
        
        System.out.println("\nTraversal LEVEL: ");
        bt.print(BinaryTree.TraversalOrder.LEVEL);
         
        System.out.println("\n\nTraversal IN-ORDER: ");
        bt.print(BinaryTree.TraversalOrder.IN);        
        
        System.out.println("\n\nTraversal PRE-ORDER: ");
        bt.print(BinaryTree.TraversalOrder.PRE);        
        
        System.out.println("\n\nMirorred tree in a new tree");
        System.out.println("---------------------------");
        
        BinaryTree<Integer> mirroredBt = bt.mirrorTreeInTree();
        
        System.out.println("\nTraversal LEVEL (mirror in new tree): ");
        mirroredBt.print(BinaryTree.TraversalOrder.LEVEL);
        
        System.out.println("\n\nTraversal IN-ORDER (mirror in new tree): ");
        mirroredBt.print(BinaryTree.TraversalOrder.IN);                        
        
        System.out.println("\n\nTraversal PRE-ORDER (mirror in new tree): ");
        mirroredBt.print(BinaryTree.TraversalOrder.PRE);        
        
        System.out.println("\n\nMirorred tree in place");
        System.out.println("----------------------");
        
        bt.mirrorTreeInPlace();
        
        System.out.println("\nTraversal LEVEL (mirror in place): ");
        bt.print(BinaryTree.TraversalOrder.LEVEL);
        
        System.out.println("\n\nTraversal IN-ORDER (mirror in place): ");
        bt.print(BinaryTree.TraversalOrder.IN);        
        
        System.out.println("\n\nTraversal PRE-ORDER (mirror in place): ");
        bt.print(BinaryTree.TraversalOrder.PRE);        
    }
}
