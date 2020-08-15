package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

        int[] arr = {4, 4, 3, 1, 7, 7, 7, 1, 1, 4};
        
        int result1 = Elements.unique1(arr);
        int result2 = Elements.unique2(arr);
        System.out.println("Result: " + result1 + "  |  " + result2);
    }

}
