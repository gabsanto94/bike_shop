package com.revature.bikeshop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.bikeshop.model.User;
import com.revature.bikeshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService us;

    private ObjectMapper om = new ObjectMapper();

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String doLogin(@RequestHeader("Authorization") String token, Authentication authentication, HttpServletResponse response) throws JsonProcessingException
    {

        System.out.println("my token" + token);

        return om.writeValueAsString(authentication);

    }

    @RequestMapping(value = "/logout", method = RequestMethod.DELETE)
    @ResponseBody
    public String logout(HttpSession s){
        return "successfully logged out";
    }

}
