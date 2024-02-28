package Library;

import Authors.AuthorRepo;
import Books.BookRepo;
import Patrons.PatronRepo;

public class Library {
    private BookRepo bookRepo;
    private AuthorRepo authorRepo;
    private PatronRepo patronRepo;

    public Library(BookRepo bookRepo, AuthorRepo authorRepo, PatronRepo patronRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
        this.patronRepo = patronRepo;
    }

    public void setBookRepo(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public BookRepo getBookRepo() {
        return bookRepo;
    }
     
    public void setAuthorRepo(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    public AuthorRepo getAuthorRepo() {
        return authorRepo;
    }

    public void setPatronRepo(PatronRepo patronRepo) {
        this.patronRepo = patronRepo;
    }

    public PatronRepo getPatronRepo() {
        return patronRepo;
    }
}
