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
        
        bt.insert(40);
        bt.insert(30);
        bt.insert(45);
        bt.insert(15);
        bt.insert(33);
        bt.insert(42);
        bt.insert(56);
        bt.insert(5);
        bt.insert(17);
        bt.insert(41);
        bt.insert(67);             

        bt.kthLargest(3);
    }
}


