package coding.challenge;

public class Triangle {

    public void draw() {
        System.out.println("Draw default triangle ...");
    }
    
    public void draw(String color) {
        System.out.println("Draw a triangle of color " + color);
    }
    
    public void draw(int size, String color) {
        System.out.println("Draw a triangle of color " 
                + color + " and scale it up with the new size of " + size);
    }
}
