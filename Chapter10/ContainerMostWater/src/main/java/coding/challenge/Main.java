package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

        int[] heights = {1, 4, 6, 2, 7, 3, 8, 5, 3};

        int max1 = Containers.maxArea(heights);
        int max2 = Containers.maxAreaOptimized(heights);
        
        System.out.println("Result 1: " + max1);
        System.out.println("Result 2: " + max2);
    }

}
