package com.feedback.Demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.Demo.Entity.Users;
import com.feedback.Demo.exception.CustomException;
import com.feedback.Demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
public class LoginController {

	@Autowired
	private UserService userService;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(LoginController.class);
	
	@GetMapping("/Test")
	public String TestConstroller()
	{
		return "Getting Response from Constroller";
	}
	
	/**
	 * @method login will accept post request with user credential.
	 * @exception A custom exception will throw for invalid credential
	 * @result return a string result 
	 */
	@PostMapping("/login")
	public String login(@RequestBody Users login) throws Exception
	{
		try
		{
			String userCheck = userService.IsUserAvailable(login.getEmp_id(),login.getPassword());
			if(userCheck=="User id is not available")
			{
				throw new CustomException("User id is not available");
			}
			else if(userCheck=="User id and password mismatch")
			{
				throw new CustomException("User id and password mismatch");
			}
			else
			{
				return userCheck;
			}
		}
		catch (Exception e) {
			LOGGER.info(e.getMessage());
			throw new CustomException("User id and password mismatch");
		}
	}

	/**
	 * @method singUp will accept post request with user details.
	 * @exception A custom exception will throw for missing user details.
	 * @result return a string result 
	 */
	@PostMapping("/signUp")
	public String signUp(@RequestBody Users user)
	{
		try
		{
			boolean isUserCreated= userService.createUser(user);
			if(isUserCreated)
			{
				return "Account created";
			}
			else
			{
				throw new CustomException("Account with Employee id aleady exist");
			}
			
		}
		catch (Exception e) {
			LOGGER.info(e.getMessage());
			throw new CustomException("Account not created");
		}	
	}
}
