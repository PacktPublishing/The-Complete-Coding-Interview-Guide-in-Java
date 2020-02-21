package coding.challenge;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        char[] str = "  String   with spaces  ".toCharArray();                

        System.out.println("Before: " + Arrays.toString(str));        
        
        char[] result = Strings.encodeWhitespaces(str);
        
        System.out.println("After: " + Arrays.toString(result));        
    }

}
