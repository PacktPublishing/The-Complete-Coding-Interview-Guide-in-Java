package coding.challenge;

public class Stream {

    private Node root = null;

    private class Node {

        private final int element;
        private int leftTreeSize;
        private Node left;
        private Node right;        

        private Node(int element) {
            this.element = element;
            this.left = null;
            this.right = null;
        }     
    }

    /* add a new node into the tree */
    public void generate(int element) {

        if (root == null) {
            root = new Node(element);
        } else {
            insert(root, element);
        }
    }

    private void insert(Node node, int element) {

        if (element <= node.element) {
            if (node.left != null) {
                insert(node.left, element);
            } else {
                node.left = new Node(element);
            }
            node.leftTreeSize++;
        } else {
            if (node.right != null) {
                insert(node.right, element);
            } else {
                node.right = new Node(element);
            }
        }
    }

    /* return rank of 'element' */
    public int getRank(int element) {
        return getRank(root, element);
    }

    private int getRank(Node node, int element) {

        if (element == node.element) {
            return node.leftTreeSize;
        } else if (element < node.element) {
            if (node.left == null) {
                return -1;
            } else {
                return getRank(node.left, element);
            }
        } else {
            int rightTreeRank = node.right == null 
                    ? -1 : getRank(node.right, element);
            
            if (rightTreeRank == -1) {
                return -1;
            } else {
                return node.leftTreeSize + 1 + rightTreeRank;
            }
        }
    }
}
