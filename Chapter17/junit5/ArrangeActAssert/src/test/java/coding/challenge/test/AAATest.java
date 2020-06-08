package coding.challenge.test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
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
