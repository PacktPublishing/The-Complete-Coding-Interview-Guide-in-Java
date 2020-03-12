package coding.challenge;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph<T> {

    // the vertices list
    private final List<T> elements;

    public Graph() {
        this.elements = new ArrayList<>();
    }

    public boolean add(T element) {

        if (element == null) {
            return false;
        }

        elements.add(element);

        return true;
    }

    // Breadth-first Search (BFS)
    public void bfs(int[][] adjacencyMatrix, T startElement) {

        Queue<T> queue = new ArrayDeque<>();
        Set<T> visited = new HashSet<>();

        // Step 1: Mark the start node (current node) as visited (add it 
        //         in the collection of visited nodes) and add it into the BFS queue
        visited.add(startElement);
        queue.add(startElement);

        while (!queue.isEmpty()) {
            
            // Step 2: Pop the current node from the queue
            T element = queue.poll();

            // Step 3: Visit the current node
            System.out.print(element + " ");

            // Step 4: Get the adjacent nodes of the current node 
            List<T> adjacents = findAdjacents(adjacencyMatrix, element);
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
    public void dfsStack(int[][] adjacencyMatrix, T startElement) {

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
            List<T> adjacents = findAdjacents(adjacencyMatrix, element);
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
    public void dfsRecursion(int[][] adjacencyMatrix, T startElement) {

        Set<T> visited = new HashSet<>();
        dfsRecursion(adjacencyMatrix, startElement, visited);
    }

    private void dfsRecursion(int[][] adjacencyMatrix, T currentElement, Set<T> visited) {

        // Step 1: Start from the current node (the given node) 
        //         and mark the current node as visited (add it in the 
        //         collection of visited nodes)
        visited.add(currentElement);

        // Step 2: Visit current node
        System.out.print(currentElement + " ");

        // Step 3: Traverse unvisited adjacent vertices via recursion
        List<T> adjacents = findAdjacents(adjacencyMatrix, currentElement);
        if (adjacents != null) {
            for (T t : adjacents) {
                if (t != null && !visited.contains(t)) {
                    dfsRecursion(adjacencyMatrix, t, visited);
                }
            }
        }
    }

    private List<T> findAdjacents(int[][] adjacencyMatrix, T element) {

        int tIndex = -1;

        List<T> adjacents = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).equals(element)) {
                tIndex = i;
                break;
            }
        }

        if (tIndex != -1) {
            for (int j = 0; j < adjacencyMatrix[tIndex].length; j++) {
                if (adjacencyMatrix[tIndex][j] == 1) {
                    adjacents.add(elements.get(j));
                }
            }
        }

        return adjacents;
    }

}
