package coding.challenge;
 
public final class Chocolates {

    private Chocolates() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int breakit(int width, int height, int nTiles) {

        if (width <= 0 || height <= 0 || nTiles <= 0) {
            return -1;
        }

        // Case 1
        if (width * height < nTiles) {
            return -1;
        }

        // Case 4
        if (width * height == nTiles) {
            return 0;
        } 

        // Cases 5 and 6
        if ((nTiles % width == 0 && (nTiles / width) < height)
                || (nTiles % height == 0 && (nTiles / height) < width)) {
            return 1;
        }

        // Case 7
        for (int i = 1; i <= Math.sqrt(nTiles); i++) {
            if (nTiles % i == 0) {
                int a = i;
                int b = nTiles / i;
                if ((a <= width && b <= height)
                        || (a <= height && b <= width)) {
                    return 2;
                }
            }
        }

        // Cases 2 and 3
        return -1;
    }
}
