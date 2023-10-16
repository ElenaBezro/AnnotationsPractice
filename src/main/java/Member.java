import java.util.ArrayList;
import java.util.List;

public class Member {
    private List<Book> books = new ArrayList<>();
    @Email
    private String email;
    private String id;
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @ValidateUser(maximumBooks = 5, minimumAge = 18)
    public void borrowBook(Book book) {
        books.add(book);
    }
    public int getBooksCount() {
        return books.size();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
