package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

        MyStack stack = new MyStack();

        stack.push(25);
        stack.push(35);
        stack.push(15);

        System.out.println("Min: " + stack.min());
        
        stack.push(-1);
        stack.push(-3);
        stack.push(6);
        
        System.out.println("Min: " + stack.min());
        
        stack.pop();
        stack.pop();
        
        System.out.println("Min: " + stack.min());        
    }

}
