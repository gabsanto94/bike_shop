package com.revature.bikeshop.services;

import com.revature.bikeshop.model.User;

public interface LoginService {

    public User login(String user, String pass);

}
