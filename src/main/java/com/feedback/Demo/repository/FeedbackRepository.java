package com.feedback.Demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.feedback.Demo.Entity.UserFeedback;

public interface FeedbackRepository extends CrudRepository<UserFeedback, Long> {

}
