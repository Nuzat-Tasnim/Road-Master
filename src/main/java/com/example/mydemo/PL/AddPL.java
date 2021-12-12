package com.example.mydemo.PL;

import com.example.mydemo.BL.AddBL;
import com.example.mydemo.BL.SearchBL;
import com.example.mydemo.BL.CreateModel;
import com.example.mydemo.DAL.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class AddPL {
    @Autowired
    AddBL addBL;
    @Autowired
    SearchBL searchBL;
    @Autowired
    CreateModel createModel;

    public boolean isloggedin(HttpSession session){
        return session.getAttribute("user")!=null;
    }
    public boolean admincheck(HttpSession session){
        User user = (User) session.getAttribute("user");
        return user.isAdmin();
    }

    //place
    @RequestMapping("addPlaceForm")
    public ModelAndView checkforPlace(HttpSession session){
        if(!isloggedin(session)) return new ModelAndView("index.jsp");
        if (!admincheck(session)) return new ModelAndView("error.jsp","model",createModel.getmodelerror("Only admin can update the data.",session));

        return new ModelAndView("addplace.jsp","model",createModel.getmodelhome(session));
    }

    @RequestMapping("addPlace")
    public ModelAndView addplace(
            @RequestParam("placeName") String placeName,
            @RequestParam("description") String description,
            HttpSession session)
    {
        if(!isloggedin(session)) return new ModelAndView("index.jsp");
        if (!admincheck(session)) return new ModelAndView("error.jsp","model",createModel.getmodelerror("Only admin can update the data.",session));

        return new ModelAndView("redirect:searchPlace?elementid="+addBL.savePlace(placeName,description,session));
    }

    @RequestMapping("addPlaceInfo")
    public ModelAndView addplaceinfo(@RequestParam("elementid") int elementid,
                                     HttpSession session){
        if(!isloggedin(session)) return new ModelAndView("index.jsp");
        return new ModelAndView("addplaceinfo.jsp","model",addBL.getmodeledit(elementid,session));
    }

    @RequestMapping("addhospitalContact")
    public ModelAndView addhospitalContact(
            @RequestParam(value = "elementid") int elementid,
            @RequestParam("hospName") String name,
            @RequestParam("hospAddress") String address,
            @RequestParam("hospContact") String contact,
            HttpSession session)
    {
        if(!isloggedin(session)) return new ModelAndView("index.jsp");
        if (!admincheck(session)) return new ModelAndView("error.jsp","model",createModel.getmodelerror("Only admin can update the data.",session));

        return new ModelAndView("addplaceinfo.jsp","model",addBL.savehospcontact(elementid,name,address,contact,session));
    }

    @RequestMapping("deleteHospital")
    public ModelAndView deleteHospital(@RequestParam("elementid") int elementid,
                                       @RequestParam("contactid") int contactid,
                                       HttpSession session)
    {
        if(!isloggedin(session)) return new ModelAndView("index.jsp");
        if (!admincheck(session)) return new ModelAndView("error.jsp","model",createModel.getmodelerror("Only admin can update the data.",session));

        return new ModelAndView("addplaceinfo.jsp","model",addBL.deleteHospital(elementid,contactid,session));
    }

    @RequestMapping("addpolicecontact")
    public ModelAndView addpolicecontact(
            @RequestParam("elementid") int elementid,
            @RequestParam("stationName") String name,
            @RequestParam("stationAddress") String address,
            @RequestParam("stationContact") String contact,
            HttpSession session)
    {
        if(!isloggedin(session)) return new ModelAndView("index.jsp");
        if (!admincheck(session)) return new ModelAndView("error.jsp","model",createModel.getmodelerror("Only admin can update the data.",session));

        return new ModelAndView("addplaceinfo.jsp","model",addBL.savepolicecontact(elementid,name,address,contact,session));
    }

    @RequestMapping("deletePolice")
    public ModelAndView deletePolice(@RequestParam("elementid") int elementid,
                                     @RequestParam("contactid") int contactid,
                                     HttpSession session)
    {
        if(!isloggedin(session)) return new ModelAndView("index.jsp");
        if (!admincheck(session)) return new ModelAndView("error.jsp","model",createModel.getmodelerror("Only admin can update the data.",session));

        return new ModelAndView("addplaceinfo.jsp","model",addBL.deletePolice(elementid,contactid,session));
    }

    @RequestMapping("addtransportplace")
    public ModelAndView addtransportPlace(
            @RequestParam("elementid") int elementid,
            @RequestParam("transportname") String name,
            @RequestParam(value="availability") String availability,
            HttpSession session)
    {
        if(!isloggedin(session)) return new ModelAndView("index.jsp");
        if (!admincheck(session)) return new ModelAndView("error.jsp","model",createModel.getmodelerror("Only admin can update the data.",session));

        return new ModelAndView("addplaceinfo.jsp","model",addBL.savePlacetransport(elementid,name,availability,session));
    }

    @RequestMapping("deleteTransportPlace")
    public ModelAndView deleteTransportPlace(@RequestParam("elementid") int elementid,
                                        @RequestParam("transportid") int transportid,
                                        HttpSession session)
    {
        if(!isloggedin(session)) return new ModelAndView("index.jsp");
        if (!admincheck(session)) return new ModelAndView("error.jsp","model",createModel.getmodelerror("Only admin can update the data.",session));

        return new ModelAndView("addplaceinfo.jsp","model",addBL.deletePlaceTransport(elementid,transportid,session));
    }

    @RequestMapping("/backtoplace")
    public ModelAndView gobackPlace(@RequestParam("elementid") int elementid,
                               HttpSession session){
        if(!isloggedin(session)) return new ModelAndView("index.jsp");
        return new ModelAndView("placepage.jsp","model",addBL.editPlace(elementid,session));
    }
    
    
    //journey
    @RequestMapping("addJourneyForm")
    public ModelAndView checkforJourney(HttpSession session){
        if(!isloggedin(session)) return new ModelAndView("index.jsp");

        if(!admincheck(session)) return new ModelAndView("error.jsp","model",createModel.getmodelerror("Only admin can update the data.",session));

        return new ModelAndView("addjourney.jsp","model",createModel.getmodelhome(session));
    }

    @RequestMapping("addJourney")
    public ModelAndView addjourney(
            @RequestParam("sourceid") int sourceid,
            @RequestParam("destinationid") int destinationid,
            @RequestParam(value="description", required = false) String description,
            HttpSession session)
    {
        if(!isloggedin(session)) return new ModelAndView("index.jsp");
        if(!admincheck(session)) return new ModelAndView("error.jsp","model",createModel.getmodelerror("Only admin can update the data.",session));

        int elementid = addBL.savejourney(sourceid,destinationid,description,session);
        if(elementid==-1) return new ModelAndView("error.jsp",createModel.getmodelerror("Invalid Data.",session));

        return new ModelAndView("redirect:searchJourney?elementid="+elementid);
    }

    @RequestMapping("addJourneyInfo")
    public ModelAndView addJourneyinfo(@RequestParam("elementid") int elementid,
                                     HttpSession session){

        if(!isloggedin(session)) return new ModelAndView("index.jsp");
        if(!admincheck(session)) return new ModelAndView("error.jsp","model",createModel.getmodelerror("Only admin can update the data.",session));

        return new ModelAndView("addjourneyinfo.jsp","model",addBL.getmodeledit(elementid,session));
    }

    @RequestMapping("addtransportjourney")
    public ModelAndView addtransport(
            @RequestParam(value = "elementid") int elementid,
            @RequestParam("transportname") String name,
            @RequestParam("rent") String rent,
            HttpSession session)
    {
        if(!isloggedin(session)) return new ModelAndView("index.jsp");
        if(!admincheck(session)) return new ModelAndView("error.jsp","model",createModel.getmodelerror("Only admin can update the data.",session));

        return new ModelAndView("addjourneyinfo.jsp","model",addBL.saveJourneytransport(elementid,name,rent,session));
    }

    @RequestMapping("deleteTransportJourney")
    public ModelAndView deleteTransport(@RequestParam("elementid") int elementid,
                                        @RequestParam("transportid") int transportid,
                                        HttpSession session)
    {
        if(!isloggedin(session)) return new ModelAndView("index.jsp");
        if(!admincheck(session)) return new ModelAndView("error.jsp","model",createModel.getmodelerror("Only admin can update the data.",session));

        return new ModelAndView("addjourneyinfo.jsp","model",addBL.deleteJourneyTransport(elementid,transportid,session));
    }

    @RequestMapping("/backtojourney")
    public ModelAndView gobackjourney(@RequestParam("elementid") int elementid,
                               HttpSession session){
        if(!isloggedin(session)) return new ModelAndView("index.jsp");
        return new ModelAndView("journeypage.jsp","model",searchBL.getJourney(elementid,session));
    }
}
