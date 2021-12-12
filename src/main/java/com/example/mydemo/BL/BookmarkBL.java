package com.example.mydemo.BL;

import com.example.mydemo.DAL.Iterator;
import com.example.mydemo.DAL.Result;
import com.example.mydemo.DAL.IdContainer;
import com.example.mydemo.DAL.User;
import com.example.mydemo.DAL.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BookmarkBL {
    
    @Autowired
    PlaceDAL placeRepo;
    @Autowired
    JourneyDAL journeyRepo;
    @Autowired
    BookmarkedplaceDAL bookmarkedplaceRepo;
    @Autowired
    BookmarkedjourneyDAL bookmarkedjourneyRepo;
    @Autowired
    UserDAL userRepo;
    @Autowired
    IdcontainerDAL icRepo;
    @Autowired
    CreateModel createModel;

    public User getuser(HttpSession session){
        return (User) session.getAttribute("user");
    }
    public void sessionactivity(HttpSession session, User user){
        session.removeAttribute("user");
        session.setAttribute("user",user);
    }

    public void bookmark(int elementid, String element,HttpSession session){
        User user = getuser(session);
        if(element.equalsIgnoreCase("PLace")){
            System.out.println("bookmark "+element);

            user.getBookmarkedPlaces().add(icRepo.save(new IdContainer(elementid)));
            user.setBookmarkedPlaces(bookmarkedplaceRepo.save(user.getBookmarkedPlaces()));
        }
        else{
            user.getBookmarkedJourneys().add(icRepo.save(new IdContainer(elementid)));
            user.setBookmarkedJourneys(bookmarkedjourneyRepo.save(user.getBookmarkedJourneys()));
        }

        sessionactivity(session,userRepo.save(user));
    }
    public void unbookmark(int elementid, String element,HttpSession session){
        User user = getuser(session);
        if(element.equalsIgnoreCase("Place")){
            user.getBookmarkedPlaces().remove(iteration(user.getBookmarkedPlaces().getIterator(),elementid)-1);
        }
        else{
            user.getBookmarkedJourneys().remove(iteration(user.getBookmarkedJourneys().getIterator(),elementid)-1);
        }

        sessionactivity(session,userRepo.save(user));
    }

    public boolean getbookmarkplace(int elementid,HttpSession session){
        return -1 != iteration(getuser(session).getBookmarkedPlaces().getIterator(),elementid);
    }

    public Map getBookmarkedPlaceList(HttpSession session){
        Iterator iterator = getuser(session).getBookmarkedPlaces().getIterator();
        List<Place> placeList = new ArrayList<Place>();
        while (iterator.hasNext()){
            placeList.add(placeRepo.findPlaceByPlaceId(iterator.next().getId()));
        }
        if(placeList.isEmpty()) return null;
        return createModel.getModelplaces(placeList,session);
    }



    public boolean getbookmarkjourney(int elementid,HttpSession session){
        return -1 != iteration(getuser(session).getBookmarkedJourneys().getIterator(),elementid);
    }

    public Map getBookmarkedJourneyList(HttpSession session){
        Iterator iterator = getuser(session).getBookmarkedJourneys().getIterator();
        List<Journey> list = new ArrayList<>();
        while(iterator.hasNext()){
            list.add(journeyRepo.findJourneyByJourneyId(iterator.next().getId()));
        }
        if(list.size()<1) return null;
        return createModel.getModeljourneys(list,session);
    }


    public int iteration(Iterator iterator,int elementid){
        while (iterator.hasNext()){
            if(iterator.next().getId()==elementid){
                return iterator.getIndex();
            }
        }
        return -1;
    }

}
