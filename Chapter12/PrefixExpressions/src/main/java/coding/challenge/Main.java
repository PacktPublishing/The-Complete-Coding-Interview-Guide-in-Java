package coding.challenge;

public class Main {

    public static void main(String[] args) {

        // - * / 15 - 7 + 1 1 3 + 2 + 1 1
        String exp = "- * / 15 - 7 + 1 1 3 + 2 + 1 1";
        System.out.println("Prefix Expression: " + exp);
        System.out.println("Evaluation: " + Expressions.convert(exp));
    }
}
