package coding.challenge;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Graph<Integer> graph = new Graph();

        graph.addEdge(40, 20);
        graph.addEdge(40, 10);
        graph.addEdge(10, 30);
        graph.addEdge(20, 10);
        graph.addEdge(20, 30);
        graph.addEdge(20, 60);
        graph.addEdge(20, 50);
        graph.addEdge(30, 60);
        graph.addEdge(60, 70);
        graph.addEdge(50, 70);        

        Stack<Integer> ts = graph.topologicalSort(40);

        while (ts.empty() == false) {
            System.out.print(ts.pop() + " ");
        }
    }
}
