package com.flipkart.dao;

import java.util.List;


import com.flipkart.model.User;

public interface UserDao {
	public User validateUser(int username, String password);
	public void createUser(User user);
	public void deleteUser(int userId) ;
	public void updateUser(int userId, User user );
	public List<User> displayUsers(String profile);
	public List<User> displayUsers();
	public void updateUser1(User user ) ;
	

}
