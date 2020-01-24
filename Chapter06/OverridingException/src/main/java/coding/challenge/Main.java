package coding.challenge;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        Parent p = new Parent();
        Child c = new Child();

        p.foo();
        c.foo();
        p.buzz();

        // pay attention when you run the code
        // this call will cause a RuntimeException
        // this is the exception thrown by Child#buzz()
        c.buzz();
    }
}
