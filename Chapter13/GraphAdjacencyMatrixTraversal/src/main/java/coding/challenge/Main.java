package coding.challenge;

public class Main {

    public static void main(String[] args) {

        /*
                E
                | \
                |  \
            D---B---C
             \     /
              \   /
                A        
         */
        Graph<String> graph = new Graph();
        graph.add("A");
        graph.add("B");
        graph.add("C");
        graph.add("D");
        graph.add("E");

        int adjacencyMatrix[][] = {
            {0, 0, 1, 1, 0}, // Node A
            {0, 0, 1, 1, 1}, // Node B
            {1, 1, 0, 0, 1}, // Node C
            {1, 1, 0, 0, 0}, // Node D
            {0, 1, 1, 0, 0}, // Node E
        };

        System.out.println("\n\nTraversal via BFS starting from 'A':");
        graph.bfs(adjacencyMatrix, "A");

        System.out.println("\n\nTraversal via iterative DFS starting from 'A':");
        graph.dfsStack(adjacencyMatrix, "A");

        System.out.println("\n\nTraversal via recursive DFS starting from 'A':");
        graph.dfsRecursion(adjacencyMatrix, "A");
    }
}
