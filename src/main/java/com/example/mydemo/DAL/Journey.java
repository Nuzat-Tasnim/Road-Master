package com.example.mydemo.DAL;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Journey implements Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int journeyId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Place source;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Place destination;

    private String description;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Transport> transportList = new ArrayList<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Review> reviewList = new ArrayList<>();


    //gettter setter tostring
    public Journey(){
        return;
    }

    public Journey(Place source, Place destination, String description) {
        this.source = source;
        this.destination = destination;
        this.description = description;
    }

    public Place getSource() {
        return source;
    }

    public void setSource(Place source) {
        this.source = source;
    }

    public Place getDestination() {
        return destination;
    }

    public void setDestination(Place destination) {
        this.destination = destination;
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

    public void addTransportList(Transport transport) {
        this.transportList.add(transport);
    }

    public void removeTransport(Transport transport) {
        this.transportList.remove(transport);
    }

    @Override
    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    @Override
    public void addReviewList(Review review) {
        reviewList.add(review);
    }

    public int getJourneyId() {
        return journeyId;
    }

    public void setJourneyId(int journeyId) {
        this.journeyId = journeyId;
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
