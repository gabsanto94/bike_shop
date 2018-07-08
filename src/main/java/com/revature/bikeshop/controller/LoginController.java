package com.revature.bikeshop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.bikeshop.model.User;
import com.revature.bikeshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService us;

    private ObjectMapper om = new ObjectMapper();

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String doLogin(@RequestParam("user") String username, @RequestParam("pass") String pwd, HttpSession session, HttpServletResponse response) throws JsonProcessingException
    {
        System.out.println("IM inside the doLogin()");
        System.out.println("user: " + username + " - " + pwd);
        User loggedUser = us.checkLogin(username, pwd);

        //check if user is there
        if(loggedUser != null){
            session.setAttribute("loggedUser", loggedUser);
            return om.writeValueAsString(loggedUser);
        }
        else{
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return "";
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public String getSession(HttpSession session, HttpServletResponse response) throws JsonProcessingException {
        User currentUser = (User) session.getAttribute("loggedUser");
        //check if user is there
        if(currentUser != null){
            session.setAttribute("loggedUser", currentUser);
            return om.writeValueAsString(currentUser);
        }
        else{
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }

        return "";

    }

    @RequestMapping(value = "/logout", method = RequestMethod.DELETE)
    @ResponseBody
    public String logout(HttpSession s){
        s.invalidate();
        return "successfully logged out";
    }

}
