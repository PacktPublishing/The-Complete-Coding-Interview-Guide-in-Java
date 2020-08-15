package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

        MyStack stack = new MyStack();

        stack.push(5);
        stack.push(-25);
        stack.push(35);
        stack.push(15);
        System.out.println("Min: " + stack.min());

        stack.push(-1);
        stack.push(-30);
        stack.push(6);
        System.out.println("Min: " + stack.min());

        stack.push(-100);
        System.out.println("Min: " + stack.min());

        stack.pop();
        stack.pop();
        System.out.println("Min (after two pop): " + stack.min());

        stack.pop();
        stack.pop();
        System.out.println("Min (after two pop): " + stack.min());

        stack.pop();
        stack.pop();
        stack.pop();        
        System.out.println("Min (after three pop): " + stack.min());
        
        stack.pop();     
        System.out.println("Min (after two pop): " + stack.min());
    }

}
