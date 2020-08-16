package coding.challenge.test;
 
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    TestConnect.class,
    TestHeartbeat.class,
    TestDisconnect.class
})
public class TestSuite {
    // this class was intentionally left empty
}
