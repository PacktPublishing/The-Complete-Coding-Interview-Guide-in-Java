package coding.challenge;
 
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class BinaryTree<T> {

    private Node root = null;

    private class Node {

        private Node left;
        private Node right;

        private final int element;

        private Node(int element) {
            this.element = element;
            this.left = null;
            this.right = null;
        }

        private Node(Node left, Node right, int element) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    /*        
              40
            /    \
          47      45
         /  \    /  
        11   3  44 
       /  \   \
      7    5   9
     /
    2         
    */
    private void buildTree() {

        root = new Node(40);
        root.left = new Node(47);
        root.right = new Node(45);
        root.left.left = new Node(11);
        root.left.right = new Node(3);
        root.right.left = new Node(44);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(5);
        root.left.right.right = new Node(9);
        root.left.left.left.left = new Node(2);
    }

    // Iterative approach: print the right view 
    public void printRightViewIterative() {

        buildTree();
        printRightViewIterative(root);
    }

    // Iterative approach: print the right view 
    private void printRightViewIterative(Node root) {

        if (root == null) {
            return;
        }

        // enqueue root node
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        Node currentNode;
        while (!queue.isEmpty()) {

            // number of nodes in the current level is given by the queue size
            int size = queue.size();

            int i = 0;

            // traverse every node of the current level and enqueue its
            // non-empty left and right child
            while (i < size) {

                i++;
                currentNode = queue.poll();

                // if this is last node of current level just print it
                if (i == size) {
                    System.out.print(currentNode.element + " ");
                }

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
    }

    // Recursive approach: print the right view 
    public void printRightViewRecursive() {

        buildTree();

        // store the last node for each level
        Map<Integer, Integer> map = new HashMap<>();

        // traverse the tree and fill map
        printRightViewRecursive(root, 1, map);

        // print the right view
        for (int i = 1; i <= map.size(); i++) {
            System.out.print(map.get(i) + " ");
        }
    }

    // Recursive approach: print the right view 
    private void printRightViewRecursive(Node root, int level, Map<Integer, Integer> map) {

        if (root == null) {
            return;
        }

        // insert the current node and the level into the map
        map.put(level, root.element);

        printRightViewRecursive(root.left, level + 1, map);
        printRightViewRecursive(root.right, level + 1, map);
    }

}
