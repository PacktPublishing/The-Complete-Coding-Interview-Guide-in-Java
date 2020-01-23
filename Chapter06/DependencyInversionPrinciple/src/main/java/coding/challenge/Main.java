package coding.challenge;

public class Main {

    public static void main(String[] args) {

        System.out.println("\nApproach that doesn't follow DIP:\n");

        coding.challenge.bad.PostgreSQLJdbcUrl p1
                = new coding.challenge.bad.PostgreSQLJdbcUrl("my_db");
        coding.challenge.bad.ConnectToDatabase c1
                = new coding.challenge.bad.ConnectToDatabase();

        c1.connect(p1);

        System.out.println("\nApproach that follow ISP:\n");

        coding.challenge.good.PostgreSQLJdbcUrl p2
                = new coding.challenge.good.PostgreSQLJdbcUrl("my_db");
        coding.challenge.good.MySQLJdbcUrl p3
                = new coding.challenge.good.MySQLJdbcUrl("my_db");
        
        coding.challenge.good.ConnectToDatabase c2
                = new coding.challenge.good.ConnectToDatabase();

        c2.connect(p2);
        c2.connect(p3);
    }
}
