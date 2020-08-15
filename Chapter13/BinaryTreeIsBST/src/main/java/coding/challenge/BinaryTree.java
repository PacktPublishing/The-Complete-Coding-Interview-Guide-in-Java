package coding.challenge;
 
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T extends Comparable<T>> {

    private Node root = null;

    private class Node {

        private Node left;
        private Node right;

        private final T element;

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

    // insert a node into the tree via Breadth-First Search (BFS)
    public boolean insert(T element) {

        if (element == null) {
            return false;
        }

        if (root == null) {
            root = new Node(element);

            return true;
        }

        insert(root, element);

        return true;
    }

    // insert via Breadth-first Search (BFS) algorithm
    private void insert(Node node, T element) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            node = queue.peek();
            queue.poll();

            if (node.left == null) {
                node.left = new Node(element);
                break;
            } else {
                queue.add(node.left);
            }

            if (node.right == null) {
                node.right = new Node(element);
                break;
            } else {
                queue.add(node.right);
            }
        }
    }
    
    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, null, null);
    }

    private boolean isBinarySearchTree(Node node, T minElement, T maxElement) {
        
        if (node == null) {
            return true;
        }

        if ((minElement != null && node.element.compareTo(minElement) <= 0)
                || (maxElement != null && node.element.compareTo(maxElement) > 0)) {
            return false;
        }

        if (!isBinarySearchTree(node.left, minElement, node.element)
                || !isBinarySearchTree(node.right, node.element, maxElement)) {
            return false;
        }
        
        return true;
    }

    public void print() {

        if (root == null) {
            return;
        }

        printLevelOrder(root);
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
