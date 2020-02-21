package com.sparknetworks.backend.exceptions;

/**
 * @author AQIB JAVED
 * @since 21/02/2020
 * @version 1.0
 */
public class InvalidLoginCredException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1661100139429716238L;

	/**
	 * @param message
	 */
	public InvalidLoginCredException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param e
	 */
	public InvalidLoginCredException(String message, Throwable e) {
		super(message, e);
	}
}