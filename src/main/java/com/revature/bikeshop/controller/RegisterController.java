package com.revature.bikeshop.controller;

import com.revature.bikeshop.model.User;
import com.revature.bikeshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/register", method=RequestMethod.GET)
    public @ResponseBody String registerUser() {

        return "hello from the register controller";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody User registerUser(@RequestBody User u) {

        //set user to the addresses
        u.getBillingAddress().setUser(u);
        u.getShippingAddress().setUser(u);

        userService.addUser(u);

        return u;
    }

}
