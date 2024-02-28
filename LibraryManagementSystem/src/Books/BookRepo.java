package Books;

import java.util.ArrayList;

public interface BookRepo {
    public void add(Book book);
    public void edit(Book book);
    public void delete(Book book);
    public ArrayList<Book> search(String title, String author, String ISBN);
    public ArrayList<Book> getBooks();
    public void booksBorrow(Book book, int noOfCopies);
    public void booksReturn(Book book, int noOfCopies);
}


