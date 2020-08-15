package coding.challenge.reader;

import java.util.HashMap;
import java.util.Map;
 
public class Library {

    private final Map<String, Book> books = new HashMap<>();

    protected void addBook(Book book) {
        books.putIfAbsent(book.getIsbn(), book);
    }

    protected boolean remove(Book book) {
        return books.remove(book.getIsbn(), book);
    }

    protected Book find(String isbn) {
        return books.get(isbn);
    }
}
