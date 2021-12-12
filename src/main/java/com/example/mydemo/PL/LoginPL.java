package com.example.mydemo.PL;

import com.example.mydemo.BL.CreateModel;
import com.example.mydemo.DAL.User;
import com.example.mydemo.BL.LoginBL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LoginPL {

    @Autowired
    LoginBL loginbl;
    @Autowired
    CreateModel createModel;

    public boolean isloggedin(HttpSession session){
        return session.getAttribute("user")!=null;
    }

    @RequestMapping("/loginform")
    public ModelAndView display(HttpSession session){
        if(isloggedin(session)) return new ModelAndView("home.jsp","model",createModel.getmodelhome(session));

        return new ModelAndView("login.jsp");
    }

    @RequestMapping(value = "login")
    public ModelAndView login(
            @RequestParam("mail") String email,
            @RequestParam("pass") String password,
            HttpSession session)
    {
        User user = loginbl.loggingin(email,password,session);
        if(user!=null) {
            return new ModelAndView("redirect:/");
        }
        else{
            return new ModelAndView("authentication.jsp");
        }
    }

    @RequestMapping(value = "logout")
    public String logout(HttpSession session) {
        loginbl.logout(session);
        return "redirect:/";
    }
}