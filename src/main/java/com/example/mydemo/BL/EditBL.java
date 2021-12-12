package com.example.mydemo.BL;

import com.example.mydemo.DAL.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Service
public class EditBL {
    @Autowired
    UserDAL userRepo;
    @Autowired
    RegisterBL registerBl;
    @Autowired
    BookmarkBL bookmarkBl;
    @Autowired
    PlaceDAL placeRepo;
    @Autowired
    JourneyDAL journeyRepo;
    @Autowired
    transportDAL transportRepo;
    @Autowired
    CreateModel createModel;

    public User getuser(HttpSession session){
        return (User) session.getAttribute("user");
    }
    public void sessionactivity(HttpSession session,User user){
        session.removeAttribute("user");
        session.setAttribute("user",user);
    }
    

    //user
    public User editUser(String name, String email, String pass,HttpSession session){
        User user = getuser(session);
        if(verify(user,name,email,pass)){
            System.out.println(user.getUserName());
            user.setUserName(name);
            user.setEmail(email);
            user.setPassword(pass);
            user = userRepo.save(user);
            sessionactivity(session,user);
            System.out.println(user.getUserName());
            return user;
        }
        return null;
    }

    public boolean verify(User user, String name, String email, String pass){
        if(name.length()>0 && registerBl.verifyPass(pass,pass)){
            if(registerBl.verifyEmail(email)){

                return true;
            }
            else{
                System.out.println(name+ " ----- " +email);
                return (user.getEmail().equals(email));
            }
        }
        return false;
    }


    //place
    public Map editPlaceform(int elementid,HttpSession session){
        Place place = placeRepo.findPlaceByPlaceId(elementid);
        return createModel.getmodeledit("place",place,session);
    }
    public Map editPlace(int elementid, String placeName, String description, HttpSession session){
        Place place = placeRepo.findPlaceByPlaceId(elementid);
        Result result = (Result) place.clone();
        Place placenew = (Place) result;

        placenew.setPlaceName(placeName);
        placenew.setDescription(description);

        boolean bookmark = bookmarkBl.getbookmarkplace(elementid,session);
        return createModel.getModel("place",placeRepo.save(placenew),bookmark,session);
    }

    //journey
    public Map editJourneyform(int elementid,HttpSession session){
        return createModel.getmodeledit("journey",journeyRepo.findJourneyByJourneyId(elementid),session);
    }
    public Map editJourney(int elementid, int sourceid, int destinationid, String description, HttpSession session){
        Journey journey = journeyRepo.findJourneyByJourneyId(elementid);
        Result result = (Result) journey.clone();
        Journey journeynew = (Journey) result;

        Place source = placeRepo.findPlaceByPlaceId(sourceid);
        Place destination = placeRepo.findPlaceByPlaceId(destinationid);
        if(source==null||destination==null) return null;

        journeynew.setSource(source);
        journeynew.setDestination(destination);
        journeynew.setDescription(description);
        journeyRepo.save(journeynew);

        boolean bookmark = bookmarkBl.getbookmarkjourney(elementid,session);
        return createModel.getModel("journey",journeynew,bookmark,session);
    }


}

