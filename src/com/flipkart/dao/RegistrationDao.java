package com.flipkart.dao;

import java.util.List;

import com.flipkart.model.User;

public interface RegistrationDao {
	public boolean numberOfCoursesSelected (User user);
	public void submitRegistration (User user);
	public boolean getRegistrationStatus(User user);
	public List<Integer> displayRegisteredStudentsInCourse(int courseId);

}
