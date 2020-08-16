package coding.challenge.connection.test;
 
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class TestDisconnect {

    private static final Logger log = Logger.getLogger(TestDisconnect.class.getName());

    @Test
    public void givenConnectionWhenDisconnectThenSuccess() {
        log.info("Disconnect successfully complete ...");
    }
}
