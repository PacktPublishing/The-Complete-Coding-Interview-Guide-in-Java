package coding.challenge;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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

    // Recursive Depth-first Search (DFS) Topological Sort
    public Stack<T> topologicalSort(T startElement) {

        Set<T> visited = new HashSet<>();
        Stack<T> stack = new Stack<>();
        topologicalSort(startElement, visited, stack);

        return stack;
    }

    private void topologicalSort(T currentElement, Set<T> visited, Stack<T> stack) {

        visited.add(currentElement);

        List<T> adjacents = adjacencyList.get(currentElement);
        if (adjacents != null) {
            for (T t : adjacents) {
                if (t != null && !visited.contains(t)) {
                    topologicalSort(t, visited, stack);
                    visited.add(t);
                }
            }
        }

        stack.push(currentElement);
    }
}
