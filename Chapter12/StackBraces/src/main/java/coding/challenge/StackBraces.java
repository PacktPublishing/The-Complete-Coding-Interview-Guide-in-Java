package coding.challenge;
 
import java.util.Stack;

public final class StackBraces {

    private StackBraces() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static boolean bracesMatching(String bracesStr) {

        if (bracesStr == null || bracesStr.isBlank()) {
            return false;
        }

        Stack<Character> stackBraces = new Stack<>();

        int len = bracesStr.length();
        for (int i = 0; i < len; i++) {
            
            switch (bracesStr.charAt(i)) {
                case '{':
                    stackBraces.push(bracesStr.charAt(i));
                    break;

                case '}':
                    if (stackBraces.isEmpty()) { // we found a mismatch
                        return false; 
                    }
                    
                    stackBraces.pop(); // for every match we pop the corresponding '{'
                    break;

                default:
                    return false;
            }
        }
        
        return stackBraces.empty();
    }
}
