package com.revature.bikeshop.controller;

import com.revature.bikeshop.model.User;
import com.revature.bikeshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//might not need the cross origin
@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService us;

    //MVC is trying to look for a view but if you put ResponseBody it will return the body.
    @RequestMapping(value = "admin/users", method = RequestMethod.GET)
    @ResponseBody
    private List<User> getUsers() {
        return us.getAllUsers();
    }

    @RequestMapping(value = "admin/users/{id}", method = RequestMethod.GET)
    @ResponseBody
    private User getUser(@PathVariable int id){
        return us.getUsersById(id);
    }

    @RequestMapping(value = "admin/users/{id}", method = RequestMethod.PUT)
    @ResponseBody
    private String updateUser(@RequestBody User user, @PathVariable int id){

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

    @RequestMapping(value = "admin/users/{id}", method = RequestMethod.DELETE)
    private void deleteUser(@PathVariable int id){
        us.removeUser(id);
    }


    //************** CUSTOMER ***********

}
