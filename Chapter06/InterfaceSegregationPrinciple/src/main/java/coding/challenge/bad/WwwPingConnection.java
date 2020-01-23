package coding.challenge.bad;

public class WwwPingConnection implements Connection {

    private final String www;

    public WwwPingConnection(String www) {
        this.www = www;
    }

    @Override
    public void http() {
        System.out.println("Setup an HTTP connection to " + www);
    }

    @Override
    public void connect() {
        System.out.println("Connect to " + www);
    }

    // this implementation breaks Interface Segregation Principle
    // this class doesn't need this method but it is forced to override it
    @Override
    public void socket() {
    }
}
