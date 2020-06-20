package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.flipkart.constant.SQLConstantQueries;

import com.flipkart.model.User;
import com.flipkart.utils.DBUtil;

public class CourseDaoImpl implements CourseDao {
	
	//Initializing the logger
		private static Logger logger = Logger.getLogger(CourseDaoImpl.class);
		
		public void addCourse(int courseId ,User user)  {
			
			//Establishing the connection
			Connection connection = DBUtil.getConnection();
			
			 try {
				   //Declaring prepared statement and executing query
			        PreparedStatement stmt = connection.prepareStatement(SQLConstantQueries.ADD_COURSE);
		
			        int userId= user.getUserId();
			        stmt.setString(1, null);
			        stmt.setInt(2, userId);
			        stmt.setInt(3, courseId);
			       
			       
			        //Executing query
			        stmt.executeUpdate();
			        logger.info("Course with courseId="+courseId+" added!");
			      
			    } catch (SQLException ex) {
			    	 logger.error(ex.getMessage());
			    }
			
			    
			
		}
		
		public void dropCourse(int courseId, User user) {
			
			//Establishing the connection
			Connection connection = DBUtil.getConnection();
			try {
				
				//Establishing the connection
	            PreparedStatement stmt = null;
	           
	            stmt=connection.prepareStatement(SQLConstantQueries.DROP_COURSE);
	            int userId= user.getUserId();
	            stmt.setInt(1, userId);
		        stmt.setInt(2, courseId);
	            //Executing query
	            int rs = stmt.executeUpdate();
	            if(rs>0)
	            {
	               logger.info("Course dropped !");
	               return;
	                
	            }
	        } catch (SQLException ex) {
	        	 logger.error(ex.getMessage());
	        }
			 logger.info("Course not found !");
			
		}
		
  public void selectCourse(int courseId ,User user)  {
			
			//Establishing the connection
			Connection connection = DBUtil.getConnection();
			
			 try {
				   //Declaring prepared statement and executing query
			        PreparedStatement stmt = connection.prepareStatement(SQLConstantQueries.SELECT_COURSE);
		
			        int userId= user.getUserId();
			        
			        stmt.setInt(1, userId);
			        stmt.setInt(2, courseId);
			       
			       
			        //Executing query
			        stmt.executeUpdate();
			        logger.info("Course with courseId="+courseId+" selected to teach!");
			      
			    } catch (SQLException ex) {
			    	 logger.error(ex.getMessage());
			    }
			
			    
			
		}
  
  public void deselectCourse(int courseId, User user) {
		
		//Establishing the connection
		Connection connection = DBUtil.getConnection();
		try {
			
			//Establishing the connection
          PreparedStatement stmt = null;
         
          stmt=connection.prepareStatement(SQLConstantQueries.DESELECT_COURSE);
        
	        stmt.setInt(1, courseId);
          //Executing query
          int rs = stmt.executeUpdate();
          if(rs>0)
          {
             logger.info("Course deselected !");
             return;
              
          }
      } catch (SQLException ex) {
      	 logger.error(ex.getMessage());
      }
		 logger.info("Course not found !");
		
	}
		
		

}
