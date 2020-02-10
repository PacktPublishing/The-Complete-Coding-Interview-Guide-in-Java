package coding.challenge;

import java.util.ArrayList;
import java.util.List;

public class Braces {

    public List<String> embrace(int nr) {

        List<String> results = new ArrayList<>();
        embrace(nr, nr, new char[nr * 2], 0, results);

        return results;
    }

    public void embrace(int leftHand, int rightHand, 
            char[] str, int index, List<String> results) {

        if (rightHand < leftHand || leftHand < 0) {
            return;
        }

        if (leftHand == 0 && rightHand == 0) {
            // result found, so store it
            results.add(String.valueOf(str));
        } else {
            // Add left brace
            str[index] = '{';
            embrace(leftHand - 1, rightHand, str, index + 1, results);

            // Add right brace
            str[index] = '}';
            embrace(leftHand, rightHand - 1, str, index + 1, results);
        }
    }
}
