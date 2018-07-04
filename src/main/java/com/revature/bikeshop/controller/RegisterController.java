package com.revature.bikeshop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.bikeshop.model.User;
import com.revature.bikeshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;


@Controller
public class RegisterController {

    private ObjectMapper om = new ObjectMapper();

    @Autowired
    private UserService userService;

    @RequestMapping(value="/register", method=RequestMethod.GET)
    @ResponseBody
    public String getUser() throws JsonProcessingException {

        return "hello from the register controller";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    private @ResponseBody String registerUser(@RequestBody User u) {

        System.out.println(u);
        //userService.addUser(u);

        return "redirect:home";
    }

}
