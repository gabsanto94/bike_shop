package com.revature.bikeshop.controller;

import com.revature.bikeshop.model.User;
import com.revature.bikeshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class UserController {

    @Autowired
    private UserService us;

    //MVC is trying to look for a view but if you put ResponseBody it will return the body.
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUsers() {

        System.out.println("im inside the get users to get all the users");
        return us.getAllUsers();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable int id){
        System.out.println("im inside the get users to get specific user");
        return us.getUsersById(id);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String updateUser(@RequestBody User user, @PathVariable int id){

        boolean isUserUpdated = false;

        //check to see if we have the same data - not letting user give us 5 and we  have a customer 3
        if(id == user.getUserId()){
            us.updateUser(user);
            isUserUpdated = true;
        }

        if(isUserUpdated){
            return "200";
        }

        //if nothing send bad request

        return "fail";
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable int id){
        us.removeUser(id);
    }


}
