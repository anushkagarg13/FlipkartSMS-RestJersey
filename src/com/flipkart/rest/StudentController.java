package com.flipkart.rest;

import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.crypto.URIReferenceException;

import org.apache.log4j.Logger;

//import com.flipkart.bean.Customer;
import com.flipkart.model.*;
import com.flipkart.service.CourseServiceOperation;
import com.flipkart.service.UserServiceInterface;
import com.flipkart.service.UserServiceOperation;

/** 
 * @desc this class holds CRUD operations for student 
 * @author Anushka 
*/
@Path ("/student")
public class StudentController {
	//create logger instance here
	private static Logger logger = Logger.getLogger(CourseServiceOperation.class);
	
	// initialising userOperation instance to carry out user operations
	UserServiceInterface userOperation= new UserServiceOperation();
	
	
	// GET method display details of students
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> displayStudents(){
		return userOperation.displayStudents();
	}
	
	// POST method to create an user
	@POST
	@Path("/post")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(User user){
		logger.info("hit post service");
		logger.info("USERID= "+user.getUserId());
		logger.info("NAME= "+user.getName());
		logger.info("GENDER= "+user.getGender());
		logger.info("EMAILID= "+user.getUserEmail());
		logger.info("PASSWORD= "+user.getUserPassword());
		logger.info("PHONE= "+user.getPhoneNumber());
		logger.info("ROLE= "+user.getRole());
		String result= "track saved: "+ user;
		userOperation.createUser(user);
		return Response.status(201).entity(result).build();
	}
	
	// DELETE method to delete an user
	@DELETE
	@Path("/delete/{id}")
	public Response deleteUser (@PathParam("id") int userId)throws URIReferenceException{
		userOperation.deleteUser(userId);
		return Response.status(200).entity("Track id "+userId + "succesfully deleted").build();
	}
	
	// PUT method to update user
	@PUT
	@Path("/put")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUser(User user){		
		userOperation.updateUser( user);	
		return Response.status(200).entity("User updated succesfully ").build();
	}


}
