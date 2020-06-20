package com.flipkart.service;

import com.flipkart.model.User;

public class PaymentServiceOperation implements PaymentServiceInterface{
	
	public double calculatPayment(User user) {
		int standardPayment= 10000;
		int scholarshipPercentage=user.getScholarshipAllowancePercentage();
		double payableAmount= standardPayment*(0.01*(100-scholarshipPercentage));
		return payableAmount;
		
	}
	
	

}
