package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

        String str1 = "helloworld";
        String str2 = "orldhellow";

        System.out.println("'" + str1 + "' is rotation of '" 
                + str2 + "': " + Strings.isRotation(str1, str2));
    }

}
