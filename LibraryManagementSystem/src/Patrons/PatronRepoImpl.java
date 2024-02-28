package Patrons;

import java.util.ArrayList;

public class PatronRepoImpl implements PatronRepo{

    private ArrayList<Patron> patronList = new ArrayList<Patron>();


    @Override
    public void add(Patron patronObj) {
     patronList.add(patronObj);
    }

    @Override
    public void edit(Patron patronObj) {
       for(Patron p : patronList){
        if(p.getName().equals(patronObj.getName())){
            patronList.remove(p);
            break;
        }

        patronList.add(patronObj);

       }
    }

    @Override
    public void delete(Patron patronObj) {
        patronList.remove(patronObj);
    }

    @Override
    public ArrayList<Patron> getPatrons() {
        return patronList;
    }
    
}
