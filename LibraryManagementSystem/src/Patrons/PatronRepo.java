package Patrons;

import java.util.ArrayList;



public interface PatronRepo {
    public void add(Patron patronObj);
    public void edit(Patron patronObj);
    public void delete(Patron patronObj);
    public ArrayList<Patron> getPatrons();
}