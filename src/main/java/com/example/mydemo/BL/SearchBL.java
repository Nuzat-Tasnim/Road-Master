package com.example.mydemo.BL;

import com.example.mydemo.DAL.Journey;
import com.example.mydemo.DAL.JourneyDAL;
import com.example.mydemo.DAL.Place;
import com.example.mydemo.DAL.PlaceDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Service
public class SearchBL {

    @Autowired
    PlaceDAL placeRepo;
    @Autowired
    BookmarkBL bookmarkBl;
    @Autowired
    JourneyDAL journeyRepo;
    @Autowired
    CreateModel createModel;


    //place
    public Map getPlace(int elementid,HttpSession session){
        Place place = placeRepo.findPlaceByPlaceId(elementid);
        boolean bookmark = bookmarkBl.getbookmarkplace(elementid,session);
        return createModel.getModel("place",place,bookmark,session);
    }
    public Map searchPlace(String name, HttpSession session){
        List<Place> places = placeRepo.findAllByPlaceNameContainingIgnoreCase(name);
        if(places.size()==0) return null;
        return createModel.getModelplaces(places,session);
    }


    //journey
    public Map getJourney(int elementid,HttpSession session){

        Journey journey = journeyRepo.findJourneyByJourneyId(elementid);
        boolean bookmark = bookmarkBl.getbookmarkjourney(elementid,session);
        return createModel.getModel("journey",journey,bookmark,session);
    }

    public Map searchJourney(String source, String destination,HttpSession session){
        source = source.substring(0,1).toUpperCase() + source.substring(1,source.length()).toLowerCase();
        destination = destination.substring(0,1).toUpperCase() + destination.substring(1, destination.length()).toLowerCase();
        List<Journey> journeys = journeyRepo.getAllBySource_PlaceNameAndDestination_PlaceNameIgnoreCase(source,destination);
        if(journeys.size()==0) return null;
        return createModel.getModeljourneys(journeys,session);
    }
}
