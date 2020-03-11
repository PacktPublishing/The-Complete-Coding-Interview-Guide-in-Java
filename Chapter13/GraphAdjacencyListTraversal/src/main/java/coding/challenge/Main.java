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

        graph.addEdge("A", "C");
        graph.addEdge("A", "D");
        graph.addEdge("B", "C");
        graph.addEdge("B", "E");
        graph.addEdge("B", "D");
        graph.addEdge("C", "A");
        graph.addEdge("C", "B");
        graph.addEdge("C", "E");
        graph.addEdge("D", "A");
        graph.addEdge("D", "B");
        graph.addEdge("E", "C");
        graph.addEdge("E", "B");

        System.out.println("\n\nTraversal via BFS starting from 'A':");        
        graph.bfs("A");                  

        System.out.println("\n\nTraversal via iterative DFS starting from 'A':");        
        graph.dfsStack("A");
        
        System.out.println("\n\nTraversal via recursive DFS starting from 'A':");                
        graph.dfsRecursion("A");
    }
}
