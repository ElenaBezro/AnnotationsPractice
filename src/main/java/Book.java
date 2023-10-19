import java.lang.reflect.Field;

public class Book implements Comparable {
    @ISBN
    private String ISBN;
    private String id;
    @BookInfo
    private String title;
    @BookInfo
    private String author;
    private int publicationYear;
    private float price;


    public Book(String ISBN, String id, String title, String author, int publicationYear, float price) {
        this.ISBN = ISBN;
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.price = price;
    }


    public Book(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public float getPrice() {
        return price;
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
                bookInfo.append(field.getName()).append(": ").append(field.get(this)).append(", ");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

        }
        return bookInfo.toString();
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Book) {
            return this.getTitle().compareTo(((Book) o).getTitle());
        }
        return 0;
    }
}
