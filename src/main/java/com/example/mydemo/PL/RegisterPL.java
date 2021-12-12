package com.example.mydemo.PL;

import com.example.mydemo.DAL.User;
import com.example.mydemo.BL.CreateModel;
import com.example.mydemo.BL.RegisterBL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class RegisterPL {

    @Autowired
    RegisterBL regBL;


    public boolean isloggedin(HttpSession session){
        return session.getAttribute("user")!=null;
    }

    @RequestMapping("/register")
    public ModelAndView display(HttpSession session){
        if(isloggedin(session)) return new ModelAndView("home.jsp","model",regBL.getmodelhome(session));
        return new ModelAndView("register.jsp");
    }

    @RequestMapping("/addUser")
    public ModelAndView addUser(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("confPass") String confPass,
            HttpSession session)
    {
        if(isloggedin(session)) return new ModelAndView("redirect:/home");

        User user = regBL.register(name,email,password,confPass,session);

        if(user!=null){
            return new ModelAndView("redirect:/home");
        }
        else{
            return new ModelAndView("authentication.jsp");
        }
    }
}

