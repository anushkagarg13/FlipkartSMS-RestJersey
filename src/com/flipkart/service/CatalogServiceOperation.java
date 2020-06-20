package com.flipkart.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.dao.CatalogDao;
import com.flipkart.dao.CatalogDaoImpl;
import com.flipkart.dao.RegistrationDao;
import com.flipkart.dao.RegistrationDaoImpl;
import com.flipkart.model.*;

public class CatalogServiceOperation implements CatalogServiceInterface {
	
	//create logger instance here
			private static Logger logger = Logger.getLogger(CourseServiceOperation.class);
			
			CatalogDao catalogdao= new CatalogDaoImpl();
			
			public void displayCourses(User user) {
				logger.info("************List Of Courses**************");
				
				if(user.getProfile().equals("student")) {
				logger.info("COURSE ID      COURSE TITLE                          COUSRE DESCRIPTION");
				List<Courses> courses = catalogdao.displayCourses(user);
				for(Courses course:courses) {
					if(course.getStudentsEnrolled()<10) {
						logger.info(course.getCourseId()+"               "+course.getCourseName()+"               "+course.getCourseDescription());
					}
				}
				
				}
				
				else if(user.getProfile().equals("professor")) {
					logger.info("COURSE ID      COURSE TITLE                          COUSRE DESCRIPTION             ");
					List<Courses> courses = catalogdao.displayCoursesProfessor(user);
					
					for(Courses course:courses) {
						if(course.getProfessorId()==0) {
							logger.info(course.getCourseId()+"               "+course.getCourseName()+"               "+course.getCourseDescription());
						}
					}
					
				}
//				courses.forEach(course -> logger.info(course.getCourseId()+"               "+course.getCourseName()+"               "+course.getCourseDescription()));
				
			
			}
			
			public void insertCourse(Courses course) {
				catalogdao.insertCourse(course);
			}
			public void deleteCourse(int courseId) {
				catalogdao.deleteCourse(courseId);
			}
			
			public void displaySelectedCourses(User user) {
				logger.info("***********************************LIST OF SELECTED COURSES******************************");	
				logger.info("COURSE ID      COURSE TITLE                          COUSRE DESCRIPTION                        TIME STAMP");
				List<Courses> courses = catalogdao.displaySelectedCourses(user);
				RegistrationDao registrationDao= new RegistrationDaoImpl();
				courses.forEach(course -> logger.info(course.getCourseId()+"               "+course.getCourseName()+"               "+course.getCourseDescription()+"               "+course.getTime_stamp()));
				boolean status= registrationDao.getRegistrationStatus(user);
				if(status)
					logger.info("++++++++++++++++++++++++++++REGISTRATION STATUS: COMPLETED ++++++++++++++++++++++++++++");
				else
					logger.info("++++++++++++++++++++++++++++REGISTRATION STATUS: PENDING ++++++++++++++++++++++++++++++");
			
			}
			
			public void displaySelectedCoursesProfessor(User user){
				
				logger.info("***********************************LIST OF SELECTED COURSES******************************");	
				logger.info("COURSE ID      COURSE TITLE                         NUMBER OF STUDENTS ENROLLED");
				List<Courses> courses = catalogdao.displaySelectedCoursesProfessor(user);
				
				courses.forEach(course -> logger.info(course.getCourseId()+"               "+course.getCourseName()+"                               "+course.getStudentsEnrolled()));
				
			}
			
			
			
	
	
	

}

