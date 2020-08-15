package coding.challenge;
 
import java.util.HashMap;
import java.util.Map;

public final class LRUCache {

    private final class Node {

        private int key;
        private int value;
        private Node next;
        private Node prev;

        @Override
        public String toString() {
            return "(" + key + ", " + value + ") ";
        }
    }

    private final Map<Integer, Node> hashmap;

    private Node head;
    private Node tail;

    // 5 is the maximum size of the cache
    private static final int LRU_SIZE = 5;

    public LRUCache() {
        hashmap = new HashMap<>();
    }

    public int getEntry(int key) {

        Node node = hashmap.get(key);

        // if the key already exist the just update its usage in cache
        if (node != null) {
            removeNode(node);
            addNode(node);

            return node.value;
        }

        // by convention, data not found is marked as -1
        return -1;
    }

    public void putEntry(int key, int value) {

        Node node = hashmap.get(key);

        // if the key already exist then update the value and move it to top of the cache                 
        if (node != null) { 

            node.value = value;

            removeNode(node);
            addNode(node);
            
        } else {
            // this is new key
            Node newNode = new Node();
            newNode.prev = null;
            newNode.next = null;
            newNode.value = value;
            newNode.key = key;

            // if we reached the maximum size of the cache then we have to remove the  Least Recently Used
            if (hashmap.size() >= LRU_SIZE) { 

                hashmap.remove(tail.key);
                removeNode(tail);

                addNode(newNode);
            } else {
                addNode(newNode);
            }

            hashmap.put(key, newNode);
        }
    }

    // helper method to add a node to the top of the cache
    private void addNode(Node node) {
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = head;
        }
    }

    // helper method to remove a node from the cache
    private void removeNode(Node node) {

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    // helper method to print the cache    
    public void print() {

        System.out.println("\nCache content: ");

        Node currentNode = head;
        while (currentNode != null) {

            System.out.print(currentNode);
            currentNode = currentNode.next;
        }

        System.out.println();
    }

}
