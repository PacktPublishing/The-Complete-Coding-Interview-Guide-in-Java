package coding.challenge;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    private Node root = null;
    private int max;

    private class Node {

        private Node left;
        private Node right;

        private final int element;

        public Node(int element) {
            this.element = element;
            this.left = null;
            this.right = null;
        }

        public Node(Node left, Node right, int element) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    // insert a node into the tree via Breadth-First Search (BFS)
    public boolean insert(int element) {

        if (root == null) {
            root = new Node(element);

            return true;
        }

        insert(root, element);

        return true;
    }

    // insert via Breadth-first Search (BFS) algorithm
    private void insert(Node node, int element) {

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

    public int maxPathSum() {
        maxPathSum(root);

        return max;
    }

    private int maxPathSum(Node root) {

        if (root == null) {
            return 0;
        }

        int left = maxPathSum(root.left);
        int right = maxPathSum(root.right);

        int sum = root.element + Math.max(left, 0) + Math.max(right, 0);

        max = Math.max(sum, max);

        sum = root.element + Math.max(0, Math.max(left, right));

        return sum;
    }
}
