package coding.challenge.bad;

public class ConnectToDatabase {

    public void connect(PostgreSQLJdbcUrl postgresql) {
        System.out.println("Connecting to " + postgresql.get());
    }
}
