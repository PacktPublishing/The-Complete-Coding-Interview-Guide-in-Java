package coding.challenge.test;
 
import java.util.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestDisconnect {

    private static final Logger log = Logger.getLogger(TestDisconnect.class.getName());

    @Test
    public void givenConnectionWhenDisconnectThenSuccess() {
        log.info("Disconnect successfully complete ...");
    }
}
