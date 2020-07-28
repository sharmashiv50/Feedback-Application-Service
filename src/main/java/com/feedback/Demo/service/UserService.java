package com.feedback.Demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.feedback.Demo.Entity.Users;
import com.feedback.Demo.controller.LoginController;
import com.feedback.Demo.exception.CustomException;
import com.feedback.Demo.repository.UserRepository;

@Service
public class UserService {

	private static final Logger LOGGER=LoggerFactory.getLogger(LoginController.class);
	@Autowired
	UserRepository userRepo;
	
	 @Autowired
	 JdbcTemplate jdbcTemplate;

	 /**
		 * @method createUser will accept parameter as user.
		 * @exception A custom exception will throw for invalid credential
		 * @result return a boolean value in response 
		 */
	public boolean createUser(Users user) {
		try {
			boolean isIdAvalable = userRepo.existsById(user.getEmp_id());
			if(isIdAvalable)
			{
				return false;
			}
			else
			{
				userRepo.save(user);
				return true;
			}
		} catch (Exception e) {
			LOGGER.info(e.getMessage());
			throw new CustomException("There is some issue while fetching your request");
		}
	}

	
	/**
	 * @method IsUserAvailable will check user credential and accept parameter as ID and Password.
	 * @exception A custom exception will throw for invalid credential
	 * @result return a String result in response 
	 */
	public String IsUserAvailable(String id,String pwd) {
		try {
			boolean isIdAvalable = userRepo.existsById(id);
			if(!isIdAvalable)
			{
				return "User id is not available";
			}
			else
			{
				Users isPwdAvailable = jdbcTemplate.queryForObject("select name,password from registration where emp_id=? ",new Object[] {
			            id
			    },new BeanPropertyRowMapper<Users>(Users.class));
				if(isPwdAvailable.getPassword().contains(pwd))
				{
				   return isPwdAvailable.getName();
				}
				else
				{
					return "User id and password mismatch";
				}
			}
		} catch (DataAccessException e) {
			LOGGER.info(e.getMessage());
			throw new CustomException("User id and password mismatch");
		}
	}
	
	
}
