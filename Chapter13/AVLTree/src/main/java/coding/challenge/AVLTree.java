package coding.challenge;

class AVLTree {

    private Node root;

    private class Node {

        private int element;
        private int height;

        private Node left;
        private Node right;

        private Node(int element) {
            this.element = element;
            this.height = 1;
        }
    }

    /* insert a node into the tree */
    public void insert(int element) {

        root = insert(root, element);
    }

    private Node insert(Node node, int element) {

        if (node == null) {
            return (new Node(element));
        }

        if (element < node.element) {
            node.left = insert(node.left, element);
        } else if (element > node.element) {
            node.right = insert(node.right, element);
        } else {
            return node;
        }

        node.height = 1 + max(height(node.left), height(node.right));

        int balanceFactor = getBalanceFactor(node);

        if (balanceFactor > 1) {
            if (element < node.left.element) {
                return rightRotate(node);
            } else if (element > node.left.element) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if (balanceFactor < -1) {
            if (element > node.right.element) {
                return leftRotate(node);
            } else if (element < node.right.element) {
                node.left = rightRotate(node.left);
                return leftRotate(node);
            }
        }

        return node;
    }

    /* delete an element from the tree */
    public void delete(int element) {
        delete(root, element);
    }

    private Node delete(Node root, int element) {

        if (root == null) {
            return root;
        }

        if (element < root.element) {
            root.left = delete(root.left, element);
        } else if (element > root.element) {
            root.right = delete(root.right, element);
        } else {
            if ((root.left == null) || (root.right == null)) {
                Node tmp = null;
                if (tmp == root.left) {
                    tmp = root.right;
                } else {
                    tmp = root.left;
                }

                if (tmp == null) {
                    tmp = root;
                    root = null;
                } else {
                    root = tmp;
                }
            } else {
                Node tmp = nodeWithMinValue(root.right);

                root.element = tmp.element;

                root.right = delete(root.right, tmp.element);
            }
        }

        if (root == null) {
            return root;
        }

        root.height = max(height(root.left), height(root.right)) + 1;

        int balanceFactor = getBalanceFactor(root);

        if (balanceFactor > 1) {
            if (getBalanceFactor(root.left) >= 0) {
                return rightRotate(root);
            } else {
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }
        }

        if (balanceFactor < -1) {
            if (getBalanceFactor(root.right) <= 0) {
                return leftRotate(root);
            } else {
                root.right = rightRotate(root.right);
                return leftRotate(root);
            }
        }
        return root;
    }

    /* pretty print the tree */
    public void print() {
        System.out.println("\nPre-Order Traversal:");
        print(root, "", false);
    }

    private void print(Node node, String indent, boolean last) {
        if (node != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }

            System.out.println(node.element);

            print(node.left, indent, false);
            print(node.right, indent, true);
        }
    }

    /* HELPER METHODS */
    private Node rightRotate(Node q) {
        Node p = q.left;
        Node aux = p.right;

        p.right = q;
        q.left = aux;

        q.height = max(height(q.left), height(q.right)) + 1;
        p.height = max(height(p.left), height(p.right)) + 1;

        return p;
    }

    private Node leftRotate(Node p) {
        Node q = p.right;
        Node aux = q.left;

        q.left = p;
        p.right = aux;

        p.height = max(height(p.left), height(p.right)) + 1;
        q.height = max(height(q.left), height(q.right)) + 1;

        return q;
    }

    private int getBalanceFactor(Node node) {
        
        if (node == null) {
            return 0;
        }
        
        return height(node.left) - height(node.right);
    }
    
    private int height(Node node) {
        
        if (node == null) {
            return 0;
        }
        
        return node.height;
    }

    private Node nodeWithMinValue(Node node) {
        Node current = node;

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }
    
    private int max(int e1, int e2) {
        return (e1 > e2) ? e1 : e2;
    }      
}
