package com.example.mydemo.BL;

import com.example.mydemo.DAL.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Service
public class AddBL {
    @Autowired
    SearchBL searchBL;
    @Autowired
    PlaceDAL placeRepo;
    @Autowired
    JourneyDAL journeyRepo;
    @Autowired
    transportDAL transportRepo;
    @Autowired
    ContactsDAL contactsRepo;
    @Autowired
    CreateModel createModel;

    //place
    /*
    public Map getPlace(int elementid, HttpSession session){
        return searchBL.getPlace(elementid,session);
    }*/
    public int savePlace(String placeName, String description,HttpSession session){
        return placeRepo.save(new Place(placeName,description)).getPlaceId();
    }
    public Map editPlace(int elementid,HttpSession session){
        return createModel.getmodeledit("place",placeRepo.findPlaceByPlaceId(elementid),session);
    }

    public Map savehospcontact(int elementid,String name,String address,String contact,HttpSession session){
        Place place = placeRepo.findPlaceByPlaceId(elementid);
        place.addHospcontacts(contactsRepo.save(new Contacts(name,address,contact)));
        return createModel.getmodeledit("place",placeRepo.save(place),session);
    }
    public Map deleteHospital(int elementid, int contactid,HttpSession session){
        Place place = placeRepo.findPlaceByPlaceId(elementid);
        place.removeHospcontacts(contactsRepo.findContactsById(contactid));
        return createModel.getmodeledit("place",placeRepo.save(place),session);
    }
    public Map savepolicecontact(int elementid,String name,String address,String contact,HttpSession session){
        Place place = placeRepo.findPlaceByPlaceId(elementid);
        place.addPolicecontacts(contactsRepo.save(new Contacts(name,address,contact)));
        return createModel.getmodeledit("place",placeRepo.save(place),session);
    }
    public Map deletePolice(int elementid, int contactid,HttpSession session){
        Place place = placeRepo.findPlaceByPlaceId(elementid);
        place.removePolicecontacts(contactsRepo.findContactsById(contactid));
        return createModel.getmodeledit("place",placeRepo.save(place),session);
    }
    public Map savePlacetransport(int elementid,String name,String availability,HttpSession session){
        Place place = placeRepo.findPlaceByPlaceId(elementid);
        place.addTransport(transportRepo.save(new Transport(name,(availability!=null))));
        return createModel.getmodeledit("place",placeRepo.save(place),session);
    }
    public Map deletePlaceTransport(int elementid, int transportid,HttpSession session){
        Place place = placeRepo.findPlaceByPlaceId(elementid);
        place.removeTransport(transportRepo.findTransportById(transportid));
        return createModel.getmodeledit("place",placeRepo.save(place),session);
    }




    //journey
    /*
    public Map getJourney(int elementid, HttpSession session){
        return searchBL.getJourney(elementid,session);
    }*/
    public Map getmodeledit(int elementid,HttpSession session){
        return createModel.getmodeledit("journey",journeyRepo.findJourneyByJourneyId(elementid),session);
    }

    public int savejourney(int sourceid,int destinationid,String description,HttpSession session){
        Place source = placeRepo.findPlaceByPlaceId(sourceid);
        Place destination = placeRepo.findPlaceByPlaceId(destinationid);
        if(source==null || destination==null) return -1;
        return journeyRepo.save(new Journey(source,destination,description)).getJourneyId();
    }

    public Map saveJourneytransport(int elementid,String name,String rent,HttpSession session){
        Journey journey = journeyRepo.findJourneyByJourneyId(elementid);
        journey.addTransportList(transportRepo.save(new Transport(name,rent,true)));
        return createModel.getmodeledit("journey",journeyRepo.save(journey),session);
    }

    public Map deleteJourneyTransport(int elementid, int transportid,HttpSession session){
        Journey journey = journeyRepo.findJourneyByJourneyId(elementid);
        journey.removeTransport(transportRepo.findTransportById(transportid));
        return createModel.getmodeledit("journey",journeyRepo.save(journey),session);
    }


}
