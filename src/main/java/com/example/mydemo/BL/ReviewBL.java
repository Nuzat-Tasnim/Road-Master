package com.example.mydemo.BL;

import com.example.mydemo.DAL.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class ReviewBL {

    @Autowired
    PlaceDAL placeRepo;
    @Autowired
    JourneyDAL journeyRepo;
    @Autowired
    ReviewDAL reviewRepo;
    @Autowired
    BookmarkBL bookmarkBl;


    public User getuser(HttpSession session){
        return (User) session.getAttribute("user");
    }

    public void getmodelplace(int elementid, String text,HttpSession session){
        Review review = reviewRepo.save(new Review(text,elementid, getuser(session)));
        Place place= placeRepo.findPlaceByPlaceId(elementid);
        if(!text.equals("")) place.addReviewList(review);
        placeRepo.save(place);
    }
    public void getmodeljourney(int elementid, String text, HttpSession session){
        Review review = reviewRepo.save(new Review(text,elementid, getuser(session)));
        Journey journey = journeyRepo.findJourneyByJourneyId(elementid);
        if(!text.equals("")) journey.addReviewList(review);
        journeyRepo.save(journey);
    }
}
