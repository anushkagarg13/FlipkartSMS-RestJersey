package com.flipkart.service;

import com.flipkart.model.User;

public interface CourseServiceInterface {
	
	public void addCourse(int courseId, User user);
	public void dropCourse(int courseId,User user) ;
	 public void selectCourse(int courseId ,User user);
	 public void deselectCourse(int courseId, User user);

}
