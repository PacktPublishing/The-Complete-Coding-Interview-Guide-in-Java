package coding.challenge;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

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

    public boolean isPath(T from, T to) {

        if (from == null || to == null) {
            return false;
        }

        if (from == to) {
            return true;
        }

        Queue<T> queue = new ArrayDeque<>();
        Set<T> visited = new HashSet<>();

        // we start from the 'from' node
        visited.add(from);
        queue.add(from);

        while (!queue.isEmpty()) {

            T element = queue.poll();

            List<T> adjacents = adjacencyList.get(element);
            if (adjacents != null) {

                for (T t : adjacents) {
                    if (t != null && !visited.contains(t)) {
                        visited.add(t);
                        queue.add(t);

                        // we reached the destination (the 'to' node)
                        if (t.equals(to)) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

}
