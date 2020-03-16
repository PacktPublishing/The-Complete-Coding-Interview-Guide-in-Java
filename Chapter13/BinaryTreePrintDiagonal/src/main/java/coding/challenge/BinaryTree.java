package coding.challenge;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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

    // print the diagonal elements of given binary tree
    public void printDiagonalRecursive() {

        // map of diagonals
        Map<Integer, List<T>> map = new HashMap<>();

        // Pre-Order traversal of the tree and fill up the map
        printDiagonal(root, 0, map);

        // print the current diagonal
        for (int i = 0; i < map.size(); i++) {
            System.out.println(map.get(i));
        }
    }

    // recursive Pre-Order traversal of the tree and put the diagonal elements in the map
    private void printDiagonal(Node node, int diagonal, Map<Integer, List<T>> map) {

        if (node == null) {
            return;
        }

        // insert the current node in the diagonal
        if (!map.containsKey(diagonal)) {
            map.put(diagonal, new ArrayList<>());
        }

        map.get(diagonal).add(node.element);

        // increase the diagonal by 1 and go to the left sub-tree
        printDiagonal(node.left, diagonal + 1, map);

        // maintain the current diagonal and go to the right sub-tree
        printDiagonal(node.right, diagonal, map);
    }

    // iterative approach for printing the diagonal elements of given binary tree
    public void printDiagonalIterative() {

        Queue<Node> queue = new ArrayDeque<>();

        // mark the end of a diagonal via dummy null value
        Node dummy = new Node(null);

        // enqueue all the nodes of the first diagonal in the binary tree
        while (root != null) {
            queue.add(root);
            root = root.right;
        }

        // enqueue the dummy node at the end of each diagonal
        queue.add(dummy);

        // loop while there are more nodes than the dummy
        while (queue.size() != 1) {

            Node front = queue.poll();

            if (front != dummy) {

                // print current node
                System.out.print(front.element + " ");

                // enqueue the nodes of the next diagonal in the binary tree
                Node node = front.left;
                while (node != null) {
                    queue.add(node);
                    node = node.right;
                }
            } else {
                // at the end of the current diagonal enqueue the dummy node                
                queue.add(dummy);

                System.out.println();
            }
        }
    }
}
