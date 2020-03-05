package coding.challenge;

public class Main {

    public static void main(String[] args) {

        MyQueue<Integer> stack = new MyQueue();

        stack.enqueue(25);
        stack.enqueue(35);
        stack.enqueue(15);

        System.out.println("Size: " + stack.size());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.size());
        System.out.println("Pop: " + stack.dequeue());
        System.out.println("Size: " + stack.size());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.size());
        System.out.println("Push 17");
        stack.enqueue(17);
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.size());
        System.out.println("Pop: " + stack.dequeue());
        System.out.println("Size: " + stack.size());
        System.out.println("Pop: " + stack.dequeue());
        System.out.println("Size: " + stack.size());
        System.out.println("Push 55");
        stack.enqueue(55);
        System.out.println("Size: " + stack.size());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.size());
        System.out.println("Pop: " + stack.dequeue());
        System.out.println("Size: " + stack.size());
        System.out.println("Pop: " + stack.dequeue());
        System.out.println("Size: " + stack.size());
        System.out.println("Is empty? " + stack.isEmpty());
    }

}
