package coding.challenge;
 
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Graph<String> graph = new Graph();

        graph.addEdge("D", "B");
        graph.addEdge("D", "A");
        graph.addEdge("B", "A");
        graph.addEdge("B", "C");
        graph.addEdge("B", "F");
        graph.addEdge("B", "E");
        graph.addEdge("E", "G");
        graph.addEdge("G", "H");
        graph.addEdge("A", "C");
        graph.addEdge("C", "F");
        graph.addEdge("F", "G");        
        
        Stack<String> ts = graph.topologicalSort("D");

        while (ts.empty() == false) {
            System.out.print(ts.pop() + " ");
        }
    }
}
