package coding.challenge;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        char[] musicalScore = new char[]{'\uD83C', '\uDFBC'}; // code point: 127932 (57276)
        char[] smileyFace = new char[]{'\uD83D', '\uDE0D'};   // code point: 128525 (56845)
        char[] twoHearts = new char[]{'\uD83D', '\uDC95'};    // code point: 128149 (56469)
        char[] cyrillicZhe = new char[]{'\u04DC'};            // code point: 1244

        String str = "is" + String.valueOf(cyrillicZhe) + "zhe"
                + String.valueOf(twoHearts) + "two hearts"
                + String.valueOf(smileyFace) + "smiley face and, "
                + String.valueOf(musicalScore) + "musical score";

        List<Integer> result = Strings.extract(str);
        
        System.out.println("The extracted surrogate pairs have the following code points:");
        System.out.println(result);
    }

}
