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
        userDao.addUser(user);
    }

    @Override
    public User getUsersById(int userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public User getUserByUsername(String username){
        return userDao.getUser(username);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public void removeUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public List<User> getAllUsers() {

        System.out.println("im in the services implementation");
        return userDao.getAllUsers();
    }

    @Override
    public User checkLogin(String username, String password) {
        return userDao.getUser(username, password);
    }


}
