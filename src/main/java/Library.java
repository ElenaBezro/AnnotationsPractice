import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

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

    //implement next methods using Streams
    //a  Find the total number of books in the list.
    public int getTotalNumberOfBooks() {
        return bookList.stream().mapToInt(e -> 1).sum();
    }


    //b. Find the average price of the books.
    public double getAveragePrice() {
        return bookList
                .stream()
                .mapToDouble(book -> book.getPrice())
                .average()
                .orElse(0);

    }

    //c. Find the most expensive book.
    public Book getMostExpensiveBook() {
        return bookList.stream()
                .max(Comparator.comparingDouble(Book::getPrice))
                .orElse(null);
    }

    //d. Find the books published in the last 5 years (current year - 5).
    public List<Book> getPublishedLastFiveYearsBooks() {
        int years = 5;
        int currentYear = LocalDate.now().getYear();
        return bookList
                .stream()
                .filter(book -> book.getPublicationYear() > currentYear - years)
                .toList();
    }

    //e. Create a map of authors to the list of books they have written.
    public Map<String, List<Book>> authorToBooksMap() {
        Map<String, List<Book>> authorToBooksMap = new HashMap<>();
        //or
//        return bookList.stream()
//                .collect(Collectors.groupingBy(Book::getAuthor));

        Set<String> authors = bookList
                .stream()
                .map(book -> book.getAuthor())
                .collect(Collectors.toSet());
        authors.stream().forEach(author -> {
            List<Book> booksByAuthor = bookList
                    .stream()
                    .filter(book -> book.getAuthor().equals(author))
                    .toList();
            authorToBooksMap.put(author, booksByAuthor);
        });
        return authorToBooksMap;
    }

    //f. Find the author with the most books in the list.
    public String getAuthorWithMostBooks() {
        Map<String, Integer> authorToBooksCountMap = new HashMap<>();

        bookList.stream().forEach(book -> {
            authorToBooksCountMap.put(book.getAuthor(), authorToBooksCountMap.getOrDefault(book.getAuthor(), 0) + 1);
        });
        //or:
        //Map<String, Long> authorToBooksCountMap = bookList.stream()
        //            .collect(Collectors.groupingBy(Book::getAuthor, Collectors.counting()));

        String authorWithMostBooks = authorToBooksCountMap
                .entrySet()
                .stream()
                .max((entry1, entry2) -> Integer.compare(entry1.getValue(), entry2.getValue()))
                .get()
                .getKey();
        return authorWithMostBooks;
    }


    //g. Find the number of books with titles starting with the letter 'A'.
    public long getBooksStartsFromACount() {
        return bookList
                .stream()
                .filter(book -> book.getTitle().startsWith("A"))
                .count();
    }
//h. Sort the books by price in descending order and display the top 5 most expensive books.

    public void displayMostExpensiveBooks() {
        int booksCountToDisplay = 5;
        bookList
                .stream()
                .sorted(Comparator.comparingDouble(Book::getPrice).reversed())
                .limit(booksCountToDisplay)
                .forEach(book -> System.out.println(book));
    }

    //i. Group the books by the decade of their publication year (e.g., 2000-2009, 2010-2019) and count the number of books in each decade.

    public Map<String, Integer> groupBooksByDecadeOfPublication() {
        Map<String, Integer> decadeToBookCountMap = new HashMap<>();

        bookList
                .stream()
                .forEach(book -> {
                    int startYear = (book.getPublicationYear() / 10) * 10;
                    int endYear = startYear + 9;
                    String decade = startYear + "-" + endYear;
                    decadeToBookCountMap.put(decade, decadeToBookCountMap.getOrDefault(decade, 0) + 1);
                });
        return decadeToBookCountMap;
    }
}
