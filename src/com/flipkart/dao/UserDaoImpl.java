package com.flipkart.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.model.*;
import com.flipkart.constant.SQLConstantQueries;
import com.flipkart.utils.DBUtil;

public class UserDaoImpl implements UserDao{
	
	
	
	//Initializing the logger
		private static Logger logger = Logger.getLogger(UserDaoImpl.class);
		
		public User validateUser(int username, String pass) {
			
			
			Connection connection = DBUtil.getConnection();
			
			 try {
				   
				    //Declaring prepared statement
		            PreparedStatement stmt = null;
		            stmt=connection.prepareStatement(SQLConstantQueries.VALIDATE_USER);
		            stmt.setInt(1, username);
		            stmt.setString(2,pass);
		            ResultSet rs = stmt.executeQuery();
		            
		            if(rs.next() )
		            {
		            	 User checkeduser = new User();
		            	 String profile= rs.getString("Role");
			             checkeduser.setUserId( rs.getInt("UserID") );
			             checkeduser.setUserEmail( rs.getString("EmailID") );
			             checkeduser.setUserPassword( rs.getString("Password") );
			             checkeduser.setProfile( rs.getString("Role") );
			             checkeduser.setName(rs.getString("Name"));
			             checkeduser.setPhoneNumber(rs.getInt("PhoneNumber"));
			             checkeduser.setGender(rs.getString("Gender"));
			             
			             
			             if(profile.equals("student")) {
			            	
			            	 checkeduser.setSemester(rs.getInt("Semester"));
			            	 checkeduser.setBranch(rs.getString("Branch"));
			            	 checkeduser.setRegistrationComplete(rs.getBoolean("IsRegistrationComplete"));
			            	 checkeduser.setRegisteredOn(rs.getString("RegisteredOn"));
			            	 checkeduser.setScholarshipAllowancePercentage(rs.getInt("ScholarshipAllowancePercentage"));
			            	
			             }
			             
			             else if(profile.equals("professor")) {
			            	 
			            	 checkeduser.setPosition(rs.getString("Position"));
			            	 
			             }
			               
			                return checkeduser;
		                
		            }
		            
		            
		        } catch (SQLException ex) {
		        	 logger.error(ex.getMessage());
		        }
			 return null;
		}
		
		public void createUser(User user)  {
			
			//Establishing the connection
			Connection connection = DBUtil.getConnection();
			
			 try {
				   //Declaring prepared statement and executing query
			        PreparedStatement stmt = connection.prepareStatement(SQLConstantQueries.INSERT_USER);
			        int userId= user.getUserId();
			        String emailId= user.getUserEmail();
			        String password= user.getUserPassword();
			        String profile= user.getProfile();
			        String name= user.getName();
			        int phoneNo= user.getPhoneNumber();
			        int semester= user.getSemester();
			        String branch=user.getBranch();
			        String position= user.getPosition();
			        String gender= user.getGender();
			        Boolean isRegistrationComplete= user.isRegistrationComplete();
			        String registeredOn= user.getRegisteredOn();
			        int ScholarshipAllowancePercentage= user.getScholarshipAllowancePercentage();
			        
			        stmt.setInt(1, userId);
			        stmt.setString(2, emailId);
			        stmt.setString(3, password);
			        stmt.setString(4, profile);
			        stmt.setString(5, name);
			        stmt.setInt(6, phoneNo);
			        stmt.setInt(7, semester);
			        stmt.setString(8, branch);
			        stmt.setString(9, position);
			        stmt.setString(10, gender);
			        stmt.setBoolean(11,isRegistrationComplete);
			        stmt.setString(12, registeredOn);
			        stmt.setInt(13,ScholarshipAllowancePercentage);
			       
			        //Executing query
			        stmt.executeUpdate();
			        logger.info(profile+" added!");
			      
			    } catch (SQLException ex) {
			    	 logger.error(ex.getMessage());
			    }
				
		}
		
		public void deleteUser(int userId) {
			
			//Establishing the connection
			Connection connection = DBUtil.getConnection();
			try {
				
				//Establishing the connection
	            PreparedStatement stmt = null;
	           
	            stmt=connection.prepareStatement(SQLConstantQueries.DELETE_USER+userId);
	            //Executing query
	            int rs = stmt.executeUpdate();
	            if(rs>0)
	            {
	               logger.info("User with id "+userId+" deleted !");
	               return;
	                
	            }
	        } catch (SQLException ex) {
	        	 logger.error(ex.getMessage());
	        }
			 logger.info("User not found !");
			
		}
		
