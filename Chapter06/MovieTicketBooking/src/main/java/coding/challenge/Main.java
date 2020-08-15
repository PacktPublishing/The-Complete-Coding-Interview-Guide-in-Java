package coding.challenge;
 
public class Main {

    public static void main(String[] args) {
        
        System.out.println("This is the main design (!not implementation!) of a cinema with the following coordinates:");
        System.out.println("\t - multiple cinema rooms (see CinemaRoom)");
        System.out.println("\t - a room has three types of seats (see Seat and SeatType)");
        System.out.println("\t - a movie can run multiple times in a day in the same cinema room");
        System.out.println("\t - a movie can run in multiple cinema rooms in the same time");
        System.out.println("\t - a movie can be added in a certain room at a certain time");
        System.out.println("\t - a movie can be removed from a certain room at a certain time");
        System.out.println("\t - each cinema room holds its schedule");
        System.out.println("\t - the cinema has an automatic ticketing system (see MovieTicketingMachine)");
        System.out.println("\t - the automatic system release tickets (see Movie Ticket)");
    }

}
