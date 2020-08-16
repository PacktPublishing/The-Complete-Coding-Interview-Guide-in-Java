package coding.challenge;
 
import java.awt.Point;

public class Main {

    public static void main(String[] args) {

        Point r1lt = new Point(1, 8);
        Point r1rb = new Point(5, 6);

        Point r2lt = new Point(3, 7);
        Point r2rb = new Point(6, 5);

        boolean result1 = Rectangles.overlap1(r1lt, r1rb, r2lt, r2rb);
        boolean result2 = Rectangles.overlap2(r1lt, r1rb, r2lt, r2rb);
        System.out.println("Result: " + result1 + "  |  " + result2);
    }
}
