package com.feedback.Demo.serviceTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.feedback.Demo.Entity.UserFeedback;
import com.feedback.Demo.service.FeedbackService;

public class FeedbackServiceTests {

	UserFeedback feedback=new UserFeedback("Sachin","1627135","Java","false","false","Medium","5","4","Noce course to learn java");
	UserFeedback updateFeedback=new UserFeedback("Sachin Upadhyay","1627135",".NET","false","false","Medium","5","4","Noce course to learn java");
	FeedbackService service=new FeedbackService();
	long id=1;
	
	@Test
	void createFeedbacktest() {		
		String output=service.createFeedback(feedback);
		assertEquals("Record saved",output);
	}
	
	@Test
	void deleteFeedbacktest() {		
		service.deleteFeedback(id);
		//assertEquals("Record saved",output);
	}
	
	@Test
	void updateFeedbacktest() {		
		String output=service.updateFeedback(updateFeedback);
		assertEquals("FeedBack updated",output);
	}
}
