package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

        /*                          
              40    
            /    \   
          47      47
         /  \    /  \ 
        11   3  3   11
         */
        BinaryTree<Integer> bt = new BinaryTree<>();

        bt.insert(40);
        bt.insert(47);
        bt.insert(47);
        bt.insert(11);
        bt.insert(3);
        bt.insert(3);
        bt.insert(11);

        System.out.println("Symmetry check recursive: " + bt.isSymmetricRecursive());
        System.out.println("Symmetry check iterative: " + bt.isSymmetricIterative());
    }
}
