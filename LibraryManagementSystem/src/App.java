import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import Authors.Author;
import Authors.AuthorRepoImpl;
import Books.Book;
import Books.BookRepoImpl;
import Books.BookStatus;
import Library.Library;
import Patrons.Patron;
import Patrons.PatronRepoImpl;

public class App {

    public static void main(String[] args) throws Exception {
        Library library = new Library(
            new BookRepoImpl(), 
            new AuthorRepoImpl(), 
            new PatronRepoImpl()
        );

        // Add
        bookList().forEach(book -> library.getBookRepo().add(book));
        authorList().forEach(author -> library.getAuthorRepo().add(author));
        patronList().forEach(patron -> library.getPatronRepo().add(patron));
        System.out.println("Printing total number of library books: " + library.getBookRepo().getBooks().size());
        System.out.println("");
        System.out.println("");
        System.out.println("Printing total number of authors: " +library.getAuthorRepo().getAuthors().size());
        System.out.println("");
        System.out.println("");
        System.out.println("Printing total number of patrons: " +library.getPatronRepo().getPatrons().size());
        System.out.println("");
        System.out.println("");
        System.out.println("");


        // Edit
        System.out.println("Editing Book Status");
        Book editBook = bookList().get(0);
        System.out.println(editBook.toString());
        editBook.setStatus(BookStatus.OVERDUE);
        library.getBookRepo().edit(editBook);
        System.out.println("");
        System.out.println("");

        // Delete
        System.out.println("Deleting a book");
        System.out.println("No of books before delete: " + library.getBookRepo().getBooks().size());
        Book deleteBook = library.getBookRepo().getBooks().get(1);
        library.getBookRepo().delete(deleteBook);
        System.out.println("No of books after delete: " + library.getBookRepo().getBooks().size());
        System.out.println("");
        System.out.println("");

        //Borrow
        System.out.println("Borrowing a book");
        Book borrowBook = library.getBookRepo().getBooks().get(2);
        System.out.println("Book title: " + borrowBook.getTitle());
        System.out.println("Number of copies before borrowing: " + borrowBook.getNoOfCopies());
        library.getBookRepo().booksBorrow(borrowBook, 2);
        System.out.println("Number of copies after borrowing: " + borrowBook.getNoOfCopies());
        System.out.println("");
        System.out.println("");

        //Return
        System.out.println("Returnign a book");
        Book returnBook = library.getBookRepo().getBooks().get(3);
        System.out.println("Book title to be returned: " + returnBook.getTitle());
        System.out.println("Number of copies before returning: " + returnBook.getNoOfCopies());
        library.getBookRepo().booksReturn(returnBook, 1);
        System.out.println("Number of copies after returning: " + returnBook.getNoOfCopies());

        //Search
        Scanner scanner = new Scanner(System.in);
        boolean continueSearch = true;

        while (continueSearch) {
            System.out.print("Do you want to search for a book? Enter Y to search, N to exit: ");
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("N")) {
                continueSearch = false;
                System.out.println("Program exited. Goodbye!");
            } else if (userInput.equalsIgnoreCase("Y")) {
                System.out.println("Enter book title to search: ");
                String bookTitle = scanner.nextLine();
                ArrayList<Book> searchedBookList = library.getBookRepo().search(editBook.getTitle(), editBook.getAuthor(), editBook.getISBN());
                searchedBookList.forEach(book -> System.out.println(book.toString()));
                System.out.println("Searching for books with title: " + bookTitle);
                // Display the searched books
                if (!searchedBookList.isEmpty()) {
                    System.out.println("Found books matching the title:");
                    searchedBookList.forEach(book -> System.out.println(book.toString()));
                } else {
                    System.out.println("No books found with the given title.");
                }
            } else {
                // Handle invalid input
                System.out.println("Invalid input. Please enter Y to search or N to exit.");
            }
        


            scanner.close();
        }


    }

    private static ArrayList<Book> bookList(){
        ArrayList<Book> _bookList = new ArrayList<>();
        Book book1 = new Book("My Sister's Keeper", "Jodi Picoult", "123456", "ABC", 20, BookStatus.AVAILABLE);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "789012", "XYZ", 15, BookStatus.CHECKED_OUT);
        Book book3 = new Book("1984", "George Orwell", "345678", "PQR", 25, BookStatus.AVAILABLE);
        Book book4 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "901234", "LMN", 18, BookStatus.CHECKED_OUT);
        Book book5 = new Book("The Catcher in the Rye", "J.D. Salinger", "567890", "DEF", 22, BookStatus.AVAILABLE);
        Book book6 = new Book("Pride and Prejudice", "Jane Austen", "234567", "GHI", 30, BookStatus.OVERDUE);
        Book book7 = new Book("The Hobbit", "J.R.R. Tolkien", "456789", "JKL", 12, BookStatus.AVAILABLE);
        Book book8 = new Book("The Da Vinci Code", "Dan Brown", "012345", "MNO", 28, BookStatus.CHECKED_OUT);
        Book book9 = new Book("The Alchemist", "Paulo Coelho", "678901", "STU", 16, BookStatus.AVAILABLE);
        Book book10 = new Book("The Lord of the Rings", "J.R.R. Tolkien", "123789", "VWX", 24, BookStatus.OVERDUE);

        _bookList.add(book1);
        _bookList.add(book2);
        _bookList.add(book3);
        _bookList.add(book4);
        _bookList.add(book5);
        _bookList.add(book6);
        _bookList.add(book7);
        _bookList.add(book8);
        _bookList.add(book9);
        _bookList.add(book10);
        return _bookList;
    }

    private static List<Author> authorList(){
        ArrayList<Author> _authorList = new ArrayList<>();
        Author author1 = new Author("Jodi Picoult", "19-02-1997", filterBooksByAuthor(bookList(), "Jodi Picoult"));
        Author author2 = new Author("Harper Lee", "10-04-1985", filterBooksByAuthor(bookList(), "Harper Lee"));
        Author author3 = new Author("George Orwell", "25-06-1950", filterBooksByAuthor(bookList(), "George Orwell"));
        Author author4 = new Author("F. Scott Fitzgerald", "03-09-1920", filterBooksByAuthor(bookList(), "F. Scott Fitzgerald"));
        Author author5 = new Author("J.D. Salinger", "15-11-1948", filterBooksByAuthor(bookList(), "J.D. Salinger"));
        Author author6 = new Author("Jane Austen", "21-07-1817", filterBooksByAuthor(bookList(), "Jane Austen"));
        Author author7 = new Author("J.R.R. Tolkien", "03-01-1892", filterBooksByAuthor(bookList(), "J.R.R. Tolkien"));
        Author author8 = new Author("Dan Brown", "22-06-1964", filterBooksByAuthor(bookList(), "Dan Brown"));
        Author author9 = new Author("Paulo Coelho", "05-08-1978", filterBooksByAuthor(bookList(), "Paulo Coelho"));
        Author author10 = new Author("J.R.R. Tolkien", "03-01-1892", filterBooksByAuthor(bookList(), "J.R.R. Tolkien"));

        _authorList.add(author1);
        _authorList.add(author2);
        _authorList.add(author3);
        _authorList.add(author4);
        _authorList.add(author5);
        _authorList.add(author6);
        _authorList.add(author7);
        _authorList.add(author8);
        _authorList.add(author9);
        _authorList.add(author10);

        return _authorList;
        // Optionally, you can add these authors to a list or perform other actions with them
    }

    private static List<Patron> patronList(){
        ArrayList<Patron> _patronList = new ArrayList<>();
        Patron patron1 = new Patron("John Smith", "123 st , St.john's , NL ", 123-456-7890, bookList());
        Patron patron2 = new Patron("Will Smith", "123 st , St.john's , NL ", 123-456-7890, bookList());
        Patron patron3 = new Patron("Steve Smith", "123 st , St.john's , NL ", 123-456-7890, bookList());
        Patron patron4 = new Patron("Mark Smith", "123 st , St.john's , NL ", 123-456-7890, bookList());
        Patron patron5 = new Patron("Tim Smith", "123 st , St.john's , NL ", 123-456-7890, bookList());
        Patron patron6 = new Patron("Tony Smith", "123 st , St.john's , NL ", 123-456-7890, bookList());
        Patron patron7 = new Patron("Eric Smith", "123 st , St.john's , NL ", 123-456-7890, bookList());
        Patron patron8 = new Patron("Justin Smith", "123 st , St.john's , NL ", 123-456-7890, bookList());
        Patron patron9 = new Patron("Luke Smith", "123 st , St.john's , NL ", 123-456-7890, bookList());
        Patron patron10 = new Patron("Alex Smith", "123 st , St.john's , NL ", 123-456-7890, bookList());

        _patronList.add(patron1);
        _patronList.add(patron2);
        _patronList.add(patron3);
        _patronList.add(patron4);
        _patronList.add(patron5);
        _patronList.add(patron6);
        _patronList.add(patron7);
        _patronList.add(patron8);
        _patronList.add(patron9);
        _patronList.add(patron10);
        return _patronList;
    }

    // Helper method to filter books by author's name
    private static List<Book> filterBooksByAuthor(List<Book> _bookList, String authorName) {
        return _bookList.stream()
            .filter(book -> book.getAuthor().equals(authorName))
            .collect(Collectors.toList());
    }  
}

