import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Book> books = new ArrayList<>();
    @isAvailable
    public boolean isAvailable(String isbn) {
        for (Book book: books) {
            if (book.getISBN().equals(isbn)) {
                return true;
            }
        }
        return false;
    }

    public void addBook(Book book) {
        books.add(book);
    }

}
