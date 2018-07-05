package com.revature.bikeshop.services;

import com.revature.bikeshop.model.User;

import java.util.List;

public interface UserService {

    void addUser (User user);

    User getUsersById (int userId);

    List<User> getAllUsers();

    User getUserByUsername (String username);

    User checkLogin(String username, String password);

}
