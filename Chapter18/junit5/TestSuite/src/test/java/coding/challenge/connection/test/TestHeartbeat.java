package coding.challenge.connection.test;
 
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class TestHeartbeat {

    private static final Logger log = Logger.getLogger(TestHeartbeat.class.getName());

    @Test
    public void givenConnectionWhenHeartbeatThenSuccess() {
        log.info("Heartbeat successfully complete ...");
    }
}
