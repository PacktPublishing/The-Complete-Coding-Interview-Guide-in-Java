package coding.challenge.test;
 
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class NestedTest {

    private static final Logger log = Logger.getLogger(NestedTest.class.getName());

    @BeforeAll
    static void setup() {
        log.info("Run only once before running all tests (allocate global resources)");
    }

    @AfterAll
    static void tearDown() {
        log.info("Run only once after running all tests (release global resources)");
    }

    @BeforeEach
    void init() {
        log.info("Run before each test (init test)");
    }

    @AfterEach
    void done() {
        log.info("Run after each test (cleanup after test)");
    }

    @DisplayName("Test 1 - not nested")
    @Test
    void test1() {
        log.info("Execute test1() ...");
    }

    @Nested
    @DisplayName("Running tests nested in class A")
    class A {

        @BeforeEach
        void beforeEach() {
            System.out.println("Before each test method of the A class");
        }

        @AfterEach
        void afterEach() {
            System.out.println("After each test method of the A class");
        }

        @Test
        @DisplayName("Test2 - nested in class A")
        void test2() {
            log.info("Execute test2() ...");
        }

        @Nested
        @DisplayName("Running tests nested in class B")
        class B {

            @BeforeEach
            void beforeEach() {
                System.out.println("Before each test method of the B class");
            }

            @AfterEach
            void afterEach() {
                System.out.println("After each test method of the B class");
            }

            @Test
            @DisplayName("Test3 - nested in class B")
            void test3() {
                log.info("Execute test3() ...");
            }
        }
    }
}
