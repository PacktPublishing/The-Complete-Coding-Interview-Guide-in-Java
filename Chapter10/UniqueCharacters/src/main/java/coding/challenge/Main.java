package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

        String text = "a b c d";
        String unicode = "豈 更 車 賈 滑 更"; // 更 is repeated
        String mixed = "a 豈 b 更 ￦";

        boolean resultText = Strings.isUnique(text);
        boolean resultUnicode = Strings.isUnique(unicode);
        boolean resultMixed = Strings.isUnique(mixed);

        System.out.println("ASCII text has unique characters? " + resultText);
        System.out.println("Unicode text has unique characters? " + resultUnicode);
        System.out.println("Mixed text has unique characters? " + resultMixed);
    }

}
