package coding.challenge;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree<T> {

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

    // insert a node into the tree via Breadth-First Search (BFS)
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

    // insert via Breadth-first Search (BFS) algorithm
    private void insert(Node node, T element) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            node = queue.peek();
            queue.poll();

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

    // print tree via Depth-First Search (DFS) and Breadth-First Search (BFS) 
    public void print(TraversalOrder to) {

        if (size() == 0) {
            System.out.println("empty");
            return;
        }

        switch (to) {
            // DFS
            case IN:
                printInOrder(root);
                break;
            case PRE:
                printPreOrder(root);
                break;
            case POST:
                printPostOrder(root);
                break;
            // BFS
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

            // Step 1: Pop the first node from the queue as the current node
            Node current = queue.poll();

            // Step 2: Visit the current node
            System.out.print(" " + current.element);

            // Step 3: If the current node has a left node then enqueue that left node
            if (current.left != null) {
                queue.add(current.left);
            }

            // Step 4: If the current node has a right node then enqueue that right node
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    // tree Depth-First Search (DFS) and Breadth-First Search (BFS) traversal returning a list
    public List<T> asList(TraversalOrder to) {

        if (size() == 0) {
            return Collections.emptyList();
        }

        List<T> treeList = new ArrayList<>(size());

        switch (to) {
            // DFS
            case IN:
                traverseInOrderAsList(root, treeList);
                break;
            case PRE:
                traversePreOrderAsList(root, treeList);
                break;
            case POST:
                traversePostOrderAsList(root, treeList);
                break;
            // BFS    
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
            traversePreOrderAsList(node.left, treeList);
            traversePreOrderAsList(node.right, treeList);
        }
    }

    private void traversePostOrderAsList(Node node, List<T> treeList) {
        if (node != null) {
            traversePostOrderAsList(node.left, treeList);
            traversePostOrderAsList(node.right, treeList);
            treeList.add(node.element);
        }
    }

    private void traverseLevelOrderAsList(Node node, List<T> treeList) {

        Queue<Node> queue = new LinkedList<>();

        queue.add(node);

        while (!queue.isEmpty()) {

            Node current = queue.poll();

            treeList.add(current.element);

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    // tree Depth-First Search (DFS) and Breadth-First Search (BFS) traversal via a Java Iterator
    public Iterator<T> iterator(TraversalOrder to) {

        if (size() == 0) {
            return Collections.emptyIterator();
        }

        switch (to) {
            // DFS
            case IN:
                return traverseInOrderAsIterator(root);
            case PRE:
                return traversePreOrderAsIterator(root);
            case POST:
                return traversePostOrderAsIterator(root);
            // BFS    
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

    public T root() {

        if (root == null) {
            return null;
        }

        return root.element;
    }

    public int size() {
        return nodeCount;
    }
}
