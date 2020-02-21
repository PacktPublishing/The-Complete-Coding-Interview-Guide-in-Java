package coding.challenge;

public class Main {

    public static void main(String[] args) {

        String text1 = "a b c d e f g h z q o i";
        String text2 = "a b c d e f g h z q o c";

        boolean resultText1 = Strings.isUnique(text1);
        boolean resultText2 = Strings.isUnique(text2);

        System.out.println("Text1 has unique characters? " + resultText1);
        System.out.println("Text2 has unique characters? " + resultText2);
    }

}
