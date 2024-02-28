package Patrons;

import java.util.List;

import Books.Book;

public class Patron {
    private String name;
    private String address;
    private int number;
    private List<Book> patronBookList;

    public Patron(String name, String address, int number, List<Book> patronBookList){
        this.name = name;
        this.address = address;
        this.number = number;
        this.patronBookList = patronBookList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Book> getPatronBookList() {
        return patronBookList;
    }

    public void setPatronBookList(List<Book> patronBookList) {
        this.patronBookList = patronBookList;
    }

    @Override
    public String toString() {
        String result = "Name: " + name +
                        "\nAddress: " + address +
                        "\nPhone Number: " + number +
                        "\nBooks Borrowed:\n";

        for (Book b : patronBookList) {
            result += "- " + b + "\n";
        }

        return result;
    }

}
