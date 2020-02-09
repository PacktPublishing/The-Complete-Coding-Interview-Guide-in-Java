package coding.challenge;

public class Main {

    public static void main(String[] args) {

        MagicIndex mi = new MagicIndex();
        int[] arr = new int[]{1, 4, 4, 4, 5, 5, 6, 6, 6, 11, 12, 12, 12, 15, 17, 20, 21, 21};
        int resultIndex = mi.findMagicIndex(arr);
        
        System.out.println("Index " + resultIndex + " has value " + arr[resultIndex]);        
    }

}
