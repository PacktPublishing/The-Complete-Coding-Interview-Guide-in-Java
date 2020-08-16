package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

        int[][] matrix = {
            {11, 22, 48, 77, 78, 84},
            {12, 24, 55, 78, 83, 90},
            {25, 56, 58, 80, 85, 95},
            {33, 57, 60, 85, 86, 99}
        };

        int elementToFind1 = 80;
        int elementToFind2 = 77;
        int elementToFind3 = 92;

        System.out.println("Iterative approach (" + elementToFind1 + "): "
                + Matrices.search(matrix, elementToFind1));
        System.out.println("Iterative approach (" + elementToFind2 + "): "
                + Matrices.search(matrix, elementToFind2));
        System.out.println("Iterative approach (" + elementToFind3 + "): "
                + Matrices.search(matrix, elementToFind3));

        System.out.println();
        System.out.println();

        System.out.println("Recursive approach (" + elementToFind1 + "): "
                + Matrices.searchRecursive(matrix, elementToFind1));
        System.out.println("Recursive approach (" + elementToFind2 + "): "
                + Matrices.searchRecursive(matrix, elementToFind2));
        System.out.println("Recursive approach (" + elementToFind3 + "): "
                + Matrices.searchRecursive(matrix, elementToFind3));
    }
}
