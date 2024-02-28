package Authors;

import java.util.ArrayList;

public class AuthorRepoImpl implements AuthorRepo{

    private ArrayList<Author> authorList = new ArrayList<Author>();


    @Override
    public void add(Author authorObj) {
     authorList.add(authorObj);
    }

    @Override
    public void edit(Author authorObj) {
       for( Author a : authorList){
        if(a.getName().equals(authorObj.getName())){
            authorList.remove(a);
            break;
        }

        authorList.add(authorObj);

       }
    }

    @Override
    public void delete(Author authorObj) {
        authorList.remove(authorObj);
    }

    @Override
    public ArrayList<Author> getAuthors() {
       return authorList;
    }
    
}
