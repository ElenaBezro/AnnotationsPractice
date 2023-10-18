import java.util.*;

//Create a class named Library that will have the following collections:
//ArrayList<Book> books: To store a list of books.
//HashMap<Integer, Book> bookMap: To store books with their id as the key.
//HashSet<Book> favoriteBooks: To store a list of favorite books.
//
//Implement the following methods in the Library class:
//addBook(Book book): Add a book to the books collection.
//findBookById(int id): Find and return a book by its id.
//removeBook(Book book): Remove a book from the books collection.
//addBookToFavorites(Book book): Add a book to the favoriteBooks collection.
//removeBookFromFavorites(Book book): Remove a book from the favoriteBooks collection.
//Implement a method to search for books by the author's name and display the results.
//Implement a method to search for books by title and display the results.
//In the Library class, implement a method called displayBooks() that will display the details of all books in the books collection.
//In the Library class, implement a method called displayFavorites() that will display the details of all books in the favoriteBooks collection.
public class Library {
    private List<Book> bookList = new ArrayList<>();
    private Set<Book> favoriteBooks = new HashSet<>();
    private Map<String, Book> bookMap = new HashMap<>();
    private Set<Member> memberSet = new HashSet<>();

    public void addBook(Book book) {
        bookList.add(book);
        bookMap.put(book.getId(), book);
    }

    public Book findBookById(String id) {
        //return bookMap.get(id);
        for (Book book : bookList) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public void removeBook(Book bookToRemove) {
        bookList.remove(bookToRemove);
        bookMap.remove(bookToRemove.getId());
        favoriteBooks.remove(bookToRemove);
    }

    public void addBookToFavorites(Book book) {
        favoriteBooks.add(book);
    }

    public void removeBookFromFavorites(Book book) {
        favoriteBooks.remove(book);
    }

    public List<Book> searchBooksByAuthor(String author) {
        List<Book> books = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book);
                books.add(book);
            }
        }
        return books;
    }

    public void searchBooksByTitle(String title) {
        for (Book book : bookList) {
            if (book.getTitle().equals(title)) {
                System.out.println(book);
            }
        }
    }

    public void displayBooks() {
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    public void displayFavorites() {
        for (Book book : favoriteBooks) {
            System.out.println(book);
        }
    }

    public Member searchMemberById(String id) {
        for (Member member : memberSet) {
            if (member.getId().equals(id)) {
                return member;
            }
        }
        return null;
    }
}
