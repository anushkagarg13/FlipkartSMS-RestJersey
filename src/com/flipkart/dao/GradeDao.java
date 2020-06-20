package com.flipkart.dao;

import java.util.List;

import com.flipkart.model.Courses;
import com.flipkart.model.User;

public interface GradeDao {
	
	public List<Courses> displayGrades(User user);
	public void uploadGrades(int studentId, int courseId, String grade);

}
