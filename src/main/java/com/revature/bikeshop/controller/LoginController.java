package com.revature.bikeshop.controller;

import com.revature.bikeshop.model.LoginInfo;
import com.revature.bikeshop.model.User;
import com.revature.bikeshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/login")
//@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    @Autowired
    private UserService us;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody LoginInfo login(HttpSession session) {
        return (LoginInfo) session.getAttribute("loggedUser");
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody LoginInfo login(@RequestParam("user") String username, @RequestParam("pass") String password, HttpSession session){
        System.out.println(username + " " + password);
        User u = us.checkLogin(username, password);
        if(u == null){
            return null;
        }

        LoginInfo loggedUser = new LoginInfo(u);
        session.setAttribute("loggedUser", loggedUser);

        return loggedUser;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public @ResponseBody void logout(HttpSession session) {
        session.invalidate();
    }

}
