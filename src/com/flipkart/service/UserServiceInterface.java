package com.flipkart.service;


import java.util.List;

import com.flipkart.model.User;

public interface UserServiceInterface  {
	
	public User validateUser(int username, String password);
	public void createUser(User user);
	public void deleteUser(int userId) ;
	public void updateUser(int userId, User user );
	public void displayUsers(String profile);
	public List<User> displayStudents();
	public void updateUser( User user );

}
