package coding.challenge;

public class Main {

    public static void main(String[] args) {

        MagicIndex mi = new MagicIndex();
        int[] arr = new int[]{1, 2, 2, 2, 2 ,2 , 2, 4, 5, 6, 6, 7, 9};
        int resultIndex = mi.findMagicIndex(arr);
        
        System.out.println("Index " + resultIndex + " has value " + arr[resultIndex]);        
    }

}
