package coding.challenge;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph<T> {

    // the adjacency list is represented as a map
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

        // mark the start element as visited and add it into the queue
        visited.add(startElement);
        queue.add(startElement);

        while (!queue.isEmpty()) {
            T element = queue.poll();

            System.out.print(element + " ");

            // mark as visited and add in the queue every unvisited adjacent
            List<T> adjacents = findAdjacents(adjacencyMatrix, element);
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
    public void dfsStack(int[][] adjacencyMatrix, T startElement) {

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

        // mark element as visited
        visited.add(currentElement);

        System.out.print(currentElement + " ");

        // visit each element via recursion
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
