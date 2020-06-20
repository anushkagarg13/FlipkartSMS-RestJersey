package com.flipkart.service;

import com.flipkart.model.User;

public interface RegistrationServiceInterface {
	public boolean checkCourseSelectionStatus (User user);
	public void submitRegistration (User user) ;
	public void displayRegisteredStudentsInCourse(int courseId);

}
