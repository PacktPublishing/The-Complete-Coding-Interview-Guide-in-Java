package coding.challenge;

public class Main {

    public static void main(String[] args) {

    /*                        
              40(2)           D          40(1)
            /      \          E         /     \
          30(2)    45(4)      L       30(2)   45(2) 
         /    \      \        E       /
       17(2) 33(1)   56(1)    T     17(1)   
                              E
    */
        BinarySearchTree<Integer> bt = new BinarySearchTree<>();

        bt.insert(40);
        bt.insert(30);
        bt.insert(45);
        bt.insert(30);
        bt.insert(33);
        bt.insert(45);
        bt.insert(56);
        bt.insert(45);
        bt.insert(17);
        bt.insert(45);
        bt.insert(17);
        bt.insert(40);

        System.out.println("\n\nTraversal LEVEL: ");
        bt.print(BinarySearchTree.TraversalOrder.LEVEL);

        System.out.println("\n\nTraversal IN-ORDER: ");
        bt.print(BinarySearchTree.TraversalOrder.IN);

        System.out.println("\n\nTraversal PRE-ORDER: ");
        bt.print(BinarySearchTree.TraversalOrder.PRE);

        System.out.println("\n\nTraversal POST-ORDER: ");
        bt.print(BinarySearchTree.TraversalOrder.POST);

        System.out.println("\n\n\n\nDeleting... \n\n");
        bt.delete(33);
        bt.delete(45);
        bt.delete(45);
        bt.delete(40);
        bt.delete(17);
        bt.delete(56);

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
