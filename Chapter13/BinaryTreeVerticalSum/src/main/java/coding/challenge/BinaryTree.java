package coding.challenge;
 
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiFunction;

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
             21
           /    \
          14     45
         /  \     \  
        7    3    44 
       /  \      /  \
      5    2    9    6
               /
             11  
     */
    private void buildTree() {

        root = new Node(21);
        root.left = new Node(14);
        root.right = new Node(45);
        root.left.left = new Node(7);
        root.left.right = new Node(3);
        root.left.left.left = new Node(5);
        root.left.left.right = new Node(2);
        root.right.right = new Node(44);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(6);
        root.right.right.left.left = new Node(11);
    }

    public void verticalSum() {

        // helper method to build the tree
        buildTree();

        // key: the horizontal distance of the current node from root node
        // value: sum of all nodes present at same horizontal distance
        Map<Integer, Integer> map = new TreeMap<>();

        // Pre-Order traversal of the tree and fill the map
        verticalSum(root, map, 0);

        // print the result
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
    }

    // 'dist' represents the horizontal distance from the root
    private void verticalSum(Node root, Map<Integer, Integer> map, int dist) {

        if (root == null) {
            return;
        }
        
        if (!map.containsKey(dist)) {
            map.put(dist, 0);
        }

        map.put(dist, map.get(dist) + root.element);        
        
        // or in functional-style
        /*
        BiFunction<Integer, Integer, Integer> distFunction
                = (distOld, distNew) -> distOld + distNew;
        map.merge(dist, root.element, distFunction);
        */

        // decrease horizontal distance by 1 and go to left
        verticalSum(root.left, map, dist - 1);

        // increase horizontal distance by 1 and go to right
        verticalSum(root.right, map, dist + 1);
    }

}
