package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.constant.SQLConstantQueries;
import com.flipkart.model.Courses;
import com.flipkart.model.User;
import com.flipkart.utils.DBUtil;

public class GradeDaoImpl implements GradeDao {
	
	//Initializing the logger
			private static Logger logger = Logger.getLogger(CourseDaoImpl.class);
			
	
	public List<Courses> displayGrades(User user) {

		Connection connection= DBUtil.getConnection();
		
		try {
			
			PreparedStatement stmt= null;
			stmt= connection.prepareStatement(SQLConstantQueries.VIEW_GRADES);
			 stmt.setInt(1, user.getUserId());
	       
	            
	         ResultSet rs = stmt.executeQuery();
	         
	         List<Courses> list= new ArrayList<Courses>();
	            
	            //Creating ArrayList of customers
	            while(rs.next())
	            {
	                Courses course = new Courses();
	                course.setBranch(user.getBranch());
	                course.setSemester(user.getSemester());
	                course.setCourseId(rs.getInt("CourseID"));
	                course.setCourseName(rs.getString("Title"));
	                course.setCourseDescription(rs.getString("Description"));
	                course.setTime_stamp(rs.getString("TIME_STAMP"));
	                course.setGrade(rs.getString("Grade"));
	                
	               
	                list.add(course);
	                  
	            }
	            
	            //returning list of customers in database
	            return list;
		}
		catch(SQLException ex) {
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	public void uploadGrades(int studentId, int courseId, String grade) {
		//Establishing the connection
		Connection connection = DBUtil.getConnection();
		
		 try {
			   //Declaring prepared statement and executing query
		        PreparedStatement stmt = connection.prepareStatement(SQLConstantQueries.UPLOAD_GRADES);
	
		       
		        stmt.setString(1, grade);
		        stmt.setInt(2, studentId);
		        stmt.setInt(3, courseId);
		       
		       
		        //Executing query
		        stmt.executeUpdate();
		        logger.info("Grade uploaded");
		      
		    } catch (SQLException ex) {
		    	 logger.error(ex.getMessage());
		    }
		
	}
}
