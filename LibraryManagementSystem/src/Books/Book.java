package Books;


public class Book {
   private String title;
   private String author;
   private String ISBN;
   private String publisher;
   private int noOfCopies;
   private BookStatus status;

   public Book(
    String title,
    String author,
    String ISBN,
    String publisher,
    int noOfCopies,
    BookStatus status
   ) {
    this.title = title;
    this.author = author;
    this.ISBN = ISBN;
    this.publisher = publisher;
    this.noOfCopies = noOfCopies;
    this.status = status;
   }

   public void setTitle(String title) {
    this.title = title;
   }

   public String getTitle() {
    return title;
   }

   public void setAuthor(String author) {
       this.author = author;
   }

   public String getAuthor() {
       return author;
   }

   public void setISBN(String ISBN) {
       this.ISBN = ISBN;
   }

   public String getISBN() {
       return ISBN;
   }

   public void setPublisher(String publisher) {
       this.publisher = publisher;
   }

   public String getPublisher() {
       return publisher;
   }

   public void setNoOfCopies(int noOfCopies) {
       this.noOfCopies = noOfCopies;
   }

   public int getNoOfCopies() {
       return noOfCopies;
   }

   public void setStatus(BookStatus status) {
       this.status = status;
   }

   public BookStatus getStatus() {
       return status;
   }

   @Override
   public String toString() {
    return "Title: " + title +
    "\nAuthor: " + author +
    "\nISBN: " + ISBN +
    "\nPublisher: " + publisher +
    "\nNumber of Copies: " + noOfCopies +
    "\nStatus: " + status.name();
   }
}
