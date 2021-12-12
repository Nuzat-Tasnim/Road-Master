package com.example.mydemo.BL;

import com.example.mydemo.DAL.BookmarkedJourneys;
import com.example.mydemo.DAL.BookmarkedPlaces;
import com.example.mydemo.DAL.User;
import com.example.mydemo.DAL.BookmarkedjourneyDAL;
import com.example.mydemo.DAL.BookmarkedplaceDAL;
import com.example.mydemo.DAL.UserDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Service
public class LoginBL {
    @Autowired
    UserDAL userRepo;
    @Autowired
    CreateModel createModel;
    @Autowired
    BookmarkedjourneyDAL bookmarkedjourneyRepo;
    @Autowired
    BookmarkedplaceDAL bookmarkedplaceRepo;

    public User loggingin(String email, String pass, HttpSession session){
        User user = verify(email,pass);

        if(user==null) return null;

        session.setAttribute("user",user);
        //Session.setSession(session);

        user = init(user);
        System.out.println(user.getBookmarkedJourneys().getJourneylist());
        System.out.println(user.getBookmarkedPlaces().getPlacelist());
        return user;
    }

    public User verify(String email,String pass){
        User user = userRepo.findByEmail(email);
        if(user!=null){
            if(user.getPassword().equals(pass)){
                return user;
            }
        }
        return null;
    }

    public User init(User user){

        BookmarkedPlaces bp = bookmarkedplaceRepo.findBookmarkedPlacesByUser(user);
        if(bp==null) bp = new BookmarkedPlaces();
        bp.setUser(user);
        user.setBookmarkedPlaces(bp);

        BookmarkedJourneys bj = bookmarkedjourneyRepo.findBookmarkedJourneysByUser(user);
        if(bj==null) bj = new BookmarkedJourneys();
        bj.setUser(user);
        user.setBookmarkedJourneys(bj);

        return userRepo.save(user);
    }

    public Map getmodelhome(HttpSession session){
        return createModel.getmodelhome(session);
    }

    public void logout(HttpSession session){
        session.invalidate();
    }
}
