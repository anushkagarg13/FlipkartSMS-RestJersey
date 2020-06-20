package com.flipkart.service;

import com.flipkart.model.User;

public interface GradeServiceInterface {
	
	public void displayGrades(User user);
	public void uploadGrades(int studentId, int courseId, String grade);

}
