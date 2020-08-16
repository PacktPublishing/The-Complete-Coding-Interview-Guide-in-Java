package coding.challenge.connection.test;
 
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class TestConnect {

    private static final Logger log = Logger.getLogger(TestConnect.class.getName());

    @Test
    public void givenCredentialsWhenConnectThenSuccess() {
        log.info("Connection successfully complete ...");
    }
}
