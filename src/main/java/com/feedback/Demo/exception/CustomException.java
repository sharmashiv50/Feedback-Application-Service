package com.feedback.Demo.exception;

public class CustomException extends RuntimeException{
	  private String message;

	  protected CustomException() {}

	  public CustomException(
	      String message) {
	    this.message = message;
	  }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
