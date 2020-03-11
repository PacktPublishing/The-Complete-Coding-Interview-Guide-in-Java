package coding.challenge;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree<T extends Comparable<T>> {

    private int nodeCount;
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

    public enum TraversalOrder {
        PRE,
        IN,
        POST,
        LEVEL
    }

    public boolean insert(T element) {

        if (element == null) {
            return false;
        }

        if (root == null) {
            root = new Node(element);
            nodeCount++;

            return true;
        }

        insert(root, element);

        return true;
    }

    private void insert(Node node, T element) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            node = queue.peek();
            queue.remove();

            if (node.left == null) {
                node.left = new Node(element);
                nodeCount++;
                break;
            } else {
                queue.add(node.left);
            }

            if (node.right == null) {
                node.right = new Node(element);
                nodeCount++;
                break;
            } else {
                queue.add(node.right);
            }
        }
    }

    public T root() {

        if (root == null) {
            return null;
        }

        return root.element;
    }

    public int size() {
        return nodeCount;
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
            printInOrder(node.left);
            printInOrder(node.right);
        }
    }

    private void printPostOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            printInOrder(node.right);
            System.out.print(" " + node.element);
        }
    }

    private void printLevelOrder(Node node) {

        Queue<Node> queue = new ArrayDeque<>();

        queue.add(node);

        while (!queue.isEmpty()) {

            Node current = queue.remove();

            System.out.print(" " + current.element);

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public List<T> asList(TraversalOrder to) {

        if (size() == 0) {
            return Collections.emptyList();
        }

        List<T> treeList = new ArrayList<>(size());

        switch (to) {
            case IN:
                traverseInOrderAsList(root, treeList);
                break;
            case PRE:
                traversePreOrderAsList(root, treeList);
                break;
            case POST:
                traversePostOrderAsList(root, treeList);
                break;
            case LEVEL:
                traverseLevelOrderAsList(root, treeList);
                break;
            default:
                throw new IllegalArgumentException("Unrecognized traversal order");
        }

        return treeList;
    }

    private void traverseInOrderAsList(Node node, List<T> treeList) {
        if (node != null) {
            traverseInOrderAsList(node.left, treeList);
            treeList.add(node.element);
            traverseInOrderAsList(node.right, treeList);
        }
    }

    private void traversePreOrderAsList(Node node, List<T> treeList) {
        if (node != null) {
            treeList.add(node.element);
            traverseInOrderAsList(node.left, treeList);
            traverseInOrderAsList(node.right, treeList);
        }
    }

    private void traversePostOrderAsList(Node node, List<T> treeList) {
        if (node != null) {
            traverseInOrderAsList(node.left, treeList);
            traverseInOrderAsList(node.right, treeList);
            treeList.add(node.element);
        }
    }

    private void traverseLevelOrderAsList(Node node, List<T> treeList) {

        Queue<Node> queue = new LinkedList<>();

        queue.add(node);

        while (!queue.isEmpty()) {

            Node current = queue.remove();

            treeList.add(current.element);

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

}
