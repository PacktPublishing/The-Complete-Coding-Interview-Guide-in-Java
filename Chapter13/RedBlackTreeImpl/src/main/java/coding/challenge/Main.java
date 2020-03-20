package coding.challenge;

public class Main {

    public static void main(String[] args) {

        RedBlackTree rbt = new RedBlackTree();
        rbt.insert(5);
        rbt.insert(15);
        rbt.insert(35);
        rbt.insert(3);
        rbt.insert(18);
        rbt.insert(6);
        rbt.insert(135);
        rbt.insert(65);
        rbt.print();

        System.out.println("\nDelete 5 and 35 ...");
        rbt.delete(5);
        rbt.delete(35);        

        rbt.print();
    }
}
