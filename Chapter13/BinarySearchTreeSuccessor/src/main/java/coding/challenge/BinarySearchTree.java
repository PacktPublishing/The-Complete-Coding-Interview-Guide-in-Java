package coding.challenge;
 
public class BinarySearchTree {

    private Node root = null;

    private class Node {

        private final int element;
        private Node left;
        private Node right;
        private Node parent;

        public Node(int element) {
            this.element = element;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }

    public void buildTreeSample() {

        root = new Node(70);
        Node n2 = new Node(50);
        Node n3 = new Node(75);
        Node n4 = new Node(40);
        Node n5 = new Node(55);
        Node n6 = new Node(72);
        Node n7 = new Node(77);
        Node n8 = new Node(35);
        Node n9 = new Node(54);
        Node n10 = new Node(60);
        Node n11 = new Node(58);
        Node n12 = new Node(59);

        root.left = n2;
        root.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        n4.left = n8;

        n5.left = n9;
        n5.right = n10;

        n10.left = n11;

        n11.right = n12;

        n2.parent = root;
        n3.parent = root;

        n4.parent = n2;
        n5.parent = n2;
        n6.parent = n3;
        n7.parent = n3;

        n8.parent = n4;
        n9.parent = n5;
        n10.parent = n5;
        n11.parent = n10;
        n12.parent = n11;
    }

    public void inOrderSuccessor() {

        // this is n12 (node with element 59)
        Node node = root.left.right.right.left.right;

        System.out.println("\n\nIn-Order:");
        System.out.print("Start node: " + node.element);
        node = inOrderSuccessor(node);
        System.out.print(" Successor node: " + node.element);
    }

    private Node inOrderSuccessor(Node node) {

        if (node == null) {
            return null;
        }

        // case (a): 'node' has the right sub-tree:
        //              - return the leftmost node of the right sub-tree
        if (node.right != null) {
            return findLeftmostNode(node.right);
        }

        // case (b):   'node' has no right sub-tree        
        // case (b.1): 'node' is the left child of its parent:
        //               - return its parent
        //
        // case (b.2): 'node' is the right child of its parent:
        //               - 'node' traverse upwards until 'node' is the left child of its parent
        //               - then return this parent
        //
        // case (c):   'node' is the last node in traversal:
        //               - return the root's parent (e.g., null)
        while (node.parent != null && node.parent.right == node) {
            node = node.parent;
        }
        
        return node.parent;
    }

    public void preOrderSuccessor() {

        // this is n12 (node with element 59)
        Node node = root.left.right.right.left.right;

        System.out.println("\n\nPre-Order:");
        System.out.print("Start node: " + node.element);
        node = preOrderSuccessor(node);
        System.out.print(" Successor node: " + node.element);
    }

    private Node preOrderSuccessor(Node node) {

        if (node == null) {
            return null;
        }

        // case (a): 'node' has a child:
        //             - return that child (left if exists, otherwise right)
        if (node.left != null) {
            return node.left;
        } else if (node.right != null) {
            return node.right;
        }

        // case (b): 'node' has no child:
        //             - 'node' traverse upwards until reaching a parent that has a right child
        //               (which is not 'node'), then return this right child
        while (node.parent != null && (node.parent.right == null || node.parent.right == node)) {
            node = node.parent;
        }
        // case (c): 'node' is the last node in traversal:
        //              - return the root's parent (e.g., null)
        if (node.parent == null) {
            return null;
        }

        return node.parent.right;
    }

    public void postOrderSuccessor() {

        // this is n12 (node with element 59)
        Node node = root.left.right.right.left.right;

        System.out.println("\n\nPost-Order:");
        System.out.print("Start node: " + node.element);
        node = postOrderSuccessor(node);
        System.out.print(" Successor node: " + node.element);
    }

    private Node postOrderSuccessor(Node node) {

        // case (a): 'node' is the last node in traversal:
        //              - return the root's parent (e.g., null)
        if (node == null || node.parent == null) {
            return null;
        }

        // case (b):   'node' is the left child of its parent:
        //               - return the parent
        //
        // case (c):   'node' is the right child of its parent:
        // case (c.1):  parent has no right child:
        //                - return the parent
        if (node.parent.right == node || node.parent.right == null) {
            return node.parent;
        }

        // case (c.2): parent has the right child:
        //               - return the leftmost bottom node of parent's right sub-tree
        return findLeftmostNode(node.parent.right);
    }

    private Node findLeftmostNode(Node node) {

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }
}
