package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.constant.SQLConstantQueries;

import com.flipkart.model.User;
import com.flipkart.utils.DBUtil;

public class RegistrationDaoImpl implements RegistrationDao {

	//Initializing the logger
	private static Logger logger = Logger.getLogger(RegistrationDaoImpl.class);

	public boolean numberOfCoursesSelected (User user) {

		//Establishing the connection
		Connection connection = DBUtil.getConnection();

		try {
			//Declaring prepared statement and executing query
			PreparedStatement stmt = connection.prepareStatement(SQLConstantQueries.NUMBER_OF_COURSES_SELECTED);

			int userId= user.getUserId();
			stmt.setInt(1, userId);

			//Executing query
			ResultSet rs= stmt.executeQuery();
			if(rs.next()) {
				int number= rs.getInt("count(CourseID)");
				if(number==4)
					return true;
			}


		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return false;


	}

	public void submitRegistration (User user) {
		//1.set boolean
		user.setRegistrationComplete(true);


		//Establishing the connection
		Connection connection = DBUtil.getConnection();

		try {

			//2. update user database
			//Declaring prepared statement and executing query
			PreparedStatement stmt = connection.prepareStatement(SQLConstantQueries.UPDATE_REGISTARTION_STATUS);
			int userId= user.getUserId();
		     stmt.setInt(1, userId);

			//Executing query
			stmt.executeUpdate();
			
			//3. Copy contents in final registration table
			 stmt = connection.prepareStatement(SQLConstantQueries.REGISTRATION_OF_COURSES);
			
		     stmt.setInt(1, userId);
			 stmt.executeUpdate();
			 
			 //4. Increment in course catalog
			
			 stmt = connection.prepareStatement(SQLConstantQueries. UPDATE_ENROLLED_STUDENTS_NUMBER);
				
		     stmt.setInt(1, userId);
			 stmt.executeUpdate();



		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}





	}
	
	public boolean getRegistrationStatus(User user) {
		
		//Establishing the connection
		Connection connection = DBUtil.getConnection();

		try {
			//Declaring prepared statement and executing query
			PreparedStatement stmt = connection.prepareStatement(SQLConstantQueries.SHOW_REGISTRATION_STATUS);

			int userId= user.getUserId();
			stmt.setInt(1, userId);

			//Executing query
			ResultSet rs= stmt.executeQuery();
			if(rs.next()) 
				return rs.getBoolean("IsRegistrationComplete");


		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return false;
	}
	
	public List<Integer> displayRegisteredStudentsInCourse(int courseId) {
		
		Connection connection= DBUtil.getConnection();
		
		try {
			
			PreparedStatement stmt= null;
			stmt= connection.prepareStatement(SQLConstantQueries.VIEW_ENROLLED_COURSES);
			 stmt.setInt(1, courseId);
	       
	            
	         ResultSet rs = stmt.executeQuery();
	         
	         List<Integer> list= new ArrayList<Integer>();
	            
	            //Creating ArrayList of customers
	            while(rs.next())
	            {
	                
	                int studentId= rs.getInt("UserID");
	                
	               
	                list.add(studentId);
	                  
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
