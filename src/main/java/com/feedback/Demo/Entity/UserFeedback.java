package com.feedback.Demo.Entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="feedback")
public class UserFeedback {
	@Id
	@SequenceGenerator(name="seq", initialValue=10, allocationSize=1000)
	@GeneratedValue(strategy = GenerationType.IDENTITY )	
	private Long id;
	
	private String learner_name;
	
	//@Id
	private String learner_emp_id;
	
	private String course_name;
	
	private String is_content_relevant;
	
	private String is_relevant_content_hands_on;

	private String proficiency_level;
	
	private String rating_of_content;
	
	private String rating_of_hands_on;
	
	private String comments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLearner_name() {
		return learner_name;
	}

	public void setLearner_name(String learner_name) {
		this.learner_name = learner_name;
	}

	public String getLearner_emp_id() {
		return learner_emp_id;
	}

	public void setLearner_emp_id(String learner_emp_id) {
		this.learner_emp_id = learner_emp_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getIs_content_relevant() {
		return is_content_relevant;
	}

	public void setIs_content_relevant(String is_content_relevant) {
		this.is_content_relevant = is_content_relevant;
	}

	public String getIs_relevant_content_hands_on() {
		return is_relevant_content_hands_on;
	}

	public void setIs_relevant_content_hands_on(String is_relevant_content_hands_on) {
		this.is_relevant_content_hands_on = is_relevant_content_hands_on;
	}

	public String getProficiency_level() {
		return proficiency_level;
	}

	public void setProficiency_level(String proficiency_level) {
		this.proficiency_level = proficiency_level;
	}

	public String getRating_of_content() {
		return rating_of_content;
	}

	public void setRating_of_content(String rating_of_content) {
		this.rating_of_content = rating_of_content;
	}

	public String getRating_of_hands_on() {
		return rating_of_hands_on;
	}

	public void setRating_of_hands_on(String rating_of_hands_on) {
		this.rating_of_hands_on = rating_of_hands_on;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public UserFeedback(String learner_name, String learner_emp_id, String course_name, String is_content_relevant,
			String is_relevant_content_hands_on, String proficiency_level, String rating_of_content,
			String rating_of_hands_on, String comments) {
		super();
		this.learner_name = learner_name;
		this.learner_emp_id = learner_emp_id;
		this.course_name = course_name;
		this.is_content_relevant = is_content_relevant;
		this.is_relevant_content_hands_on = is_relevant_content_hands_on;
		this.proficiency_level = proficiency_level;
		this.rating_of_content = rating_of_content;
		this.rating_of_hands_on = rating_of_hands_on;
		this.comments = comments;
	}

	public UserFeedback() {
		super();
	}
	
	
	
	}
