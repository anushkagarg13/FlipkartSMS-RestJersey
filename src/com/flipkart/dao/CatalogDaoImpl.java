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

public class CatalogDaoImpl implements CatalogDao {
	
	        //Initializing the logger
			private static Logger logger = Logger.getLogger(UserDaoImpl.class);
			
			
			public List<Courses> displayCourses(User user) {
				
				Connection connection= DBUtil.getConnection();
				
				try {
					
					PreparedStatement stmt= null;
					int semester= user.getSemester();
					String branch= user.getBranch();
					stmt= connection.prepareStatement(SQLConstantQueries.DISPLAY_COURSES);
					 stmt.setInt(1, semester);
			         stmt.setString(2,branch);
			            
			         ResultSet rs = stmt.executeQuery();
			         
			         List<Courses> list= new ArrayList<Courses>();
			            
			            //Creating ArrayList of customers
			            while(rs.next())
			            {
			                Courses course = new Courses();
			                course.setBranch(branch);
			                course.setSemester(semester);
			                course.setCourseId(rs.getInt("CourseID"));
			                course.setCourseName(rs.getString("Title"));
			                course.setCourseDescription(rs.getString("Description"));
			                course.setStudentsEnrolled(rs.getInt("StudentsEnrolled"));
			                course.setProfessorId(rs.getInt("Faculty"));
			                
			               
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
			
public List<Courses> displayCoursesProfessor(User user) {
				
				Connection connection= DBUtil.getConnection();
				
				try {
					
					PreparedStatement stmt= null;
					
					stmt= connection.prepareStatement(SQLConstantQueries.DISPLAY_COURSES_PROFESSOR);
					
			            
			         ResultSet rs = stmt.executeQuery();
			         
			         List<Courses> list= new ArrayList<Courses>();
			            
			            //Creating ArrayList of customers
			            while(rs.next())
			            {
			                Courses course = new Courses();
			                course.setBranch(rs.getString("Branch"));
			                course.setSemester(rs.getInt("Semester"));
			                course.setCourseId(rs.getInt("CourseID"));
			                course.setCourseName(rs.getString("Title"));
			                course.setCourseDescription(rs.getString("Description"));
			                course.setStudentsEnrolled(rs.getInt("StudentsEnrolled"));
			                course.setProfessorId(rs.getInt("Faculty"));
			                
			               
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
			
			public void insertCourse(Courses course)  {
				
				//Establishing the connection
				Connection connection = DBUtil.getConnection();
				
				 try {
					   //Declaring prepared statement and executing query
				        PreparedStatement stmt = connection.prepareStatement(SQLConstantQueries.INSERT_COURSE);
				        int courseID= course.getCourseId();
				        String title= course.getCourseName();
				        String description= course.getCourseDescription();
				        int semester= course.getSemester();
				        String branch=course.getBranch();
				       
				        
				        stmt.setInt(1, courseID);
				        stmt.setString(2, title);
				        stmt.setString(3, description);
				        stmt.setInt(4, semester);
				        stmt.setString(5,branch);
				      
				       
				        //Executing query
				        stmt.executeUpdate();
				        logger.info("Course added!");
				      
				    } catch (SQLException ex) {
				    	 logger.error(ex.getMessage());
				    }
					
			}
			
		public void deleteCourse(int courseId) {
				
				//Establishing the connection
				Connection connection = DBUtil.getConnection();
				try {
					
					//Establishing the connection
		            PreparedStatement stmt = null;
		           
		            stmt=connection.prepareStatement(SQLConstantQueries.DELETE_COURSE+courseId);
		            //Executing query
		            int rs = stmt.executeUpdate();
		            if(rs>0)
		            {
		               logger.info("Course with courseId "+courseId+" deleted !");
		               return;
		                
		            }
		        } catch (SQLException ex) {
		        	 logger.error(ex.getMessage());
		        }
				 logger.info("Course not found !");
				
			}
		
		public List<Courses> displaySelectedCourses(User user) {
			
			Connection connection= DBUtil.getConnection();
			
			try {
				
				PreparedStatement stmt= null;
				stmt= connection.prepareStatement(SQLConstantQueries.VIEW_SELECTED_COURSES);
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
		
		public List<Courses> displaySelectedCoursesProfessor(User user) {
			
			Connection connection= DBUtil.getConnection();
			
			try {
				
				PreparedStatement stmt= null;
				
				stmt= connection.prepareStatement(SQLConstantQueries.DISPLAY_PROFESSOR_SELECTED_COURSES);
				stmt.setInt(1, user.getUserId());
				
		            
		         ResultSet rs = stmt.executeQuery();
		         
		         List<Courses> list= new ArrayList<Courses>();
		            
		            //Creating ArrayList of customers
		            while(rs.next())
		            {
		                Courses course = new Courses();
//		                course.setBranch(rs.getString("Branch"));
//		                course.setSemester(rs.getInt("Semester"));
		                course.setCourseId(rs.getInt("CourseID"));
		                course.setCourseName(rs.getString("Title"));
//		                course.setCourseDescription(rs.getString("Description"));
		                course.setStudentsEnrolled(rs.getInt("StudentsEnrolled"));
//		                course.setProfessorId(rs.getInt("Faculty"));
		                
		               
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
			
			
	


}
