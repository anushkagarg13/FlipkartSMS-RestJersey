package com.flipkart.dao;

import java.util.List;

import com.flipkart.model.Courses;
import com.flipkart.model.User;

public interface CatalogDao {
	public List<Courses> displayCourses(User user);
	public List<Courses> displayCoursesProfessor(User user);
	public void insertCourse(Courses course) ;
	public void deleteCourse(int courseId);
	public List<Courses> displaySelectedCourses(User user);
	public List<Courses> displaySelectedCoursesProfessor(User user);


}
