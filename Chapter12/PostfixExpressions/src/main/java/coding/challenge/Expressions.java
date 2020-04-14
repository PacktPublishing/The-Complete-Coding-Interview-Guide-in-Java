package coding.challenge;

import java.util.Stack;

public class Expressions {

    private Expressions() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static double evaluate(double a, double b, char operator) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return b - a;
            case '*':
                return a * b;
            case '/':
                if (a == 0) {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                }
                return b / a;
        }
        
        return 0.0;
    }

    public static double convert(String expression) {

        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            //check if it is a space (separator)
            if (Character.isWhitespace(c)) {
                continue;
            }

            if (c == '*' || c == '/' || c == '^' || c == '+' || c == '-') {
                double s1 = stack.pop();
                double s2 = stack.pop();
                double temp = evaluate(s1, s2, c);
                stack.push(temp);
            } else {
                
                double num = 0;

                while (Character.isDigit(c)) {
                    num = num * 10 + (c - '0');
                    i++;
                    c = expression.charAt(i);
                }
                
                i--;
                
                //push the number in stack
                stack.push(num);
            }
        }
        
        double result = stack.pop();
        
        return result;
    }
}
