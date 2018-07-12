package com.revature.bikeshop.controller;

import com.revature.bikeshop.model.User;
import com.revature.bikeshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping(/*value="/register", */method=RequestMethod.GET)
    public @ResponseBody String registerUser(UsernamePasswordAuthenticationToken myToken) {

        System.out.println("MyToken GetPrincipal: " + myToken.getPrincipal());
        System.out.println("MyToken GetCredential: " +myToken.getCredentials());
        System.out.println("MyToken GetAuthorities: " +myToken.getAuthorities());
        System.out.println("MyToken GetName: " +myToken.getName());
        System.out.println("MyToken KEY: " +myToken.getDetails());

        return "hello from the register controller";
    }

    @RequestMapping(/*value = "/register", */method = RequestMethod.POST)
    public @ResponseBody User registerUser(@RequestBody User u) {

        System.out.println("USER: " + u);

        //set user to the addresses
        u.getBillingAddress().setUser(u);
        u.getShippingAddress().setUser(u);

        userService.addUser(u);

        return u;
    }

}
