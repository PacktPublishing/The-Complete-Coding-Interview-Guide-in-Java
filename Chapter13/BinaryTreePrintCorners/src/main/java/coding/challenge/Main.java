package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

    /*        
             --40--
            /      \
           47       45
         /    \    /  \
        11     3  44   23
       /  \   / 
      2    4 1   
    */

        BinaryTree<Integer> bt = new BinaryTree<>();
        
        bt.insert(40);
        bt.insert(47);
        bt.insert(45);
        bt.insert(11);
        bt.insert(3);
        bt.insert(44);
        bt.insert(23);
        bt.insert(2);
        bt.insert(4);
        bt.insert(1);        
                          
        bt.printCorners();                        
    }
}
