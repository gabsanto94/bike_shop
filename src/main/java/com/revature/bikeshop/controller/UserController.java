package com.revature.bikeshop.controller;

import com.revature.bikeshop.model.User;
import com.revature.bikeshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //MVC is trying to look for a view but if you put ResponseBody it will return the body.
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    private List<User> getUsers() {

        return userService.getAllUsers();

    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    private User getUser(@PathVariable int id){
        return userService.getUsersById(id);
    }



}
