package coding.challenge.test;
 
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class ExceptionTest {

    @Test
    public void givenStreamWhenGetThenException1() {

        assertThrows(NoSuchElementException.class, () -> {
            Stream<Integer> theStream = Stream.of();
            theStream.findAny().get();
        });
    }

    @Test
    public void givenStreamWhenGetThenException2() {

        Throwable ex = assertThrows(NoSuchElementException.class, () -> {
            Stream<Integer> theStream = Stream.of();
            theStream.findAny().get();
        });

        assertEquals(ex.getMessage(), "No value present");
    }
}
