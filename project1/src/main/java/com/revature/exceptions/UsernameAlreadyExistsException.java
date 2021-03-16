package com.revature.exceptions;


import com.revature.driver.ERS_Driver;

/**
 * Should be thrown when a user tries to register with a username that already exists in the system
 */
public class UsernameAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1712843686624302051L;
	
	public  void writeToLog() {
		ERS_Driver.logger.debug("UsernameAlreadyExistsException was thrown");
	}
}
