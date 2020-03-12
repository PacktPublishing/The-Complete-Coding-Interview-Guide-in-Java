package coding.challenge;

public class Main {

    public static void main(String[] args) {

    Graph<String> graph = new Graph();

        // directed graph
        graph.addEdge("A", "C");
        graph.addEdge("C", "B");
        graph.addEdge("C", "E");
        graph.addEdge("B", "E");
        graph.addEdge("D", "A");
        graph.addEdge("D", "B");
       
        boolean isPathAE = graph.isPath("A", "E");
        System.out.println("Is path from A to E: " + isPathAE);
        
        boolean isPathEA = graph.isPath("E", "A");
        System.out.println("Is path from E to A: " + isPathEA);
        
        boolean isPathCD = graph.isPath("C", "D");
        System.out.println("Is path from C to D: " + isPathCD);
        
        boolean isPathDC = graph.isPath("D", "C");
        System.out.println("Is path from D to C: " + isPathDC);
        
        boolean isPathDE = graph.isPath("D", "E");
        System.out.println("Is path from D to E: " + isPathDE);
        
        boolean isPathED = graph.isPath("E", "D");
        System.out.println("Is path from E to D: " + isPathED);
    }
}
