package com.feedback.Demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.Demo.Entity.UserFeedback;
import com.feedback.Demo.exception.CustomException;
import com.feedback.Demo.service.FeedbackService;


@RestController
@CrossOrigin(origins ="*")


public class FeedbackController {
	@Autowired
	private FeedbackService feedServ;

	private static final Logger LOGGER=LoggerFactory.getLogger(LoginController.class);
	
	/**
	 * @method getFeedback will accept get request with username as parameter.
	 * @exception A custom exception will throw for feedback.
	 * @result return a list of feedback. 
	 */
	@GetMapping("/users/{username}/feedback")
	public List<UserFeedback> getFeedback(@PathVariable String username) {
		try {
			return feedServ.getAllFeedback();
		} catch (Exception e) {
			LOGGER.info(e.getMessage());
			throw new CustomException("There is some issue while fetching feedbacks");
		}
	}

	/**
	 * @method deleteFeedback will accept delete request with employee id as parameter.
	 * @exception A custom exception will throw for deleting feedback.
	 * @result return a status with response. 
	 */
	@DeleteMapping("/users/{username}/feedback/{eid}")
	public ResponseEntity<UserFeedback>deleteFeedback(@PathVariable String username, @PathVariable Long eid) {
		try {
			feedServ.deleteFeedback(eid);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.info(e.getMessage());
			throw new CustomException("There is some issue while deleting feedback");
		}
	}

	/**
	 * @method updateFeedback will accept put request with feedback id as parameter.
	 * @exception A custom exception will throw for updating feedback.
	 * @result return a status with response. 
	 */
	@PutMapping("/users/{username}/updateFeedback/{eid}")
	public ResponseEntity<UserFeedback> updateFeedback(@PathVariable String username, @PathVariable String eid,
			@RequestBody UserFeedback feedback) {
		try {
			if(feedback.getId()==null)
			{
				feedback.setId(Long.parseLong(eid));
			}
			String status = feedServ.updateFeedback(feedback);
			if (status == null || status.isEmpty()) {

				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			} else if (status.contains("updated")) {

				return new ResponseEntity<>(HttpStatus.OK);
			} else {

				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} catch (NumberFormatException e) {
			LOGGER.info(e.getMessage());
			throw new CustomException("There is some issue while updating feedback");
		}
	}
	
	/**
	 * @method createFeedback will accept post request with feedback as parameter.
	 * @exception A custom exception will throw for updating feedback.
	 * @result return a status with response. 
	 */
	@PostMapping("/users/{username}/createFeedback")
	public ResponseEntity<UserFeedback>createFeedback(@PathVariable String username, @RequestBody UserFeedback feedback) {
		try {
			feedServ.createFeedback(feedback);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.info(e.getMessage());
			throw new CustomException("There is some issue while creating a new feedback");
		}

	}

}
