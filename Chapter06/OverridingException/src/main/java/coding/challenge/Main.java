package coding.challenge;

import java.sql.BatchUpdateException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        Parent p = new Parent();
        Child c = new Child();

        try {
            p.foo();
        } catch (SQLException ex) {
            System.err.println(ex);
        }

        System.out.println();
        
        try {
            c.foo();
        } catch (BatchUpdateException ex) {
            System.err.println(ex);
        }
        
        System.out.println();

        p.buzz();
        
        System.out.println();

        try {
            c.buzz();
        } catch (RuntimeException ex) {
            System.err.println(ex);
        }
    }
}
