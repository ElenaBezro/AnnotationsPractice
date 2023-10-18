import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//Create a Main class with a main method to test the Library class and its functionality. You should perform the following actions:
//Create several Book objects.
//Add these books to the library using the addBook method.
//Add some books to the favoriteBooks collection.
//Display the list of books and favorite books using the displayBooks and displayFavorites methods.
//Find a book by its id using the findBookById method.
//Remove a book from the library and from the favorites list using the removeBook and removeBookFromFavorites methods.
//Search for books by author
//Search for books by title
//Display the updated lists of books and favorite books.
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
        Book book1 = new Book("123455", "123", "Book title1", "Book Author1");
        Book book2 = new Book("123455", "100", "Book title2", "Book Author1");
        Book book3 = new Book("123455", "101", "Book title3", "Book Author1");
        Book book4 = new Book("123455", "102", "Book title4", "Book Author4");
        //Collections task (Day 2)
        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        library.addBookToFavorites(book2);
        library.addBookToFavorites(book4);

        library.displayBooks();
        library.displayFavorites();

        System.out.println(library.findBookById("101"));

        library.removeBook(book2);
        library.displayBooks();
        library.displayFavorites();

        library.searchBooksByAuthor("Book Author1");




        //Annotation task (Day 1)
        isISBNValid(book1);

        Member member = new Member();
        member.setEmail("info@mail.com");
        isEmailValid(member);

        member.setAge(18);
        borrowBook(member, book1);

        Inventory inventory = new Inventory();
        inventory.addBook(book1);
        isAvailable(inventory, "12");
        isAvailable(inventory, "123455");
    }
}
