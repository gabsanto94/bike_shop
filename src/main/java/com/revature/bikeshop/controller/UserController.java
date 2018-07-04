package com.revature.bikeshop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.bikeshop.model.User;
import com.revature.bikeshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private ObjectMapper om = new ObjectMapper();

    @Autowired
    private UserService userService;

    //MVC is trying to look for a view but if you put ResponseBody it will return the body.
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    private @ResponseBody String getUsers() throws JsonProcessingException {
        System.out.println("im in here");
        //return userService.getAllUsers();

        User u = new User("gabriel", "santos");
        System.out.println("im in here 2");
        System.out.println(u);
        System.out.println(om.writeValueAsString(u));
        return om.writeValueAsString(u);

    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET,
            headers = "Accept-application/xml, application/json")
    private @ResponseBody User getUser(@PathVariable int id){
        return userService.getUsersById(id);
    }



}
