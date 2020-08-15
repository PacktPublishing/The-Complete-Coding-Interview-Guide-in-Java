package coding.challenge;
 
import coding.challenge.reader.Book;
import coding.challenge.reader.OnlineReaderSystem;
import coding.challenge.reader.Reader;

public class Main {

    public static void main(String[] args) {

        Reader r = new Reader("Mark Janel", "markjanel@gmail.com");
        Book b = new Book("Olivia Goy", "Carrie", "ISBN:001-OG");

        OnlineReaderSystem ors = new OnlineReaderSystem();

        ors.addReader(r);
        ors.addBook(b);

        ors.displayReader(r.getEmail());
        ors.displayBook(b);

        ors.nextPage();
        ors.nextPage();
        ors.nextPage();
        ors.previousPage();
    }

}
