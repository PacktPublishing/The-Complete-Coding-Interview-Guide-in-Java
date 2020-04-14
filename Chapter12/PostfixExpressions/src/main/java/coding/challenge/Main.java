package coding.challenge;

public class Main {

    public static void main(String[] args) {

        // ((3 + 4) * 2) / 7 = 2
        String exp = "3 4 + 2 * 7 /";
        System.out.println("Postfix Expression: " + exp);
        System.out.println("Evaluation: " + Expressions.convert(exp));
    }
}
