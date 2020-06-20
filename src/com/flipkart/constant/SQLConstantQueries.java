package com.flipkart.constant;

public class SQLConstantQueries {
	
	// fetch user profile by id query
	public static final String VALIDATE_USER="SELECT * FROM user WHERE UserID=? AND Password=?";
	
	public static final String DISPLAY_COURSES= "SELECT CourseID, Title, Description, StudentsEnrolled, Faculty FROM flipkart_sms.catalog WHERE Semester= ? AND Branch =?";
	
	public static final String DISPLAY_COURSES_PROFESSOR= "SELECT * FROM flipkart_sms.catalog" ;
	
		public static final String ADD_COURSE="INSERT INTO flipkart_sms.studentcourse VALUES (?,?,?,CURRENT_TIMESTAMP)";
		
		public static final String DROP_COURSE="DELETE FROM flipkart_sms.studentcourse WHERE UserID=? AND CourseID=?" ;
		
		public static final String INSERT_USER="INSERT INTO user VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		public static final String DELETE_USER="DELETE FROM flipkart_sms.user WHERE UserID=" ;
		
		public static final String UPDATE_USER="UPDATE flipkart_sms.user SET EmailID=?,Password=?, Role=?, Name=?, PhoneNumber=?, Semester=?, Branch=?, Position=?, Gender=?, IsRegistrationComplete=?,RegisteredOn=?,ScholarshipAllowancePercentage=? WHERE UserID=?";
		
		public static final String INSERT_COURSE="INSERT INTO flipkart_sms.catalog VALUES (?,?,?,?,?)";
		
		public static final String DELETE_COURSE="DELETE FROM flipkart_sms.catalog WHERE CourseID=" ;
		
		public static final String DISPLAY_USERS= "SELECT UserID, EmailID, Password, Name, PhoneNumber, Semester, Branch, Position,Gender, IsRegistrationComplete, RegisteredOn FROM flipkart_sms.user WHERE Role=?";
		
//	
		
//	
		public static final String VIEW_SELECTED_COURSES="SELECT flipkart_sms.catalog.CourseID, flipkart_sms.catalog.Title, flipkart_sms.catalog.Description, flipkart_sms.studentcourse.TIME_STAMP\r\n" + 
				"FROM flipkart_sms.catalog \r\n" + 
				"INNER JOIN flipkart_sms.studentcourse \r\n" + 
				"ON flipkart_sms.studentcourse.CourseID = flipkart_sms.catalog.CourseID\r\n" + 
				"WHERE flipkart_sms.studentcourse.UserID= ?";
		
		public static final String UPDATE_USER_REGISTRATION_STATUS="UPDATE flipkart_sms.user SET IsRegistrationComplete=?,RegisteredOn=? WHERE UserID=?";
		
		public static final String UPDATE_REGISTARTION_STATUS="UPDATE flipkart_sms.user SET IsRegistrationComplete= true,RegisteredOn= CURRENT_TIMESTAMP WHERE UserID=?";
		
		public static final String NUMBER_OF_COURSES_SELECTED="SELECT count(CourseID) FROM flipkart_sms.studentcourse WHERE UserID=?";
		
		public static final String REGISTRATION_OF_COURSES="UPDATE flipkart_sms.studentcourse SET RegistrationStatus= true WHERE UserID=?" ;
		
		public static final String SHOW_REGISTRATION_STATUS="SELECT IsRegistrationComplete FROM flipkart_sms.user WHERE UserID=?";
		
		public static final String UPDATE_ENROLLED_STUDENTS_NUMBER="UPDATE flipkart_sms.catalog SET StudentsEnrolled = StudentsEnrolled +1 WHERE CourseID IN (SELECT CourseID FROM flipkart_sms.studentcourse WHERE UserID=? AND RegistrationStatus= true)";
		
		public static final String VIEW_GRADES="SELECT flipkart_sms.catalog.CourseID, flipkart_sms.catalog.Title,  flipkart_sms.studentcourse.Grade, flipkart_sms.catalog.Description, flipkart_sms.studentcourse.TIME_STAMP  \r\n" + 
				"FROM flipkart_sms.catalog  \r\n" + 
				"INNER JOIN flipkart_sms.studentcourse  \r\n" + 
				"ON flipkart_sms.studentcourse.CourseID = flipkart_sms.catalog.CourseID \r\n" + 
				"WHERE flipkart_sms.studentcourse.UserID=?";
		
		public static final String SELECT_COURSE="UPDATE flipkart_sms.catalog SET Faculty = ? WHERE CourseID=? ";
		
		public static final String DESELECT_COURSE="UPDATE flipkart_sms.catalog SET Faculty = 0 WHERE CourseID=?" ;
		
		public static final String DISPLAY_PROFESSOR_SELECTED_COURSES="SELECT CourseID, Title, StudentsEnrolled FROM flipkart_sms.catalog WHERE Faculty=? ";
		
		public static final String UPLOAD_GRADES="UPDATE flipkart_sms.studentcourse SET Grade=? WHERE UserID=? AND CourseID=? AND RegistrationStatus=1";
		
		public static final String VIEW_ENROLLED_COURSES="SELECT UserID FROM flipkart_sms.studentcourse WHERE CourseID=? AND RegistrationStatus=1";

}
