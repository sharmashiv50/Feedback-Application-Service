package com.feedback.Demo.serviceTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.feedback.Demo.Entity.Users;
import com.feedback.Demo.repository.UserRepository;
import com.feedback.Demo.service.UserService;


@RunWith(MockitoJUnitRunner.class)
public class UserServicesTests {
	UserService User=new UserService();
	
	@InjectMocks
	@Spy
	UserRepository userRepo;
	
	@Test
	public void IsUserAvailabletest() throws Exception {	
		Users user=new Users();
		user.setEmp_id("1627135");
		user.setPassword("Upadhyay1");
		Mockito.doReturn(true).when(userRepo).existsById(Mockito.anyString());
		String output=User.IsUserAvailable(user.getEmp_id(),user.getPassword());
		assertEquals("Sachin",output);
	}
	
	
	//create
	@Test
	void createUsertest() {		
		Users user=new Users();
		user.setEmp_id("1627135");
		user.setName("Sachin");
		user.setPassword("Upadhyay1");
		Boolean output=User.createUser(user);
		assertEquals(true,output);
	}
}
