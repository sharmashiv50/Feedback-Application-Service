package com.feedback.Demo.service;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedback.Demo.Entity.UserFeedback;
import com.feedback.Demo.controller.LoginController;
import com.feedback.Demo.repository.FeedbackRepository;

@Service
public class FeedbackService {
	private static final Logger LOGGER=LoggerFactory.getLogger(LoginController.class);
	@Autowired
	FeedbackRepository feedbackrepo;

	/**
	 * @method getAllFeedback will return all available feedback for logged in user.
	 * @exception A custom exception will throw for invalid credential
	 * @result return a list of feedback in response 
	 */
	public List<UserFeedback> getAllFeedback() {
		List<UserFeedback> userfeed = new ArrayList<UserFeedback>();
	
		try {
			feedbackrepo.findAll().forEach(UserFeedback->
				userfeed.add(UserFeedback));
			return userfeed;
		} catch (Exception e) {
			LOGGER.info(e.getMessage());
			return userfeed;
		}
		
	}

	/**
	 * @method createFeedback will store a new feedback in database based on passed parameter.
	 * @exception A custom exception will throw for invalid credential
	 * @result return string in response 
	 */
	public String createFeedback(UserFeedback feedback) {
		try {
			feedbackrepo.save(feedback);
			return "Record saved";
		} catch (Exception e) {
			LOGGER.info(e.getMessage());
			return "Record not saved";
		}
	}

	/**
	 * @method deleteFeedback will delete a feedback from database based on passed feedback id.
	 * @exception A custom exception will throw for invalid credential
	 * @result return nothing in response 
	 */
	public void deleteFeedback(Long id) {
		try {
			feedbackrepo.deleteById(id);
		} catch (Exception e) {
			LOGGER.info(e.getMessage());
		}
	}
	
	/**
	 * @method updateFeedback will update a feedback in database based on passed and available feedback.
	 * @exception A custom exception will throw for invalid credential
	 * @result return string in response 
	 */
	public String updateFeedback(UserFeedback feedback) {
        try {
			boolean IsIdPresent = feedbackrepo.existsById(feedback.getId());
			if(!IsIdPresent)
			{
			    return "FeedBack is not available";
			}
			else {
			feedbackrepo.save(feedback);
			return "FeedBack updated";
			}
		} catch (Exception e) {
			LOGGER.info(e.getMessage());
			return "FeedBack is not updated";
		}
    }

}
