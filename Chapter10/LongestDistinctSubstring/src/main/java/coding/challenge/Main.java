package coding.challenge;

public class Main {

    public static void main(String[] args) {

        String str = "abcc#$%^&ccdbeeebdd012333dbsssbesbaas";

        String result = Strings.longestDistinctSubstring(str);

        System.out.println("String: " + str);
        System.out.println("Result: " + result);
    }

}
