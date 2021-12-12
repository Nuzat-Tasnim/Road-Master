package com.example.mydemo.PL;

import com.example.mydemo.BL.ReviewBL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class ReviewPL {
    @Autowired
    ReviewBL reviewBl;

    public boolean isloggedin(HttpSession session){
        return session.getAttribute("user")!=null;
    }

    @RequestMapping(value = "/addreviewplace")
    public ModelAndView addreviewplace(@RequestParam(value = "elementid") int elementid,
                                        @RequestParam("review") String text,
                                       HttpSession session){
        if(!isloggedin(session)) return new ModelAndView("index.jsp");
        reviewBl.getmodelplace(elementid, text,session);
        return new ModelAndView("redirect:searchPlace?elementid="+elementid);
    }
    @RequestMapping(value = "/addreviewjourney")
    public ModelAndView addreviewjourney(@RequestParam(value = "elementid") int elementid,
                                        @RequestParam("review") String text,
                                         HttpSession session){
        if(!isloggedin(session)) return new ModelAndView("index.jsp");
        reviewBl.getmodeljourney(elementid, text,session);
        return new ModelAndView("redirect:searchJourney?elementid="+elementid);
    }
}
