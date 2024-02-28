package Authors;

import java.util.List;

import Books.Book;

public class Author {
    private String name;
    private String dob;
    private List<Book> authorBookList ;
    
    public Author(String name, String dob, List<Book> authorBookList){
        this.name = name;
        this.dob = dob;
        this.authorBookList = authorBookList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public List<Book> getAuthorBookList() {
        return authorBookList;
    }

    public void setAuthorBookList(List<Book> authorBookList) {
        this.authorBookList = authorBookList;
    }

    @Override
    public String toString() {
        String result = "Name: " + name +
                        "\nDate of Birth: " + dob +
                        "\nBooks Written:\n";

        for (Book book : authorBookList) {
            result += "- " + book.toString() + "\n";
        }

        return result;
    }

}
