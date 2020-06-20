package com.flipkart.service;






import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.dao.UserDao;
import com.flipkart.dao.UserDaoImpl;

import com.flipkart.model.User;

public class UserServiceOperation implements UserServiceInterface {
	
        //create logger instance here
		private static Logger logger = Logger.getLogger(UserServiceOperation.class);
//		
		UserDao userDao= new UserDaoImpl();
		
		
		
		public User validateUser(int username, String password) {
			return userDao.validateUser(username, password)	;
				
		}
		
		public void createUser(User user) {
			userDao.createUser(user);
		}
		public void deleteUser(int userId) {
			userDao.deleteUser(userId);
		}
		public void updateUser(int userId, User user ) {
			userDao.updateUser(userId, user);
		}
		public void updateUser( User user ) {
			userDao.updateUser1(user);
		}
		
		public void displayUsers(String profile) {
			logger.info("************List Of "+profile+"s**************");
			
			List<User> users = userDao.displayUsers(profile);
			
			users.stream().forEach(user -> {
				if(user.getGender().equals("female"))
					user.setName("Ms "+ user.getName() );
				else
					user.setName("Mr "+ user.getName() );
			});
			
			if(profile.equals("student")){
				logger.info("USER ID      NAME           EMAILID         PASSWORD    PHONE NUMBER    BRANCH   SEMESTER    ");
			for(User user: users) {
				logger.info(user.getUserId()+"         "+user.getName()+"          "+user.getUserEmail()+"       "+user.getUserPassword()+"         "+user.getPhoneNumber()+"        "+user.getBranch()+"        "+user.getSemester());
			}
			}
			
			else if(profile.equals("professor")){
				logger.info("USER ID      NAME           EMAILID         PASSWORD    PHONE NUMBER    POSITION   ");
				for(User user: users) {
					logger.info(user.getUserId()+"         "+user.getName()+"          "+user.getUserEmail()+"       "+user.getUserPassword()+"         "+user.getPhoneNumber()+"        "+user.getPosition());
				
				}
			
		}
			else {
				logger.info("USER ID      NAME           EMAILID         PASSWORD    PHONE NUMBER      ");
				for(User user: users) {
					logger.info(user.getUserId()+"         "+user.getName()+"          "+user.getUserEmail()+"       "+user.getUserPassword()+"         "+user.getPhoneNumber());
				
				}
				
			}
		
		}
		
		public List<User> displayStudents(){
			return userDao.displayUsers();
		}
	

}
