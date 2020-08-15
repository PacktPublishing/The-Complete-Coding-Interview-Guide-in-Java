package coding.challenge;
 
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BinarySearchTree {

    private Node root = null;

    private class Node {

        private final int element;

        private Node left;
        private Node right;

        public Node(Node left, Node right, int element) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    public boolean insert(int element) {

        root = insert(root, element);
        return true;
    }

    private Node insert(Node current, int element) {

        if (current == null) {
            return new Node(null, null, element);
        }

        if (element < current.element) {
            current.left = insert(current.left, element);
        } else {
            current.right = insert(current.right, element);
        }

        return current;
    }

    /* Implementation using hashing */
    public boolean findPairSumHashing(int sum) {

        if (sum <= 0) {
            return false;
        }

        return findPairSumHashing(root, sum, new HashSet());
    }

    private static boolean findPairSumHashing(Node node, int sum, Set<Integer> set) {

        // base case
        if (node == null) {
            return false;
        }

        // find the pair in the left subtree 
        if (findPairSumHashing(node.left, sum, set)) {
            return true;
        }

        // if pair is formed with current node then print the pair      
        if (set.contains(sum - node.element)) {
            System.out.print("\nPair (" + (sum - node.element) + ", "
                    + node.element + ") = " + sum);
            return true;
        } else {
            set.add(node.element);
        }

        // find the pair in the right subtree 
        return findPairSumHashing(node.right, sum, set);
    }

    /* Implementation using two Stacks */
    public boolean findPairSumTwoStacks(int sum) {

        if (sum <= 0 || root == null) {
            return false;
        }

        return findPairSumTwoStacks(root, sum);
    }

    private static boolean findPairSumTwoStacks(Node node, int sum) {

        Stack<Node> fio = new Stack<>(); // fio - Forward In-Order
        Stack<Node> rio = new Stack<>();  // rio - Reverse In-Order

        Node minNode = node;
        Node maxNode = node;

        while (!fio.isEmpty() || !rio.isEmpty()
                || minNode != null || maxNode != null) {
            if (minNode != null || maxNode != null) {
                if (minNode != null) {
                    fio.push(minNode);
                    minNode = minNode.left;
                }

                if (maxNode != null) {
                    rio.push(maxNode);
                    maxNode = maxNode.right;
                }
            } else {
                int elem1 = fio.peek().element;
                int elem2 = rio.peek().element;

                if (fio.peek() == rio.peek()) {
                    break;
                }

                if ((elem1 + elem2) == sum) {
                    System.out.print("\nPair (" + elem1 + ", " + elem2 + ") = " + sum);
                    return true;
                }

                if ((elem1 + elem2) < sum) {
                    minNode = fio.pop();
                    minNode = minNode.right;
                } else {
                    maxNode = rio.pop();
                    maxNode = maxNode.left;
                }
            }
        }

        return false;
    }

    // use printInOrder() if you need to print the tree
    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(" " + node.element);
            printInOrder(node.right);
        }
    }
}
