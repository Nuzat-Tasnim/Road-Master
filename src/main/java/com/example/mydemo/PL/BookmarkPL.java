package com.example.mydemo.PL;

import com.example.mydemo.BL.BookmarkBL;
import com.example.mydemo.BL.CreateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class BookmarkPL {
    @Autowired
    BookmarkBL bookmarkBl;
    @Autowired
    CreateModel createModel;

    public boolean isloggedin(HttpSession session){
        return session.getAttribute("user")!=null;
    }

    @RequestMapping("bookmark")
    public ModelAndView bookmark(@RequestParam("elementid") int elementid,
                                      @RequestParam("element") String element,
                                      HttpSession session) {
        if(!isloggedin(session)) return new ModelAndView("index.jsp");
        bookmarkBl.bookmark(elementid, element, session);
        return new ModelAndView("redirect:search"+element+"?elementid="+elementid);
    }

    @RequestMapping("unbookmark")
    public ModelAndView unbookmark(@RequestParam("elementid") int elementid,
                                        @RequestParam("element") String element,
                                        HttpSession session) {
        if(!isloggedin(session)) return new ModelAndView("index.jsp");
        bookmarkBl.unbookmark(elementid, element, session);
        return new ModelAndView("redirect:search"+element+"?elementid="+elementid);
    }
    @RequestMapping("/bookmarkedPlaces")
    public ModelAndView bookmarkPlacelist(HttpSession session){
        if(!isloggedin(session)) return new ModelAndView("index.jsp");

        Map<String, Object> model = bookmarkBl.getBookmarkedPlaceList(session);
        if(model==null) return new ModelAndView("error.jsp", "model", createModel.getmodelerror("No Bookmarked Places",session));
        return new ModelAndView("placeList.jsp", "model", model);
    }


    @RequestMapping("/bookmarkedJourneys")
    public ModelAndView bookmarkJourneylist(HttpSession session){
        if(!isloggedin(session)) return new ModelAndView("index.jsp");

        Map<String, Object> model = bookmarkBl.getBookmarkedJourneyList(session);
        if(model==null) return new ModelAndView("error.jsp", "model", createModel.getmodelerror("No Bookmarked Journeys",session));
        return new ModelAndView("JourneyList.jsp", "model", model);
    }
}
