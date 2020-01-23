package coding.challenge;

public class Main {

    public static void main(String[] args) {

        System.out.println("\nApproach that doesn't follow ISP:\n");

        coding.challenge.bad.WwwPingConnection www1
                = new coding.challenge.bad.WwwPingConnection("www.yahoo.com");
        
        www1.http();
        www1.socket(); // this method doesn't do anything, but the client doesn't know that
        www1.connect();

        System.out.println("\nApproach that follow ISP:\n");

        coding.challenge.good.WwwPingConnection www2
                = new coding.challenge.good.WwwPingConnection("www.yahoo.com");
        
        www2.http();
        www2.connect();
    }
}
