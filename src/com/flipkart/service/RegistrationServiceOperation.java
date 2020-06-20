package com.flipkart.service;

import java.util.List;

import org.apache.log4j.Logger;

//import org.apache.log4j.Logger;


import com.flipkart.dao.RegistrationDao;
import com.flipkart.dao.RegistrationDaoImpl;
import com.flipkart.model.Courses;
import com.flipkart.model.User;

public class RegistrationServiceOperation implements RegistrationServiceInterface {
	
	RegistrationDao registrationDao= new RegistrationDaoImpl();
	private static Logger logger = Logger.getLogger(CourseServiceOperation.class);

	@Override
	public boolean checkCourseSelectionStatus(User user) {
		
		return registrationDao.numberOfCoursesSelected(user);
	}
	
	public void submitRegistration (User user) {
		 registrationDao.submitRegistration (user);
	}
	
//	//create logger instance here
//	private static Logger logger = Logger.getLogger(CourseServiceOperation.class);
	
	public void displayRegisteredStudentsInCourse(int courseId){
		
		logger.info("*********************STUDENTS ENROLLED******************************");	
		logger.info("STUDENT ID");
		List<Integer> students = registrationDao.displayRegisteredStudentsInCourse(courseId);
		
		students.forEach(student -> logger.info(student));
		
	}
	
	

}
