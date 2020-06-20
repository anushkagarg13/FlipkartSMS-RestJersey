package com.flipkart.model;

public class User {
	private int userId;
	private String userName;
	private String userPassword;
	private int roleId;
	private String role;
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User(){
		this.userId=101;
		this.userName= "anushka";
		this.userPassword="pass";
		this.roleId=1;
		
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private String profile;
	private String userEmail;
	private String name;
	private int semester;
	private String branch;
	private String position;
	private int phoneNumber;
	private boolean registrationComplete;
	private String gender;
	private String registeredOn;
	
	public int getScholarshipAllowancePercentage() {
		return scholarshipAllowancePercentage;
	}
	public void setScholarshipAllowancePercentage(int scholarshipAllowancePercentage) {
		this.scholarshipAllowancePercentage = scholarshipAllowancePercentage;
	}
	private int scholarshipAllowancePercentage;

	
	public String getRegisteredOn() {
		return registeredOn;
	}
	public void setRegisteredOn(String registeredOn) {
		this.registeredOn = registeredOn;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public boolean isRegistrationComplete() {
		return registrationComplete;
	}
	public void setRegistrationComplete(boolean registrationComplete) {
		this.registrationComplete = registrationComplete;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	

}
