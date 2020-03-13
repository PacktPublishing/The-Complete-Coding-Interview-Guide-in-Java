package coding.challenge;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
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

    public List<List<T>> fetchAllLevels() {

        if (root == null) {
            return Collections.emptyList();
        }

        // each list holds a level
        List<List<T>> allLevels = new ArrayList<>();

        // first level (containing only the root)
        Queue<Node> currentLevelOfNodes = new ArrayDeque<>();
        List<T> currentLevelOfElements = new ArrayList<>();

        currentLevelOfNodes.add(root);
        currentLevelOfElements.add(root.element);

        while (!currentLevelOfNodes.isEmpty()) {

            // store the current level as the previous level
            Queue<Node> previousLevelOfNodes = currentLevelOfNodes;

            // add level to the final list
            allLevels.add(currentLevelOfElements);

            // go to the next level as the current level
            currentLevelOfNodes = new ArrayDeque<>();
            currentLevelOfElements = new ArrayList<>();

            // traverse all nodes on current level
            for (Node parent : previousLevelOfNodes) {

                if (parent.left != null) {
                    currentLevelOfNodes.add(parent.left);
                    currentLevelOfElements.add(parent.left.element);
                }
                
                if (parent.right != null) {
                    currentLevelOfNodes.add(parent.right);
                    currentLevelOfElements.add(parent.right.element);
                }
            }
        }

        return allLevels;
    }
}
