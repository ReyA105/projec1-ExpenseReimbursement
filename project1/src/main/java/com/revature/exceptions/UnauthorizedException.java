package com.revature.exceptions;

import com.revature.driver.ERS_Driver;

/**
 * Thrown if user does not have permission to perform the operation
 */
public class UnauthorizedException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void writeToLog() {
		ERS_Driver.logger.debug("UnauthorizedException was thrown");
	}
	
}
