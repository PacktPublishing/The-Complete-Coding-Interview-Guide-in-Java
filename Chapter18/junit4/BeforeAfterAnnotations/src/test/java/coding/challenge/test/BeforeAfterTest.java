package coding.challenge.test;
 
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BeforeAfterTest {

    private static final Logger log = Logger.getLogger(BeforeAfterTest.class.getName());

    @BeforeClass
    public static void setup() {
        log.info("Run only once before running all tests (allocate global resources)");
    }

    @AfterClass
    public static void tearDown() {
        log.info("Run only once after running all tests (release global resources)");
    }

    @Before
    public void init() {
        log.info("Run before each test (init test)");
    }

    @After
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
