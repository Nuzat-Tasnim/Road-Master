package com.example.mydemo.DAL;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BookmarkedPlaces implements IteratorContainer, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private User user;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<IdContainer> placelist = new ArrayList<>();


    private static final long serialVersionUID = 7156526077883281623L;



    public List<IdContainer> getPlacelist() {
        return placelist;
    }

    public void setPlacelist(List<IdContainer> placelist) {
        this.placelist = placelist;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void add(IdContainer ic){
        placelist.add(ic);
    }
    public void remove(int index){
        placelist.remove(index);
    }

    @Override
    public Iterator getIterator() {
        return new bookmarkedplaceIterator();
    }

    public class bookmarkedplaceIterator implements Iterator{

        int index=0;

        @Override
        public Boolean hasNext() {
            if(index<placelist.size())
                return true;
            else
                return false;
        }

        @Override
        public IdContainer next() {
            return placelist.get(index++);
        }

        @Override
        public int getIndex(){
            return index;
        }
    }

}
