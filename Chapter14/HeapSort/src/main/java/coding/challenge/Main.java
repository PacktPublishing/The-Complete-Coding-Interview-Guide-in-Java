package coding.challenge;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        Comparator<Melon> byType = Comparator.comparing(Melon::getType);

        // initialize an array integers        
        int[] integers = {4, 5, 2, 7, 1};

        // initialize an array of Melons
        Melon[] melons = {new Melon("Watermelon", 3300), new Melon("Cantaloupe", 4500), 
            new Melon("Cantaloupe", 2500), new Melon("Canary", 4300), new Melon("Crenshaw", 6300)};

        System.out.println("\n\nSort via Heap sort:");
        System.out.println("----------------------");

        System.out.println("\nSorting numbers ...");
        HeapSort.sort(integers);
        System.out.println("Sorted: " + Arrays.toString(integers));

        System.out.println("\nSorting melons by type ...");       
        HeapSort.sortWithComparator(melons, byType);
        System.out.println("Sorted: " + Arrays.toString(melons));
    }
}
