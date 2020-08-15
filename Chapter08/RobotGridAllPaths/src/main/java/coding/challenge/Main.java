package coding.challenge;
 
public class Main {

    public static void main(String[] args) {              
        
        // 6x6 grid
        int result1 = RobotGrid.countPaths(6, 6);
        int result2 = RobotGrid.countPathsBottomUp(6, 6);
        
        System.out.println("Number of unique paths via plain recursion: " + result1);
        System.out.println("Number of unique paths via Bottom Up: " + result2);  
    }
}
