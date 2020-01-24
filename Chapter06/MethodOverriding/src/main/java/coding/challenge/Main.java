package coding.challenge;

import coding.challenge.inheritance.Child;
import coding.challenge.inheritance.Parent;
import coding.challenge.polymorphism.Concrete;

public class Main {

    public static void main(String[] args) {

        // Method overriding in Inheritance
        Parent parent = new Parent();
        Child child = new Child();

        parent.execute();
        child.execute();

        // Method inheritance in Runtime Polymorphism
        Concrete concrete = new Concrete();

        concrete.execute();
    }
}
