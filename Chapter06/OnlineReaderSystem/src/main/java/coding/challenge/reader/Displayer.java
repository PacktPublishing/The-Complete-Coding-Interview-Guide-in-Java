package coding.challenge.reader;

public class Displayer {
 
    private Book book;
    private Reader reader;
    private String page;
    private int pageNumber;

    protected void displayReader(Reader reader) {
        this.reader = reader;
        refreshReader();
    }
    
    protected void displayBook(Book book) {
        this.book = book;
        refreshBook();
    }
    
    protected void nextPage() {
        page = book.fetchPage(++pageNumber);
        refreshPage();
    }
    
    protected void previousPage() {
        page = book.fetchPage(--pageNumber);        
        refreshPage();
    }        
    
    private void refreshReader() {
        System.out.println("Reader: " + reader.getName());
    }
    
    private void refreshBook() {
        pageNumber = 0;
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());        
    }
    
    private void refreshPage() {
        System.out.println("Reading page: " + pageNumber + " Content: " + page);
    }
}
