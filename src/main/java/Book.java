import java.lang.reflect.Field;

public class Book {
    @ISBN
    private String ISBN;
    private String id;
    @BookInfo
    private String title;
    @BookInfo
    private String author;

    public Book(String ISBN, String id, String title, String author) {
        this.ISBN = ISBN;
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Book(String ISBN) {
        this.ISBN = ISBN;
    }
    public String getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
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

    @Override
    public String toString() {
        StringBuilder bookInfo = new StringBuilder();
        Field[] fields = this.getClass().getDeclaredFields();

        for(Field field: fields) {
            try {
                bookInfo.append(field.getName()).append(": ").append(field.get(this)).append("\n");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

        }
        return bookInfo.toString();
    }
}
