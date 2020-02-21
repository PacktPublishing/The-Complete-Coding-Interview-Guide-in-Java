package coding.challenge;

public class Main {

    public static void main(String[] args) {

        String text = "a b c d e f";
        String unicode = "豈 更 車  賈 滑 更"; // 更 is repeated

        boolean resultText = Strings.isUnique(text);
        boolean resultUnicode = Strings.isUnique(unicode);
              
        System.out.println("ASCII text has unique characters? " + resultText);
        System.out.println("Unicode text has unique characters? " + resultUnicode);
    }

}
