package coding.challenge;

public class Foo {

    public void foozzy(String p, int q) {
        System.out.println("Called foozzy(" + p + ", " + q + ")");
    }

    // different number of arguments
    public void foozzy(String p, int q, int w) {
        System.out.println("Called foozzy(" + p + ", " + q + ", " + w + ")");
    }
    
    // different order of arguments
    public void foozzy(int q, String p) {
        System.out.println("Called foozzy(" + q + ", " + p + ")");
    }
    
    // different types of arguments
    public void foozzy(int p, int q) {
        System.out.println("Called foozzy(" + p + ", " + q + ")");
    }
    
    // not valid - different return type
    /* 
    public boolean foozzy(String p, int q) {
        System.out.println("Called foozzy(" + p + ", " + q + ")");
    }
    */
}
