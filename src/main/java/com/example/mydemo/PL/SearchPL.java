package com.example.mydemo.PL;

import com.example.mydemo.BL.SearchBL;
import com.example.mydemo.BL.CreateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class SearchPL {

    @Autowired
    SearchBL searchBL;
    @Autowired
    CreateModel createModel;

    public boolean isloggedin(HttpSession session){
        return session.getAttribute("user")!=null;
    }


    //place
    @RequestMapping(value = "/searchform")
    public ModelAndView searchPlaceForm(HttpSession session) {
        if(!isloggedin(session)) return new ModelAndView("index.jsp");
        return new ModelAndView("search.jsp",  "model", createModel.getmodelhome(session));
    }

    @RequestMapping(value = "searchPlaceList")
    public ModelAndView searchPlaceList(@RequestParam("place") String name,
                                        HttpSession session){
        if(!isloggedin(session)) return new ModelAndView("index.jsp");

        Map<String, Object> model = searchBL.searchPlace(name,session);
        if(model==null) return new ModelAndView("error.jsp", "model", createModel.getmodelerror("No such results",session));
        return new ModelAndView("placeList.jsp", "model", model);

    }
    @RequestMapping(value = "/searchPlace")
    public ModelAndView searchPlace(@RequestParam("elementid") int elementid,
                                    HttpSession session) {
        if(!isloggedin(session)) return new ModelAndView("index.jsp");
        return new ModelAndView("placepage.jsp",  "model", searchBL.getPlace(elementid,session));
    }


    //journey
    @RequestMapping(value = "/searchjourneyform")
    public ModelAndView searchPlace(HttpSession session) {
        if(!isloggedin(session)) return new ModelAndView("index.jsp");
        return new ModelAndView("searchJourney.jsp",  "model", createModel.getmodelhome(session));
    }

    @RequestMapping(value = "searchJourneyList")
    public ModelAndView searchJourneyList(@RequestParam("source") String source,
                                          @RequestParam("destination") String destination,
                                          HttpSession session)
    {

        if(!isloggedin(session)) return new ModelAndView("index.jsp");
        Map<String, Object> model = searchBL.searchJourney(source, destination,session);
        if(model==null) return new ModelAndView("error.jsp", "model", createModel.getmodelerror("No such results",session));
        return new ModelAndView("JourneyList.jsp", "model", model);
    }

    @RequestMapping(value = "/searchJourney", method = RequestMethod.GET)
    public ModelAndView searchJourney(@RequestParam(value = "elementid") int elementid,
                                      HttpSession session) {

        if(!isloggedin(session)) return new ModelAndView("index.jsp");
        return new ModelAndView("journeypage.jsp", "model", searchBL.getJourney(elementid,session));
    }
}
