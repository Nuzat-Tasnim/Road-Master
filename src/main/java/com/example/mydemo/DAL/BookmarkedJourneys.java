package com.example.mydemo.DAL;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BookmarkedJourneys implements IteratorContainer, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private User user;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
            //mappedBy = "user"
    )
    private List<IdContainer> journeylist = new ArrayList<>();


    private static final long serialVersionUID = 7156526077883281623L;



    public List<IdContainer> getJourneylist() {
        return journeylist;
    }

    public void setJourneylist(List<IdContainer> journeylist) {
        this.journeylist = journeylist;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void add(IdContainer ic){
        journeylist.add(ic);
    }
    public void remove(int index){
        journeylist.remove(index);
    }


    @Override
    public Iterator getIterator() {
        return new bookmarkedjourneyIterator();
    }

    public class bookmarkedjourneyIterator implements Iterator {

        int index=0;

        @Override
        public Boolean hasNext() {
            if(index<journeylist.size())
                return true;
            else
                return false;
        }

        @Override
        public IdContainer next() {
            return journeylist.get(index++);
        }

        @Override
        public int getIndex(){
            return index;
        }
    }

}
