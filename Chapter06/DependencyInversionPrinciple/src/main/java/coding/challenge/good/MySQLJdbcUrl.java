package coding.challenge.good;

public class MySQLJdbcUrl implements JdbcUrl {

    private final String dbName;

    public MySQLJdbcUrl(String dbName) {
        this.dbName = dbName;
    }

    @Override
    public String get() {
        return "jdbc:mysql:// ... " + this.dbName;
    }
}
