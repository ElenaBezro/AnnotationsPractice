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


//Objective: Create a Java program that uses Java streams to process and analyze data from a list of books.
//
//Instructions:
//
//Create a Book Class:
//
//Create a Book class with attributes like title, author, publication year, and price.
//
//Create a List of Books:
//
//Populate a list with several Book objects.
//Data Analysis with Streams:
//
//a. Find the total number of books in the list.
//
//b. Find the average price of the books.
//
//c. Find the most expensive book.
//
//d. Find the books published in the last 5 years (current year - 5).
//
//e. Create a map of authors to the list of books they have written.
//
//f. Find the author with the most books in the list.
//
//g. Find the number of books with titles starting with the letter 'A'.
//
//h. Sort the books by price in descending order and display the top 5 most expensive books.
//
//i. Group the books by the decade of their publication year (e.g., 2000-2009, 2010-2019) and count the number of books in each decade.
//
//Display the Results:
//
//Display the results of each analysis.
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
        Book book1 = new Book("123455", "123", "A Book title1", "Book Author1", 2018, 5.5f);
        Book book2 = new Book("123455", "100", "Book title2", "Book Author1", 2017, 10f);
        Book book3 = new Book("123455", "101", "Book title3", "Book Author1", 2022, 4.5f);
        Book book4 = new Book("123455", "102", "Book title4", "Book Author2", 1950, 10f);
        Book book5 = new Book("123455", "103", "Book title5", "Book Author3", 2000, 11f);
        Book book6 = new Book("123455", "104", "Book title6", "Book Author4", 2009, 12f);
        Book book7 = new Book("123455", "107", "Book title7", "Book Author4", 2007, 10f);
        //Collections task (Day 2)
        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);
        library.addBook(book7);

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
        System.out.println("*******");
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

        //Streams task (Day 3)
        System.out.println("*******");
        System.out.println("TotalNumberOfBooks " + library.getTotalNumberOfBooks());
        System.out.println("AveragePrice " + library.getAveragePrice());
        System.out.println("MostExpensiveBook " + library.getMostExpensiveBook());
        System.out.println("PublishedLastFiveYearsBooks " + library.getPublishedLastFiveYearsBooks());
        System.out.println("authorToBooksMap " + library.authorToBooksMap());
        System.out.println("AuthorWithMostBooks " + library.getAuthorWithMostBooks());
        System.out.println("BooksStartsFromACount " + library.getBooksStartsFromACount());
        System.out.println("*******");
        System.out.println("displayMostExpensiveBooks ");
        library.displayMostExpensiveBooks();
        System.out.println("groupBooksByDecadeOfPublication " + library.groupBooksByDecadeOfPublication());

    }
}
