package coding.challenge;

import java.util.List;

public class Main {

    public static void main(String[] args) {

       Braces braces = new Braces();
       List<String> results = braces.embrace(3);       
       
       System.out.println("Output: " + results);
    }

}
