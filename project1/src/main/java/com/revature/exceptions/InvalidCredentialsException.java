package com.revature.exceptions;

import com.revature.driver.ERS_Driver;

/**
 * Should be thrown when a user tries to login with invalid credentials
 */
public class InvalidCredentialsException extends RuntimeException {

	private static final long serialVersionUID = -6573307333524845568L;
	
	public void writeToLog() {
		ERS_Driver.logger.debug("InvalidCredentialsException was thrown");
	}
}
