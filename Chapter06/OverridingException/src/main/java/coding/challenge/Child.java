package coding.challenge;

import java.sql.BatchUpdateException;

public class Child extends Parent {

    // BatchUpdateException is subclass of SQLException      
    // of course, we can throw SQLException as well or other subclass of it
    @Override
    public void foo() throws BatchUpdateException { 
        System.out.println("Executing Child#foo() that throws BatchUpdateException");
        throw new BatchUpdateException("Child#foo() did this!", new int[0]);
    }        

    // we can throw and RuntimeException
    @Override
    public void buzz() {
        throw new RuntimeException("Child#buzz() did this!");
    }        
}
