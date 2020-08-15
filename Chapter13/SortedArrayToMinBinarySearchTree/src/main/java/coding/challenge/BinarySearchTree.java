package coding.challenge;
 
import java.util.ArrayDeque;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {

    private int nodeCount;
    private Node root = null;

    private class Node {

        private final T element;

        private Node left;
        private Node right;

        public Node(T element) {
            this.element = element;
            this.left = null;
            this.right = null;
        }

        public Node(Node left, Node right, T element) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    public enum TraversalOrder {
        PRE,
        IN,
        POST,
        LEVEL
    }

    public void minimalBst(T m[]) {

        if (m == null) {
            throw new IllegalArgumentException("The given array cannot be null");
        }

        root = minimalBst(m, 0, m.length - 1);
    }

    private Node minimalBst(T m[], int start, int end) {

        if (end < start) {
            return null;
        }

        int middle = (start + end) / 2;
        Node node = new Node(m[middle]);

        nodeCount++;

        node.left = minimalBst(m, start, middle - 1);
        node.right = minimalBst(m, middle + 1, end);

        return node;
    }

    public int size() {
        return nodeCount;
    }

    public T root() {

        if (root == null) {
            return null;
        }

        return root.element;
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {

        if (node == null) {
            return 0;
        }

        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public void print(TraversalOrder to) {

        if (size() == 0) {
            System.out.println("empty");
            return;
        }

        switch (to) {
            case IN:
                printInOrder(root);
                break;
            case PRE:
                printPreOrder(root);
                break;
            case POST:
                printPostOrder(root);
                break;
            case LEVEL:
                printLevelOrder(root);
                break;
            default:
                throw new IllegalArgumentException("Unrecognized traversal order");
        }
    }

    private void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(" " + node.element);
            printInOrder(node.right);
        }
    }

    private void printPreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.element);
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    private void printPostOrder(Node node) {
        if (node != null) {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(" " + node.element);
        }
    }

    private void printLevelOrder(Node node) {

        Queue<Node> queue = new ArrayDeque<>();

        queue.add(node);

        while (!queue.isEmpty()) {

            Node current = queue.poll();

            System.out.print(" " + current.element);

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }
}
