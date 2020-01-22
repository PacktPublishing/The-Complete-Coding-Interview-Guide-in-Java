package coding.challenge.bad;

public class RectangleAreaCalculator {

    private static final double INCH_TERM = 0.0254d;
    
    private final int width;
    private final int height;

    public RectangleAreaCalculator(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    public int area() {
        return width * height;
    }
    
    public double metersToInches(int area) {
        return area / INCH_TERM;
    }
    
}
