package coding.challenge.connection.test;
 
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SuiteDisplayName("TEST CONNECTION")
@SelectClasses({
    TestConnect.class, 
    TestHeartbeat.class, 
    TestDisconnect.class
})
public class TestConnectionSuite {
    // this class was intentionally left empty
}
