package coding.challenge;
 
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    
    public void leafDistance(int dist) {
        
        // build a tree
        buildTree();

        // list to store root to leaf path
        List<Node> pathToLeaf = new ArrayList<>();

        // create an empty set to store distinct nodes at given distance from leaf nodes
        Set<Node> nodesAtDist = new HashSet<>();

        // find all nodes at the given distance from leaf nodes
        leafDistance(root, pathToLeaf, nodesAtDist, dist);

        // print the result
        for (Node nd : nodesAtDist) {
            System.out.print(nd.element + " ");
        }
    }

    private void leafDistance(Node node, List<Node> pathToLeaf,
            Set<Node> nodesAtDist, int dist) {

        if (node == null) {
            return;
        }

        // for each leaf node, store the node at distance 'dist'
        if (isLeaf(node) && pathToLeaf.size() >= dist) {
            nodesAtDist.add(pathToLeaf.get(pathToLeaf.size() - dist));

            return;
        }

        // add the current node into the current path        
        pathToLeaf.add(node);

        // go  to left and right subtree via recursion
        leafDistance(node.left, pathToLeaf, nodesAtDist, dist);
        leafDistance(node.right, pathToLeaf, nodesAtDist, dist);

        // remove the current node from the current path       
        pathToLeaf.remove(node);
    }

    private boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }
}
