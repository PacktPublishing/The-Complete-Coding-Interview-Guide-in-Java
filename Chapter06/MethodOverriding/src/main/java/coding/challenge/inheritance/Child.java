package coding.challenge.inheritance;

public class Child extends Parent {

    @Override
    public void execute() {
        // super.execute(); - if you want to execute the parent code first
        System.out.println("Execute child code ...");
    }
}
