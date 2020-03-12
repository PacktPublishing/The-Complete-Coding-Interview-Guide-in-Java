package coding.challenge;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph<T> {

    // the adjacency list is represented as a map
    private final Map<T, List<T>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    // adding a new edge between two elements
    public boolean addEdge(T from, T to) {

        if (from == null || to == null) {
            return false;
        }

        List<T> adjacents = adjacencyList.get(from);

        // we add an element that has no edges until now, therefore
        // we have to add the element and create its empty list of adjacents
        if (adjacents == null) {

            List list = new ArrayList<>();
            list.add(to);

            adjacencyList.put(from, list);
        } else {
            // we add an edge to an existing element
            adjacents.add(to);
        }

        return true;
    }

    // Breadth-first Search (BFS)
    public void bfs(T startElement) {

        Queue<T> queue = new ArrayDeque<>();
        Set<T> visited = new HashSet<>();

        // Step 1: Mark the start node (current node) as visited 
        //         (add it in the collection of visited nodes) and add it into the BFS queue
        visited.add(startElement);
        queue.add(startElement);

        while (!queue.isEmpty()) {
            
            // Step 2: Pop the current node from the queue
            T element = queue.poll();

            // Step 3: Visit the current node
            System.out.print(element + " ");

            // Step 4: Get the adjacent nodes of the current node 
            List<T> adjacents = adjacencyList.get(element);
            if (adjacents != null) {
                
                // Step 5: Loop the adjacent nodes and for each non-null and unvisited node:
                //      a. Mark as visited (add it in the collection of visited nodes)
                //      b. Add it the queue
                for (T t : adjacents) {
                    if (t != null && !visited.contains(t)) {
                        visited.add(t);
                        queue.add(t);
                    }
                }
            }
        }
    }

    // iterative Depth-first Search (DFS) using Java Stack
    public void dfsStack(T startElement) {

        Stack<T> stack = new Stack<>();
        Set<T> visited = new HashSet<>();

        // Step 1: Start from the current node (the given node)
        //         and push the current node into Stack
        stack.add(startElement);

        // Step 2: While Stack not empty
        while (!stack.isEmpty()) {

            // Step 2(a): Pop the current node from the Stack
            T element = stack.pop();
            
            if (!visited.contains(element)) {
                
                // Step 2(b): Visit current node
                System.out.print(element + " ");
                
                // Step 2(c): Mark the current node as visited (add it in the 
                //            collection of visited nodes)
                visited.add(element);
            }

            // Step 2(d): Push unvisited adjacent vertices
            List<T> adjacents = adjacencyList.get(element);
            if (adjacents != null) {
                for (T t : adjacents) {
                    if (t != null && !visited.contains(t)) {
                        stack.push(t);
                    }
                }
            }
        }
    }

    // Recursive Depth-first Search (DFS)
    public void dfsRecursion(T startElement) {

        Set<T> visited = new HashSet<>();
        dfsRecursion(startElement, visited);
    }

    private void dfsRecursion(T currentElement, Set<T> visited) {

        // Step 1: Start from the current node (the given node) 
        //         and mark the current node as visited (add it in 
        //         the collection of visited nodes)
        visited.add(currentElement);

        // Step 2: Visit current node
        System.out.print(currentElement + " ");

        // Step 3: Traverse unvisited adjacent vertices via recursionS
        List<T> adjacents = adjacencyList.get(currentElement);
        if (adjacents != null) {
            for (T t : adjacents) {
                if (t != null && !visited.contains(t)) {
                    dfsRecursion(t, visited);
                }
            }
        }
    }
}
