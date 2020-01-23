package coding.challenge;

import coding.challenge.good.AreaConverter;

public class Main {

    public static void main(String[] args) {

        System.out.println("\nApproach that doesn't follow SRP:\n");

        coding.challenge.bad.RectangleAreaCalculator rac1
                = new coding.challenge.bad.RectangleAreaCalculator(4, 2);

        int area1 = rac1.area();
        System.out.println("Area in meters: " + area1);

        System.out.println("Area in inches: " + rac1.metersToInches(area1));

        System.out.println("\nApproach that follow SRP:\n");

        coding.challenge.good.RectangleAreaCalculator rac2
                = new coding.challenge.good.RectangleAreaCalculator(4, 2);

        int area2 = rac2.area();
        System.out.println("Area in meters: " + area2);

        AreaConverter converter = new AreaConverter();

        System.out.println("Area in inches: " + converter.metersToInches(area2));
        System.out.println("Area in feet: " + converter.metersToFeet(area2));
    }
}
