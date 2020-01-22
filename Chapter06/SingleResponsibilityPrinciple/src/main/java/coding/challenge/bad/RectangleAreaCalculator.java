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
    
    // this method is against SRP, because now this class does two things
    // it acts as an area calculator and as an area converter as well
    // so, we have two reasons to modify it
    public double metersToInches(int area) {
        return area / INCH_TERM;
    }
    
}
