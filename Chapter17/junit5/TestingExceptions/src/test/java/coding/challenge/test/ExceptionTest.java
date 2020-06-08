package coding.challenge.test;

import java.util.NoSuchElementException;
import java.util.stream.Stream;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
