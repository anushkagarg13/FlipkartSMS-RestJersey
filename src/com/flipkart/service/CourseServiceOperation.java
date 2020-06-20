package com.flipkart.service;



//import org.apache.log4j.Logger;

import com.flipkart.dao.CourseDao;
import com.flipkart.dao.CourseDaoImpl;

import com.flipkart.model.User;

public class CourseServiceOperation implements CourseServiceInterface {
	
//	//create logger instance here
//		private static Logger logger = Logger.getLogger(CourseServiceOperation.class);
//		
		CourseDao coursedao= new CourseDaoImpl();
		
		public void addCourse(int courseId, User user) {
			coursedao.addCourse(courseId, user);
		}
		
		public void dropCourse(int courseId,User user) {
			coursedao.dropCourse(courseId, user);
		}
		
		 public void selectCourse(int courseId ,User user) {
			 coursedao.selectCourse(courseId, user);
		 }
		 public void deselectCourse(int courseId, User user) {
			 coursedao.deselectCourse(courseId, user);
		 }
		
		

}
