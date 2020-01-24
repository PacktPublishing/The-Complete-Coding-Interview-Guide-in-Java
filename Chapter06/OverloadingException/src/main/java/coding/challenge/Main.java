package coding.challenge;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        Clazz clazz = new Clazz();

        clazz.foo("Foozzy");
        
        System.out.println();

        try {
            clazz.foo();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        
        System.out.println();

        try {
            clazz.foo(1);
        } catch (RuntimeException ex) {
            System.err.println(ex);
        }
    }
}
