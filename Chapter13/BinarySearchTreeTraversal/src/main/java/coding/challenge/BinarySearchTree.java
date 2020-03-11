package coding.challenge;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {

    private int nodeCount;
    private Node root = null;

    private class Node {

        private T element;
        private Node left;
        private Node right;

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

    public boolean add(T element) {

        if (element == null) {
            return false;
        }

        if (contains(element)) {
            return false;
        }

        root = addRecursive(root, element);
        nodeCount++;

        return true;
    }

    private Node addRecursive(Node current, T element) {

        if (current == null) {
            return new Node(null, null, element);
        }

        if (element.compareTo(current.element) < 0) {
            current.left = addRecursive(current.left, element);
        } else {
            current.right = addRecursive(current.right, element);
        }

        return current;
    }

    public boolean contains(T element) {

        return containsNodeRecursive(root, element);
    }

    private boolean containsNodeRecursive(Node current, T element) {

        if (current == null || element == null) {
            return false;
        }

        if (element.compareTo(current.element) == 0) {
            return true;
        }

        return element.compareTo(current.element) < 0
                ? containsNodeRecursive(current.left, element)
                : containsNodeRecursive(current.right, element);
    }

    public boolean delete(T element) {

        if (contains(element)) {
            root = deleteRecursive(root, element);
            nodeCount--;

            return true;
        }

        return false;
    }

    private Node deleteRecursive(Node node, T element) {

        if (node == null) {
            return null;
        }

        if (element.compareTo(node.element) < 0) {
            node.left = deleteRecursive(node.left, element);
        } else if (element.compareTo(node.element) > 0) {
            node.right = deleteRecursive(node.right, element);
        }

        if (element.compareTo(node.element) == 0) {

            if (node.right == null) {
                Node left = node.left;

                node = null;
                return left;
            } else if (node.left == null) {
                Node right = node.right;

                node = null;
                return right;
            } else {
                Node leftmost = findLeftmostNode(node.right);

                node.element = leftmost.element;
                node.right = deleteRecursive(node.right, node.element);
            }

        }

        return node;
    }

    public T min() {

        if (root == null) {
            return null;
        }

        return findLeftmostNode(root).element;
    }

    public T root() {

        if (root == null) {
            return null;
        }

        return root.element;
    }

    public T max() {

        if (root == null) {
            return null;
        }

        return findRightmostNode(root).element;
    }

    private Node findLeftmostNode(Node node) {

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    private Node findRightmostNode(Node node) {

        while (node.right != null) {
            node = node.right;
        }

        return node;
    }

    public int size() {
        return nodeCount;
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

        Queue<Node> queue = new ArrayDeque<>();

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

    public Iterator<T> iterator(TraversalOrder to) {

        if (size() == 0) {
            return Collections.emptyIterator();
        }

        switch (to) {
            case IN:
                return traverseInOrderAsIterator(root);
            case PRE:
                return traversePreOrderAsIterator(root);
            case POST:
                return traversePostOrderAsIterator(root);
            case LEVEL:
                return traverseLevelOrderAsIterator(root);
            default:
                throw new IllegalArgumentException("Unrecognized traversal order");
        }
    }

    private Iterator<T> traverseInOrderAsIterator(Node node) {

        final int expectedNodeCount = size();

        final Deque<Node> stack = new ArrayDeque<>();

        stack.push(node);

        return new Iterator<T>() {
            Node cursor = node;

            @Override
            public boolean hasNext() {
                if (expectedNodeCount != nodeCount) {
                    throw new ConcurrentModificationException();
                }

                return node != null && !stack.isEmpty();
            }

            @Override
            public T next() {

                if (expectedNodeCount != nodeCount) {
                    throw new ConcurrentModificationException();
                }

                while (cursor != null && cursor.left != null) {
                    stack.push(cursor.left);
                    cursor = cursor.left;
                }

                Node current = stack.pop();

                if (current.right != null) {
                    stack.push(current.right);
                    cursor = current.right;
                }

                return current.element;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    private Iterator<T> traversePreOrderAsIterator(Node node) {

        final int expectedNodeCount = size();

        final Deque<Node> stack = new ArrayDeque<>();

        stack.push(node);

        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                if (expectedNodeCount != nodeCount) {
                    throw new ConcurrentModificationException();
                }

                return node != null && !stack.isEmpty();
            }

            @Override
            public T next() {

                if (expectedNodeCount != nodeCount) {
                    throw new ConcurrentModificationException();
                }

                Node current = stack.pop();

                if (current.right != null) {
                    stack.push(current.right);
                }

                if (current.left != null) {
                    stack.push(current.left);
                }

                return current.element;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    private Iterator<T> traversePostOrderAsIterator(Node node) {

        final int expectedNodeCount = size();

        final Deque<Node> stacka = new ArrayDeque<>();
        final Deque<Node> stackb = new ArrayDeque<>();

        stacka.push(node);

        while (!stacka.isEmpty()) {
            Node nodea = stacka.pop();
            if (nodea != null) {
                stackb.push(nodea);
                if (nodea.left != null) {
                    stacka.push(nodea.left);
                }
                if (nodea.right != null) {
                    stacka.push(nodea.right);
                }
            }
        }

        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                if (expectedNodeCount != nodeCount) {
                    throw new ConcurrentModificationException();
                }

                return node != null && !stackb.isEmpty();
            }

            @Override
            public T next() {

                if (expectedNodeCount != nodeCount) {
                    throw new ConcurrentModificationException();
                }

                return stackb.pop().element;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    private Iterator<T> traverseLevelOrderAsIterator(Node node) {

        final int expectedNodeCount = size();

        final Queue<Node> queue = new ArrayDeque<>();

        queue.offer(node);

        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                if (expectedNodeCount != nodeCount) {
                    throw new ConcurrentModificationException();
                }

                return node != null && !queue.isEmpty();
            }

            @Override
            public T next() {

                if (expectedNodeCount != nodeCount) {
                    throw new ConcurrentModificationException();
                }

                Node current = queue.poll();

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }

                return current.element;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
