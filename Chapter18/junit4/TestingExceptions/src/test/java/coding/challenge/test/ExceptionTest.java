package coding.challenge.test;
 
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ExceptionTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    // Try/Catch Idiom
    @Test
    public void givenStreamWhenGetThenException1() {

        Stream<Integer> theStream = Stream.of();

        try {
            theStream.findAny().get();
            fail("Expected an java.util.NoSuchElementException to be thrown");
        } catch (NoSuchElementException ex) {
            assertThat(ex.getMessage(), is("No value present"));
        }
    }

    // @Test(expected=...)    
    @Test(expected = NoSuchElementException.class)
    public void givenStreamWhenGetThenException2() {

        Stream<Integer> theStream = Stream.of();

        theStream.findAny().get();
    }

    // @Rule
    @Test
    public void givenStreamWhenGetThenException3() throws NoSuchElementException {

        Stream<Integer> theStream = Stream.of();

        thrown.expect(NoSuchElementException.class);
        thrown.expectMessage("No value present");

        theStream.findAny().get();
    }
}
