package com.flipkart.service;

import java.util.List;

import com.flipkart.model.Courses;
import com.flipkart.model.User;

public interface CatalogServiceInterface {
	public void displayCourses(User user);
	public void insertCourse(Courses course);
	public void deleteCourse(int courseId);
	public void displaySelectedCourses(User user);
	public void displaySelectedCoursesProfessor(User user);
}
