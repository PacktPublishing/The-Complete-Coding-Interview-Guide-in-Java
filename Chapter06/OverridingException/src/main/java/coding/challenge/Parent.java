package coding.challenge;

import java.sql.SQLException;

public class Parent {

    public void foo() throws SQLException {
        System.out.println("Executing Parent#foo() that throws SQLException");
    }     
    
    public void buzz() {
        System.out.println("Executing Parent#buzz() that doesn't throw any exception");
    }
}
