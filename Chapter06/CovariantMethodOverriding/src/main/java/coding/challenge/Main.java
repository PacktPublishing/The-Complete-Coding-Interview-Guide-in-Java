package coding.challenge;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        Rectangle r = new Rectangle(4, 3);
        Rectangle clone = r.clone();

        System.out.println("Width: " + clone.getWidth());
        System.out.println("Height: " + clone.getHeight());
    }
}
