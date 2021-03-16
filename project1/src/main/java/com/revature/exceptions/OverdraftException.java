package com.revature.exceptions;

import com.revature.driver.ERS_Driver;

/**
 * Should be thrown when a user attempts to withdraw more money
 * than exists in their account
 */
public class OverdraftException extends RuntimeException {

	private static final long serialVersionUID = -7168679456912742268L;

	public void writeToLog() {
		ERS_Driver.logger.debug("OverdraftException was thrown");
	}

}
