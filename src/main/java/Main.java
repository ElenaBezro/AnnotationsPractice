import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

    public static void isISBNValid(Book book) {
        for (Field field : book.getClass().getDeclaredFields()) {
            Annotation annotation = field.getAnnotation(ISBN.class);
            if (annotation != null && book.getISBN().length() > 5) {
                System.out.println("Valid ISBN");
            } else {
                System.out.println("Invalid ISBN or field does not have ISBN annotation");
            }
        }
    }

    public static void isEmailValid(Member member) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        for (Field field : member.getClass().getDeclaredFields()) {
            Annotation annotation = field.getAnnotation(Email.class);
            if (annotation != null && member.getEmail().matches(regex)) {
                System.out.println("Valid email");
            } else {
                System.out.println("Invalid email or field does not have Email annotation");
            }
        }
    }

    public static void borrowBook(Member member, Book book) {
        for (Method method : member.getClass().getDeclaredMethods()) {
            ValidateUser annotation = method.getAnnotation(ValidateUser.class);
            if (annotation != null) {
                if (member.getBooksCount() > annotation.maximumBooks() || member.getAge() < annotation.minimumAge()) {
                    System.out.println("Invalid operation");
                } else {
                    member.borrowBook(book);
                    System.out.println("Book has been borrowed");
                }
            }
        }
    }

    public static void isAvailable(Inventory inventory, String isbn) {
        for (Method method : inventory.getClass().getDeclaredMethods()) {
            isAvailable annotation = method.getAnnotation(isAvailable.class);
            if (annotation != null) {
                if (inventory.isAvailable(isbn)) {
                    System.out.println("Book is available");
                } else {
                    System.out.println("Book is not available");
                }
            }
        }
    }

    public static void main(String[] args) {
        Book book = new Book("123455");
        isISBNValid(book);

        Member member = new Member();
        member.setEmail("info@mail.com");
        isEmailValid(member);

        member.setAge(18);
        borrowBook(member, book);

        Inventory inventory = new Inventory();
        inventory.addBook(book);
        isAvailable(inventory, "12");
        isAvailable(inventory, "123455");
    }
}
