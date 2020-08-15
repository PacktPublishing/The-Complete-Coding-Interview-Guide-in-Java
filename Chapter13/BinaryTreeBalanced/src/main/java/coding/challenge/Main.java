package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

    /*  not balanced at root      
              40
            /    \
           30     49
          /  \   /  \  
         20  35 45   52
            /  \
           34  37
              /
             36
    */

        BinaryTree<Integer> bt = new BinaryTree<>();
        
        bt.insert(40);
        bt.insert(30);
        bt.insert(49);
        bt.insert(20);
        bt.insert(35);
        bt.insert(45);
        bt.insert(52);
        bt.insert(34);
        bt.insert(37);
        bt.insert(36); // if you comment this line the tree is balanced
                  
        System.out.println("Balanced (approach 1)? " + bt.isBalanced1());              
        System.out.println("Balanced (approach 2)? " + bt.isBalanced2());              
    }
}
