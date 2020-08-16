package coding.challenge.test;
 
import java.util.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestConnect {

    private static final Logger log = Logger.getLogger(TestConnect.class.getName());

    @Test
    public void givenCredentialsWhenConnectThenSuccess() {
        log.info("Connection successfully complete ...");
    }
}
