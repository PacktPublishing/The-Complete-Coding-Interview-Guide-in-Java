package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

        int[] dist = {5, 4, 6, 3, 5, 7};
        int[] fuel = {3, 3, 5, 5, 6, 8};

        int startPoint = Bunks.circularTour(fuel, dist);
        System.out.println("Start point: " + startPoint);
    }

}
