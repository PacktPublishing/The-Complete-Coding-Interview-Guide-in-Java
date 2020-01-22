package coding.challenge;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("\nApproach that doesn't follow OCP:\n");
        
        coding.challenge.bad.Circle c1 = new coding.challenge.bad.Circle(4);
        coding.challenge.bad.Circle c2 = new coding.challenge.bad.Circle(3);
        coding.challenge.bad.Rectangle r1 = new coding.challenge.bad.Rectangle(5,3);
        
        List<coding.challenge.bad.Shape> shapes1 = List.of(c1, c2, r1);        

        coding.challenge.bad.AreaCalculator rac1
                = new coding.challenge.bad.AreaCalculator(shapes1);

        System.out.println("Sum area: " + rac1.sum());
        
        System.out.println("\nApproach that follow OCP:\n");
        
        coding.challenge.good.Circle c11 = new coding.challenge.good.Circle(4);
        coding.challenge.good.Circle c21 = new coding.challenge.good.Circle(3);
        coding.challenge.good.Rectangle r11 = new coding.challenge.good.Rectangle(5,3);
        
        List<coding.challenge.good.Shape> shapes2 = List.of(c11, c21, r11);        

        coding.challenge.good.AreaCalculator rac2
                = new coding.challenge.good.AreaCalculator(shapes2);

        System.out.println("Sum area: " + rac2.sum());        
    }
}
