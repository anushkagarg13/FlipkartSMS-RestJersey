package com.flipkart.dao;




import com.flipkart.model.User;

public interface CourseDao {
	public void addCourse(int courseId ,User user);
	public void dropCourse(int courseId, User user);
	 public void selectCourse(int courseId ,User user);
	 public void deselectCourse(int courseId, User user);
	

}
