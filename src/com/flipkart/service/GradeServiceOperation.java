package com.flipkart.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.dao.GradeDao;
import com.flipkart.dao.GradeDaoImpl;
import com.flipkart.model.Courses;
import com.flipkart.model.User;

public class GradeServiceOperation implements GradeServiceInterface{
	//create logger instance here
	private static Logger logger = Logger.getLogger(CourseServiceOperation.class);
	
	
	GradeDao gradeDao= new GradeDaoImpl();
	
	public void displayGrades(User user){
		logger.info("***********************************REPORT CARD******************************");	
		logger.info("COURSE ID      COURSE TITLE                     GRADE");
		List<Courses> courses = gradeDao.displayGrades(user);
		courses.forEach(course -> logger.info(course.getCourseId()+"               "+course.getCourseName()+"                       "+course.getGrade()));
		
		
	}
	
	public void uploadGrades(int studentId, int courseId, String grade) {
		gradeDao.uploadGrades(studentId, courseId, grade);
		
	}

}
