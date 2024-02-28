package Books;

import java.util.ArrayList;

public class BookRepoImpl implements BookRepo {

    private ArrayList<Book> bookList = new ArrayList<Book>();
    
    @Override
    public void add(Book book) {
       bookList.add(book);
        
    }

    @Override
    public void edit(Book book) {
        for (Book oldBook : bookList) {
            if (oldBook.getISBN().equals(book.getISBN())) {
                bookList.remove(oldBook);
                break;
            }
        }
        bookList.add(book);
    }

    @Override
    public void delete(Book book) {
        bookList.remove(book);
    }

    @Override
    public ArrayList<Book> getBooks() {
        return bookList;
    }

    @Override
    public ArrayList<Book> search(
        String title,
        String author,
        String ISBN
    ) {
        ArrayList<Book> searchList = new ArrayList<Book>();
        for (Book book : bookList) {
            boolean hasTitle = book.getTitle().contains(title);
            boolean hasAuthor = book.getAuthor().contains(author);
            boolean hasISBN = book.getISBN().contains(ISBN);
            
            if (hasTitle || hasAuthor || hasISBN) {
                searchList.add(book);
            }
        }
        return searchList;
    }

   @Override
   public void booksBorrow(Book book, int noOfCopies) {
       for (int index = 0; index < bookList.size(); index++) {
        Book oldBook = bookList.get(index);
        if (oldBook.getISBN().equals(book.getISBN())) {
            if (oldBook.getNoOfCopies() < noOfCopies) {
                System.out.println("The requested book is currently checked out");
            } else {
                int newNoOfCopies = oldBook.getNoOfCopies() - noOfCopies;
                oldBook.setNoOfCopies(newNoOfCopies);
                bookList.set(index, oldBook);
            }
            
            break;  
        }
       }
   }

   @Override
   public void booksReturn(Book book, int noOfCopies) {
    for (int index = 0; index < bookList.size(); index++) {
        Book oldBook = bookList.get(index);
        if (oldBook.getISBN().equals(book.getISBN())) {
            int newNoOfCopies = oldBook.getNoOfCopies() + noOfCopies;
            oldBook.setNoOfCopies(newNoOfCopies);
            bookList.set(index, oldBook);
            break;  
        }
       }
   }
}

