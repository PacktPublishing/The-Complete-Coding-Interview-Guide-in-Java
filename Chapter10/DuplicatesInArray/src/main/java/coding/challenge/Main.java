package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

        int[] arr = {4, 0, 5, 3, 1, 2, 3};
        
        boolean r1 = Arrays.checkDuplicates1(arr);
        boolean r2 = Arrays.checkDuplicates2(arr);
        boolean r3 = Arrays.checkDuplicates3(arr);
        boolean r4 = Arrays.checkDuplicates4(arr);
        boolean r5 = Arrays.checkDuplicates5(arr);
        boolean r6 = Arrays.checkDuplicates6(arr);        
        
        System.out.println("r1: " + r1);
        System.out.println("r2: " + r2);
        System.out.println("r3: " + r3);
        System.out.println("r4: " + r4);
        System.out.println("r5: " + r5);

        System.out.println("r6: " + r6);
    }

}

