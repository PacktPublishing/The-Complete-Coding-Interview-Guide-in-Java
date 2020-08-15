package coding.challenge;
 
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<T> {

    private Node root = null;

    private class Node {

        private Node left;
        private Node right;

        private final T element;

        private Node(T element) {
            this.element = element;
            this.left = null;
            this.right = null;
        }

        private Node(Node left, Node right, T element) {
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

    /* START: Recursive approach in O(n^2) */
    public void spiralOrderTraversalRecursive() {
        
        if (root == null) {
            return;
        }

        int level = 1;
        boolean flip = false;

        // as long as printLevel() returns true there are more levels to print
        while (printLevel(root, level++, flip = !flip)) {
            // there is nothing to do
        };
    }

    // print all nodes of a given level 
    private boolean printLevel(Node root, int level, boolean flip) {
        
        if (root == null) {
            return false;
        }

        if (level == 1) {
            System.out.print(root.element + " ");
            return true;
        }

        if (flip) {
            // process left child before right child
            boolean left = printLevel(root.left, level - 1, flip);
            boolean right = printLevel(root.right, level - 1, flip);

            return left || right;
        } else {
            // process right child before left child
            boolean right = printLevel(root.right, level - 1, flip);
            boolean left = printLevel(root.left, level - 1, flip);

            return right || left;
        }
    }
    /* END: Recursive approach in O(n^2) */

    /* START: Two stacks approach in O(n) and O(n) extra space */
    public void spiralOrderTraversalTwoStacks() {
        
        if (root == null) {
            return;
        }

        printSpiralTwoStacks(root);
    }

    private void printSpiralTwoStacks(Node node) {
        
        if (node == null) {
            return;
        }

        // create two stacks to store alternate levels         
        Stack<Node> rl = new Stack<>(); // right to left         
        Stack<Node> lr = new Stack<>(); // left to right 

        // Push first level to first stack 'rl' 
        rl.push(node);

        // print while any of the stacks has nodes 
        while (!rl.empty() || !lr.empty()) {

            // print nodes of the current level from 'rl' 
            // and push nodes of next level to 'lr'
            while (!rl.empty()) {

                Node temp = rl.peek();
                rl.pop();

                System.out.print(temp.element + " ");

                if (temp.right != null) {
                    lr.push(temp.right);
                }

                if (temp.left != null) {
                    lr.push(temp.left);
                }
            }

            // print nodes of the current level from 'lr' 
            // and push nodes of next level to 'rl'
            while (!lr.empty()) {
                Node temp = lr.peek();
                lr.pop();

                System.out.print(temp.element + " ");

                if (temp.left != null) {
                    rl.push(temp.left);
                }
                if (temp.right != null) {
                    rl.push(temp.right);
                }
            }
        }
    }
    /* END: Two stacks approach in O(n) and O(n) extra space */

    /* START: Deque approach in O(n) and O(n) extra space */
    public void spiralOrderTraversalDeque() {
        
        if (root == null) {
            return;
        }

        printSpiralDeque(root);
    }

    private void printSpiralDeque(Node root) {

        if (root == null) {
            return;
        }

        // create an empty double ended queue 
        Deque<Node> deque = new ArrayDeque<>();

        // enqueue the root node
        deque.addFirst(root);

        // odd or even level flag
        boolean oddEvenFlag = false;

        while (!deque.isEmpty()) {

            // number of nodes in the current level
            int nodesNo = deque.size();

            // print left to right
            if (oddEvenFlag) {

                // process each node of the current level 
                // and enqueue their non-empty left and right child
                while (nodesNo > 0) {

                    Node currentNode = deque.pollFirst();

                    System.out.print(currentNode.element + " ");

                    // push left child to the end followed by the right child
                    if (currentNode.left != null) {
                        deque.addLast(currentNode.left);
                    }

                    if (currentNode.right != null) {
                        deque.addLast(currentNode.right);
                    }

                    nodesNo--;
                }
            } else { // print right to left

                // process each node of the current level 
                // and enqueue their non-empty right and left child
                while (nodesNo > 0) {
                    // if 'oddEvenFlag' is false we pop from the back
                    Node currentNode = deque.pollLast();

                    System.out.print(currentNode.element + " ");

                    // push the right child to front followed by left child
                    if (currentNode.right != null) {
                        deque.addFirst(currentNode.right);
                    }

                    if (currentNode.left != null) {
                        deque.addFirst(currentNode.left);
                    }

                    nodesNo--;
                }
            }

            // flip the 'oddEvenFlag' for next level
            oddEvenFlag = !oddEvenFlag;    
        }
        /* END: Deque approach in O(n) and O(n) extra space */
    }
}
