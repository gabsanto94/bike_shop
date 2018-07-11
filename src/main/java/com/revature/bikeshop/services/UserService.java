package com.revature.bikeshop.services;

import com.revature.bikeshop.model.User;

import java.util.List;

public interface UserService {

    void addUser (User user);

    User getUsersById (int userId);

    User getUserByUsername(String username);

    boolean updateUser(User user);

    void removeUser(int id);

    List<User> getAllUsers();

    User checkLogin(String username, String password);

}
