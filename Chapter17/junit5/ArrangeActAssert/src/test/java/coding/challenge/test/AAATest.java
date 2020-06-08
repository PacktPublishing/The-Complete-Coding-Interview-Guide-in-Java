package coding.challenge.test;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AAATest {

    @Test
    public void givenStreamWhenSumThenEquals6() {

        // Arrange
        Stream<Integer> theStream = Stream.of(1, 2, 3);

        // Act
        int sum = theStream.mapToInt(i -> i).sum();

        // Assert
        assertEquals(6, sum);
    }
}
