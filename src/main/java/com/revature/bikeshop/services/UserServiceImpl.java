package com.revature.bikeshop.services;

import com.revature.bikeshop.dao.UserDAO;
import com.revature.bikeshop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDao;

    @Override
    public void addUser(User user) {
        System.out.println("im inside the service" + user);
        userDao.addUser(user);
    }

    @Override
    public User getUsersById(int userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User checkLogin(String username, String password) {
        return userDao.getUser(username, password);
    }

}
