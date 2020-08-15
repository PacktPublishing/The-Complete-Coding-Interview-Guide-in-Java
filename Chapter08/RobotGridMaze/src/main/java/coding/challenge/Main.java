package coding.challenge;
 
import java.awt.Point;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
       
        /* 0 - robot, # - maze, X - target
 (m, n) +           +
        |0| | | | | |
        |0|0| | | | |
        |#|0|0|0|0| | 
        |#|#|#|#|0| |        
        | | | | |0| | 
        | | | | |0|X|
        +           + (0, 0)
        */       
        
        // we store the path in a LinkedHashSet
        Set<Point> path = new LinkedHashSet<>();
        
        // we define the maze
        boolean[][] maze  = new boolean[6][6];
        maze[2][0]=true;
        maze[3][0]=true;
        maze[3][1]=true;
        maze[3][2]=true;
        maze[3][3]=true;
        
        // we compute and display the path
        RobotGrid.computePath(5, 5, maze, path);
        
        System.out.println("Computed path (plain recursion):");
        path.forEach(System.out::println);
        
        // we define a Set for storing the visited cells
        Set<Point> visited = new HashSet<>();
        
        // we compute and display the path
        RobotGrid.computePath(5, 5, maze, path, visited);
        
        System.out.println("\nComputed path (Memoization):");
        path.forEach(System.out::println);
    }
}
