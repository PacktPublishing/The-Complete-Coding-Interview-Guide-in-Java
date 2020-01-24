package coding.challenge;

public class Rectangle implements Cloneable {

    private final int height;
    private final int width;

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }        

    @Override
    protected Rectangle clone() throws CloneNotSupportedException {

        Rectangle clone = (Rectangle) super.clone();

        return clone;
    }

}
