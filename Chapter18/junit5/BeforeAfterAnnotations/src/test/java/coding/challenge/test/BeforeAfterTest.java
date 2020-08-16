package coding.challenge.test;
 
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class BeforeAfterTest {

    private static final Logger log = Logger.getLogger(BeforeAfterTest.class.getName());

    @BeforeAll
    public static void setup() {
        log.info("Run only once before running all tests (allocate global resources)");
    }

    @AfterAll
    public static void tearDown() {
        log.info("Run only once after running all tests (release global resources)");
    }

    @BeforeEach
    public void init() {
        log.info("Run before each test (init test)");
    }

    @AfterEach
    public void done() {
        log.info("Run after each test (cleanup after test)");
    }

    @Test
    public void test1() {
        log.info("Execute test1() ...");
    }

    @Test
    public void test2() {
        log.info("Execute test2() ...");
    }

    @Test
    public void test3() {
        log.info("Execute test3() ...");
    }
}
