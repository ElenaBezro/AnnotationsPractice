public class Book {
    @ISBN
    private String ISBN;
    private String id;
    @BookInfo
    private String title;
    @BookInfo
    private String author;

    public Book(String ISBN) {
        this.ISBN = ISBN;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
