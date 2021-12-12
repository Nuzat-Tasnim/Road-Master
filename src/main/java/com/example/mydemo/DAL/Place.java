package com.example.mydemo.DAL;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Place implements Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int placeId;

    private String placeName;
    private String description;

    //Foreign Key
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Transport> transportList = new ArrayList<>();
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Contacts> policecontacts = new ArrayList<>();
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Contacts> hospcontacts = new ArrayList<>();
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Review> reviewList = new ArrayList<>();
    public Place(){
        return;
    }

    //constructor


    public Place(String placeName, String description) {
        this.placeName = placeName;
        this.description = description;
    }

    //geter setter

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Transport> getTransportList() {
        return transportList;
    }

    public void setTransportList(List<Transport> transportList) {
        this.transportList = transportList;
    }

    public void addTransport(Transport transport) {
        this.transportList.add(transport);
    }

    public void removeTransport(Transport transport) {
        this.transportList.remove(transport);
    }

    public List<Contacts> getPolicecontacts() {
        return policecontacts;
    }

    public void setPolicecontacts(List<Contacts> policecontacts) {
        this.policecontacts = policecontacts;
    }

    public void addPolicecontacts(Contacts contacts){
        this.policecontacts.add(contacts);
    }

    public void removePolicecontacts(Contacts contacts){
        this.policecontacts.remove(contacts);
    }

    public List<Contacts> getHospcontacts() {
        return hospcontacts;
    }

    public void setHospcontacts(List<Contacts> hospcontacts) {
        this.hospcontacts = hospcontacts;
    }

    public void addHospcontacts(Contacts contacts){
        this.hospcontacts.add(contacts);
    }

    public void removeHospcontacts(Contacts contacts){
        this.hospcontacts.remove(contacts);
    }

    @Override
    public List<Review> getReviewList() {
        return reviewList;
    }

    @Override
    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }
    @Override
    public void addReviewList(Review review){
        this.reviewList.add(review);
    }

    @Override
    public Object clone()
    {
        Object clone = null;
        try
        {
            clone = super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
        return clone;
    }

}
