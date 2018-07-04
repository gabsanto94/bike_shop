package com.revature.bikeshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(HttpSession s){
        return "static/home.html";

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession s){
        s.invalidate();
        return "redirect:login";
    }

}
