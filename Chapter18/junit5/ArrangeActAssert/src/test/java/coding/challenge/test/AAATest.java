package coding.challenge.test;
 
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
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
