package Authors;

import java.util.ArrayList;


public interface AuthorRepo {
    public void add(Author authorObj);
    public void edit(Author authorObj);
    public void delete(Author authorObj);
    public ArrayList<Author> getAuthors();
}