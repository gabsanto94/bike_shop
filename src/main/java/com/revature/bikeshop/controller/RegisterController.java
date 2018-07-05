package com.revature.bikeshop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.bikeshop.model.BillingAddress;
import com.revature.bikeshop.model.ShippingAddress;
import com.revature.bikeshop.model.User;
import com.revature.bikeshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class RegisterController {

    private ObjectMapper om = new ObjectMapper();

    @Autowired
    private UserService userService;

    @RequestMapping(value="/register", method=RequestMethod.GET)
    public @ResponseBody String registerUser(HttpSession session) {

        //initialize objects
        User user = new User();
        BillingAddress ba = new BillingAddress();
        ShippingAddress sa = new ShippingAddress();

        user.setBillingAddress(ba);
        user.setShippingAddress(sa);

        //session.setAttribute("user", user);

        System.out.println("I am initializing stuff" + user);

        return "hello from the register controller";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody String registerUser(@RequestBody User u) {

        System.out.println("im response" + u);

        userService.addUser(u);

        System.out.println("after insert" + u);

        return "redirect: home";
    }

}
