package coding.challenge;
 
public class Main {

    public static void main(String[] args) {
    
        BinaryTree bt = new BinaryTree();
                      
        System.out.println("Iterative approach:");
        bt.printRightViewIterative();
        
        System.out.println("\n\nRecursive approach:");
        bt.printRightViewRecursive();
    }
}
