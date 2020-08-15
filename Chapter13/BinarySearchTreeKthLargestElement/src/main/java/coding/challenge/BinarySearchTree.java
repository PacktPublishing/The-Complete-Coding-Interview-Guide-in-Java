package coding.challenge;
 
public class BinarySearchTree<T extends Comparable<T>> {

    private Node root = null;

    private class Node {

        private final T element;
        private Node left;
        private Node right;

        private Node(Node left, Node right, T element) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    public boolean insert(T element) {

        if (element == null) {
            return false;
        }

        if (contains(element)) {
            return false;
        }

        root = insert(root, element);

        return true;
    }

    private Node insert(Node current, T element) {

        if (current == null) {
            return new Node(null, null, element);
        }

        if (element.compareTo(current.element) < 0) {
            current.left = insert(current.left, element);
        } else {
            current.right = insert(current.right, element);
        }

        return current;
    }

    public boolean contains(T element) {

        return contains(root, element);
    }

    private boolean contains(Node current, T element) {

        if (current == null || element == null) {
            return false;
        }

        if (element.compareTo(current.element) == 0) {
            return true;
        }

        return element.compareTo(current.element) < 0
                ? contains(current.left, element)
                : contains(current.right, element);
    }

    public void kthLargest(int k) {

        kthLargest(root, k);
    }

    private int c;
    private void kthLargest(Node root, int k) {

        if (root == null || c >= k) {
            return;
        }

        kthLargest(root.right, k);
        c++;

        // we found the kth largest value
        if (c == k) {
            System.out.println(root.element);
        }

        kthLargest(root.left, k);
    }
}
