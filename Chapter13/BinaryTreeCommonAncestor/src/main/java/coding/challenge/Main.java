package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

    /*        
              40
            /    \
          47      45
         /  \    /  \
        11   3  44   4
       /  \
      12  55  
    */

        BinaryTree<Integer> bt = new BinaryTree<>();
        
        bt.insert(40);
        bt.insert(47);
        bt.insert(45);
        bt.insert(11);
        bt.insert(3);
        bt.insert(44);
        bt.insert(4);
        bt.insert(12);
        bt.insert(55);
          
        int ancestor = bt.commonAncestor(12, 3);
        
        System.out.println("Common ancestor: " + ancestor);
    }
}
