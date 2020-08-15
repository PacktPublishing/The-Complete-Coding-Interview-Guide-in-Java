package coding.challenge;
 
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {

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

    public boolean isSubtree(BinaryTree q) {

        return isSubtree(root, q.root);
    }

    private boolean isSubtree(Node p, Node q) {

        if (p == null) {
            return false;
        }

        // if the roots don't match
        if (!match(p, q)) {
            return (isSubtree(p.left, q) || isSubtree(p.right, q));
        }

        return true;
    }

    private boolean match(Node p, Node q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return (p.element == q.element
                && match(p.left, q.left)
                && match(p.right, q.right));
    }
}
