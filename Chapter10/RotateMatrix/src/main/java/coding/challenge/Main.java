package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

        int s = 5;

        // three identical matrix
        int[][] m1 = new int[s][s]; // used to call rotateInNew()       
        int[][] m2 = new int[s][s]; // used to call rotateWithTranspose()        
        int[][] m3 = new int[s][s]; // used to call rotateRing()        

        // initialize matrix with number 0, 1, 2, ... ,(s-1)
        int v = 0;
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                m1[i][j] = ++v;
                m2[i][j] = m1[i][j];
                m3[i][j] = m1[i][j];
            }
        }

        System.out.println("Initial matrix:");
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                System.out.format("%4s", m1[i][j]);
            }
            System.out.println();
        }

        System.out.println();
        int[][] result = Arrays.rotateInNew(m1);
        System.out.println("Rotated counterclockwise by 90 degrees via new matrix:");
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                System.out.format("%4s", result[i][j]);
            }
            System.out.println();
        }

        System.out.println();        
        Arrays.rotateWithTranspose(m2);       
        System.out.println("Rotated counterclockwise by 90 degrees via transpose:");
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                System.out.format("%4s", m2[i][j]);
            }
            System.out.println();
        }

        System.out.println();         
        Arrays.rotateRing(m3);
        System.out.println("Rotated counterclockwise by 90 degrees ring by ring:");
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                System.out.format("%4s", m3[i][j]);
            }
            System.out.println();
        }
    }
}
