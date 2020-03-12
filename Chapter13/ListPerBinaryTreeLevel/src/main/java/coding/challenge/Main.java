package coding.challenge;

public class Main {

    public static void main(String[] args) {

    // [[40], [47, 45], [11, 13, 44, 88], [3, 1]]
    /*        
              --40--
            /        \
          -47-       -45-
         /    \     /    \
        11     13  44    88
       /  \   
      3    1 
    */

        BinaryTree<Integer> bt = new BinaryTree<>();
        
        bt.insert(40);
        bt.insert(47);
        bt.insert(45);
        bt.insert(11);
        bt.insert(13);
        bt.insert(44);
        bt.insert(88);
        bt.insert(3);
        bt.insert(1);        
          
        System.out.println(bt.fetchAllLevels());
    }
}
