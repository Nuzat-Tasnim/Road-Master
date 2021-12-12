package com.example.mydemo.BL;

import com.example.mydemo.DAL.Result;
import com.example.mydemo.DAL.Journey;
import com.example.mydemo.DAL.Place;
import com.example.mydemo.DAL.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CreateModel {

    public Map<String, Object> model = new HashMap<String, Object>();

    public User getuser(HttpSession session){
        return (User) session.getAttribute("user");
    }


    public Map getModel(String element,Result result, boolean bookmark,HttpSession session){
        model.put(element, result);
        model.put("bookmark",bookmark);
        model.put("user",getuser(session));
        return model;
    }
    public Map getmodeledit(String element, Result result,HttpSession session){
        model.put(element,result);
        model.put("user",getuser(session));
        return model;
    }
    public Map getModelplaces( List<Place> list,HttpSession session){
        model.put("places",list);
        model.put("user",getuser(session));
        return model;
    }
    public Map getModeljourneys(List<Journey> list,HttpSession session){
        model.put("journeys",list);
        model.put("user",getuser(session));
        return model;
    }
    public Map getmodelhome(HttpSession session){
        model.put("user",getuser(session));
        return model;
    }
    public Map getmodelerror(String msg,HttpSession session){
        model.put("user",getuser(session));
        model.put("msg",msg);
        return model;
    }

}
