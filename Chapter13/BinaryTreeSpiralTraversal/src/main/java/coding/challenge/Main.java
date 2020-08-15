package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

    /* Output: 40 45 47 11 3 44 5 87 77 6 2 1 4 23 21 1 5 8 
               40 47 45 5 44 3 11 21 23 4 1 2 6 77 87 8 5 1 
              ----40----
             /          \
            47          45
          /    \      /    \  
         11     3    44     5
       /   \   / \  /  \   / \
      21   23 4   1 2  6  77  87
      /\   /  
     1  5 8
    */

        BinaryTree<Integer> bt = new BinaryTree<>();
        
        bt.insert(40);
        
        bt.insert(47);
        bt.insert(45);
        
        bt.insert(11);
        bt.insert(3);
        bt.insert(44);
        bt.insert(5);
        
        bt.insert(21);
        bt.insert(23);
        bt.insert(4);
        bt.insert(1);
        bt.insert(2);
        bt.insert(6);
        bt.insert(77);
        bt.insert(87);
        
        bt.insert(1);
        bt.insert(5);
        bt.insert(8);
          
        bt.spiralOrderTraversalRecursive();
        System.out.println();
        bt.spiralOrderTraversalTwoStacks();
        System.out.println();
        bt.spiralOrderTraversalDeque();
    }
}
