package coding.challenge;

import java.sql.SQLException;

public class Clazz {

    public void foo(String foozzy) {
        System.out.println("Executing Clazz#foo() that doesn't throw any exception");
    }

    public void foo() throws SQLException {
        System.out.println("Executing Clazz#foo() that throws SQLException");
        throw new SQLException("Cazz#foo() did this!");
    }

    public void foo(int foozzy) {
        System.out.println("Executing Clazz#foo() that throws RuntimeException");
        throw new RuntimeException("Clazz#foo(int foozzy) did this!");
    }
}
