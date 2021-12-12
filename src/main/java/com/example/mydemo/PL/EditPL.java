package com.example.mydemo.PL;

import com.example.mydemo.BL.EditBL;
import com.example.mydemo.BL.CreateModel;
import com.example.mydemo.DAL.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class EditPL {

    @Autowired
    EditBL editBL;
    @Autowired
    CreateModel createModel;

    public boolean isloggedin(HttpSession session){
        return session.getAttribute("user")!=null;
    }
    public boolean admincheck(HttpSession session){
        User user = (User) session.getAttribute("user");
        return user.isAdmin();
    }

    //user
    @RequestMapping("editProfilePage")
    public ModelAndView editform(HttpSession session){


        if(!isloggedin(session)) return new ModelAndView("index.jsp");

        return new ModelAndView("editProfile.jsp","model",createModel.getmodelhome(session));
    }

    @RequestMapping("editProfile")
    public ModelAndView editprofile(@RequestParam("name") String name,
                             @RequestParam("email") String email,
                             @RequestParam("password") String password,
                             HttpSession session)
    {
        if(!isloggedin(session)) return new ModelAndView("index.jsp");
        User user = editBL.editUser(name,email,password,session);
        if(user!=null)
            return new ModelAndView("home.jsp","model",createModel.getmodelhome(session));
        else{
            return new ModelAndView("error.jsp","model",createModel.getmodelerror("Invalid Credentials",session));
        }
    }

    //place
    @RequestMapping("editPlace")
    public ModelAndView editPlaceform(@RequestParam("elementid") int elementid,
                                 HttpSession session){
        if(!isloggedin(session)) return new ModelAndView("index.jsp");
        if (!admincheck(session)) return new ModelAndView("error.jsp","model",createModel.getmodelerror("Only admin can update the data.",session));

        return new ModelAndView("editplace.jsp","model",editBL.editPlaceform(elementid,session));
    }
    @RequestMapping("saveEditPlace")
    public ModelAndView editplace(@RequestParam("elementid") int elementid,
                             @RequestParam("placeName") String placeName,
                             @RequestParam(value = "description", required = false) String description,
                             HttpSession session){

        if(!isloggedin(session)) return new ModelAndView("index.jsp");
        if (!admincheck(session)) return new ModelAndView("error.jsp","model",createModel.getmodelerror("Only admin can update the data.",session));

        return new ModelAndView("placepage.jsp","model", editBL.editPlace(elementid,placeName,description,session));
    }


    //journey
    @RequestMapping("editJourney")
    public ModelAndView editJourneyform(@RequestParam("elementid") int elementid,
                                 HttpSession session){
        if(!isloggedin(session)) return new ModelAndView("index.jsp");
        if(!admincheck(session)) return new ModelAndView("error.jsp","model",createModel.getmodelerror("Only admin can update the data.",session));

        return new ModelAndView("editjourney.jsp","model",editBL.editJourneyform(elementid,session));
    }

    @RequestMapping("saveEditJourney")
    public ModelAndView editjourney(@RequestParam("elementid") int elementid,
                             @RequestParam("sourceid") int sourceid,
                             @RequestParam("destinationid") int destinationid,
                             @RequestParam(value="description", required = false) String description,
                             HttpSession session)
    {

        if(!isloggedin(session)) return new ModelAndView("index.jsp");
        if(!admincheck(session)) return new ModelAndView("error.jsp","model",createModel.getmodelerror("Only admin can update the data.",session));

        Map<String, Object> model = editBL.editJourney(elementid,sourceid,destinationid,description,session);
        if(model==null) return new ModelAndView("error.jsp",createModel.getmodelerror("Invalid Data.",session));
        return new ModelAndView("journeypage.jsp","model",model);
    }
}
