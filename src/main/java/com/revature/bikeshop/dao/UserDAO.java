package com.revature.bikeshop.dao;

import java.util.List;
import com.revature.bikeshop.model.User;

public interface UserDAO {
	
	public List<User> getAllUsers();
	public User getUserbyUsername(String username);
	public boolean addUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(String username);
	public boolean containsUser(String username);
	public boolean containsEmail(String email);

}
