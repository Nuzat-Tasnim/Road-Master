package com.example.mydemo.PL;

import com.example.mydemo.BL.CreateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@Controller
public class HomePL {
    @Autowired
    CreateModel createModel;

    public boolean isloggedin(HttpSession session){
        return session.getAttribute("user")!=null;
    }

    @RequestMapping("/")
    public ModelAndView index(HttpSession session){
        if(isloggedin(session)) return new ModelAndView("home.jsp", "model", createModel.getmodelhome(session));
        return new ModelAndView("index.jsp");
    }


    @RequestMapping("/home")
    public String home() {
        return "redirect:/";
    }
}
