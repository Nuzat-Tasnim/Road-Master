package com.example.mydemo.DAL;

import javax.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;
    private String text;
    private int elementId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User user;

    public Review(){
        return ;
    }

    public Review(String text, int elementId, User user) {
        this.text = text;
        this.elementId = elementId;
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setElementId(int elementId) {
        this.elementId = elementId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getElementId() {
        return elementId;
    }

    public User getUser() {
        return user;
    }

}
