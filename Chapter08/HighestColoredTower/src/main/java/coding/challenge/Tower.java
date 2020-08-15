package coding.challenge;
 
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class Tower {

    private Tower() {
        throw new AssertionError("Cannot be instantiated");
    }

    // plain recursion
    public static int build(List<Box> boxes) {

        if (boxes == null) {
            return -1;
        }

        // sorting boxes by width (you can do it by height as well)
        Collections.sort(boxes, new Comparator<Box>() {
            @Override
            public int compare(Box b1, Box b2) {
                return Integer.compare(b2.getWidth(), b1.getWidth());
            }
        });

        // the boxes after sorting them descending by width
        boxes.forEach(System.out::println);

        // place each box as the base (bottom box) and
        // try to arrange the rest of the boxes
        int highest = 0;
        for (int i = 0; i < boxes.size(); i++) {
            int height = build(boxes, i);

            highest = Math.max(highest, height);
        }

        return highest;
    }

    // plain recursion
    private static int build(List<Box> boxes, int base) {

        Box current = boxes.get(base);

        int highest = 0;
        // since the boxes are sorted we don't look in [0, base + 1)
        for (int i = base + 1; i < boxes.size(); i++) {
            if (boxes.get(i).canBeNext(current)) {

                int height = build(boxes, i);
                highest = Math.max(height, highest);
            }
        }

        highest = highest + current.getHeight();

        return highest;
    }

    // Memoization
    public static int buildViaMemoization(List<Box> boxes) {

        if (boxes == null) {
            return -1;
        }

        // sorting boxes by width (you can do it by height as well)
        Collections.sort(boxes, new Comparator<Box>() {
            @Override
            public int compare(Box b1, Box b2) {
                return Integer.compare(b2.getWidth(), b1.getWidth());
            }
        });

        // the boxes after sorting them descending by width
        boxes.forEach(System.out::println);

        // place each box as the base (bottom box) and
        // try to arrange the rest of the boxes
        int highest = 0;
        int[] cache = new int[boxes.size()];
        for (int i = 0; i < boxes.size(); i++) {
            int height = buildMemoization(boxes, i, cache);

            highest = Math.max(highest, height);
        }

        return highest;
    }

    // Memoization
    private static int buildMemoization(List<Box> boxes, int base, int[] cache) {

        if (base < boxes.size() && cache[base] > 0) {
            return cache[base];
        }

        Box current = boxes.get(base);

        int highest = 0;
        // since the boxes are sorted we don't look in [0, base + 1)
        for (int i = base + 1; i < boxes.size(); i++) {
            if (boxes.get(i).canBeNext(current)) {

                int height = buildMemoization(boxes, i, cache);
                highest = Math.max(height, highest);
            }
        }

        highest = highest + current.getHeight();
        cache[base] = highest;

        return highest;
    }
}
