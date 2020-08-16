package coding.challenge.test;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DynamicTest;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class ExampleOfDynamicTest {

    @TestFactory
    Stream<DynamicTest> dynamicTestsExample() {

        List<Integer> items = Arrays.asList(1, 2, 3, 4, 5);

        List<DynamicTest> dynamicTests = new ArrayList<>();

        for (int item : items) {
            DynamicTest dynamicTest = dynamicTest(
                    "pow(" + item + ", 2):", () -> {
                        assertEquals(item * item, Math.pow(item, 2));
                    });

            dynamicTests.add(dynamicTest);
        }

        return dynamicTests.stream();
    }
}