		public void updateUser(int userId, User user ) {
			
			//Establishing the connection
			Connection connection = DBUtil.getConnection();
			
			 try {
				   //Declaring prepared statement and executing query
			        PreparedStatement stmt = connection.prepareStatement(SQLConstantQueries.UPDATE_USER);
			       
			        String emailId= user.getUserEmail();
			        String password= user.getUserPassword();
			        String profile= user.getProfile();
			        String name= user.getName();
			        int phoneNo= user.getPhoneNumber();
			        int semester= user.getSemester();
			        String branch=user.getBranch();
			        String position= user.getPosition();
			        String gender= user.getGender();
			        Boolean isRegistrationComplete= user.isRegistrationComplete();
			        String registeredOn= user.getRegisteredOn();
			        int ScholarshipAllowancePercentage= user.getScholarshipAllowancePercentage();
			       
			        stmt.setString(1, emailId);
			        stmt.setString(2, password);
			        stmt.setString(3, profile);
			        stmt.setString(4, name);
			        stmt.setInt(5, phoneNo);
			        stmt.setInt(6, semester);
			        stmt.setString(7, branch);
			        stmt.setString(8, position);
			        stmt.setInt(9, userId);
			        stmt.setString(10, gender);
			        stmt.setBoolean(11,isRegistrationComplete);
			        stmt.setString(12, registeredOn);
			        stmt.setInt(13,ScholarshipAllowancePercentage);
			       
			        //Executing query
			        stmt.executeUpdate();
			        logger.info("User updated!");
			      
			    } catch (SQLException ex) {
			    	 logger.error(ex.getMessage());
			    }
			
		}
		
public void updateUser1(User user ) {
			int userId= user.getUserId();
			//Establishing the connection
			Connection connection = DBUtil.getConnection();
			
			 try {
				   //Declaring prepared statement and executing query
			        PreparedStatement stmt = connection.prepareStatement(SQLConstantQueries.UPDATE_USER);
			        
			       
			        String emailId= user.getUserEmail();
			        String password= user.getUserPassword();
			        String profile= user.getProfile();
			        String name= user.getName();
			        int phoneNo= user.getPhoneNumber();
			        int semester= user.getSemester();
			        String branch=user.getBranch();
			        String position= user.getPosition();
			        String gender= user.getGender();
			        Boolean isRegistrationComplete= user.isRegistrationComplete();
			        String registeredOn= user.getRegisteredOn();
			        int ScholarshipAllowancePercentage= user.getScholarshipAllowancePercentage();
			       
			        stmt.setString(1, emailId);
			        stmt.setString(2, password);
			        stmt.setString(3, profile);
			        stmt.setString(4, name);
			        stmt.setInt(5, phoneNo);
			        stmt.setInt(6, semester);
			        stmt.setString(7, branch);
			        stmt.setString(8, position);
			       
			        stmt.setString(9, gender);
			        stmt.setBoolean(10,isRegistrationComplete);
			        stmt.setString(11, registeredOn);
			        stmt.setInt(12,ScholarshipAllowancePercentage);
			        stmt.setInt(13, userId);
			       
			        //Executing query
			        stmt.executeUpdate();
			        logger.info("User updated!");
			      
			    } catch (SQLException ex) {
			    	 logger.error(ex.getMessage());
			    }
			
		}
		
		public List<User> displayUsers(String profile) {
			
			Connection connection= DBUtil.getConnection();
			
			try {
				
				PreparedStatement stmt= null;
				stmt= connection.prepareStatement(SQLConstantQueries. DISPLAY_USERS);
				stmt.setString(1,profile);
				
		            
		         ResultSet rs = stmt.executeQuery();
		         
		         List<User> list= new ArrayList<User>();
		            
		            //Creating ArrayList of customers
		            while(rs.next())
		            {
		            	User user = new User();
		            	user.setUserId(rs.getInt("UserID"));
		            	user.setUserEmail(rs.getString("EmailID"));
		            	user.setUserPassword(rs.getString("Password"));
		            	user.setName(rs.getString("Name"));
		            	user.setPhoneNumber(rs.getInt("PhoneNumber"));
		            	user.setSemester(rs.getInt("Semester"));
		            	user.setBranch(rs.getString("Branch"));
		            	user.setPosition(rs.getString("Position"));
		            	user.setGender(rs.getString("Gender"));
		            	user.setRegistrationComplete(rs.getBoolean("IsRegistrationComplete"));
		            	user.setRegisteredOn(rs.getString("RegisteredOn"));
		                
		                list.add(user);
		                  
		            }
		            
		            //returning list of customers in database
		            return list;
			}
			catch(SQLException ex) {
				logger.error(ex.getMessage());
			}
			return null;
		}
		
//extra function
public List<User> displayUsers() {
			
			Connection connection= DBUtil.getConnection();
			
			try {
				
				PreparedStatement stmt= null;
				stmt= connection.prepareStatement(SQLConstantQueries. DISPLAY_USERS);
				stmt.setString(1,"student");
				
		            
		         ResultSet rs = stmt.executeQuery();
		         
		         List<User> list= new ArrayList<User>();
		            
		            //Creating ArrayList of customers
		            while(rs.next())
		            {
		            	User user = new User();
		            	user.setUserId(rs.getInt("UserID"));
		            	user.setUserEmail(rs.getString("EmailID"));
		            	user.setUserPassword(rs.getString("Password"));
		            	user.setName(rs.getString("Name"));
		            	user.setPhoneNumber(rs.getInt("PhoneNumber"));
		            	user.setSemester(rs.getInt("Semester"));
		            	user.setBranch(rs.getString("Branch"));
		            	user.setPosition(rs.getString("Position"));
		            	user.setGender(rs.getString("Gender"));
		            	user.setRegistrationComplete(rs.getBoolean("IsRegistrationComplete"));
		            	user.setRegisteredOn(rs.getString("RegisteredOn"));
		                
		                list.add(user);
		                  
		            }
		            
		            //returning list of customers in database
		            return list;
			}
			catch(SQLException ex) {
				logger.error(ex.getMessage());
			}
			return null;
		}
		

		
		

		


		
		
		

}
