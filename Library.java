import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Book class to represent individual books
class Book {
    private String title;
    private String author;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Override toString() method for easy display
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author;
    }
}

// Library class to represent the library
class Library {
    private String name;
    private List<Book> books;

    // Constructor
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    // Method to add a new book
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to search for a book by title
    public List<Book> searchByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    // Method to search for a book by author
    public List<Book> searchByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    // Method to display all books in the library
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    // Main method to test the Library class
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library("City Library");

        while (true) {
            System.out.println("Library Menu:");
            System.out.println("1. Add a new book");
            System.out.println("2. Search for a book by title");
            System.out.println("3. Search for a book by author");
            System.out.println("4. Display all books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the title of the book: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter the author of the book: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(title, author));
                    break;
                case 2:
                    System.out.print("Enter the title to search: ");
                    String searchTitle = scanner.nextLine();
                    List<Book> booksByTitle = library.searchByTitle(searchTitle);
                    if (booksByTitle.isEmpty()) {
                        System.out.println("No books found with the title: " + searchTitle);
                    } else {
                        for (Book book : booksByTitle) {
                            System.out.println(book);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter the author to search: ");
                    String searchAuthor = scanner.nextLine();
                    List<Book> booksByAuthor = library.searchByAuthor(searchAuthor);
                    if (booksByAuthor.isEmpty()) {
                        System.out.println("No books found by the author: " + searchAuthor);
                    } else {
                        for (Book book : booksByAuthor) {
                            System.out.println(book);
                        }
                    }
                    break;
                case 4:
                    library.displayAllBooks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
