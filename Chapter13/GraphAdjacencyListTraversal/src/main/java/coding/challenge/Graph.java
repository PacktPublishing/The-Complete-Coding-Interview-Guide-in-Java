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

        // mark the start element as visited and add it into the queue
        visited.add(startElement);
        queue.add(startElement);

        while (!queue.isEmpty()) {
            T element = queue.poll();

            System.out.print(element + " ");

            // mark as visited and add in the queue every unvisited adjacent
            List<T> adjacents = adjacencyList.get(element);
            if (adjacents != null) {
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

        // push the start element into the stack
        stack.add(startElement);

        while (!stack.isEmpty()) {

            T element = stack.pop();
            if (!visited.contains(element)) {
                System.out.print(element + " ");
                visited.add(element);
            }

            // push unvisited adjacent vertices
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

        // mark element as visited
        visited.add(currentElement);

        System.out.print(currentElement + " ");

        // visit each element via recursion
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
