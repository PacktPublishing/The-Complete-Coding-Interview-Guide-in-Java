package coding.challenge;
 
public class Box {

    private final int width;
    private final int height;
    private final int color;

    public Box(int width, int height, int color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public boolean canBeNext(Box box) {

        if (box == null) {
            return false;
        }

        return ((box.width > this.width) && (box.height > this.height)
                && (box.color != this.color));
    }

    public int getWidth() {
        return width;
    }

    public int getColor() {
        return color;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Box{" + "width=" + width + ", height=" + height + ", color=" + color + '}';
    }

}
