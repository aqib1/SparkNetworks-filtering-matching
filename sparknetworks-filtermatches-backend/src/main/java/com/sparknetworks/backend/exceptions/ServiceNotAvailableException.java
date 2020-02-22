package com.sparknetworks.backend.exceptions;

/**
 * @author AQIB JAVED
 * @version 1.0
 * @since 22/02/2020
 *
 */
public class ServiceNotAvailableException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2182903288170628415L;

	/**
	 * @param message
	 */
	public ServiceNotAvailableException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param e
	 */
	public ServiceNotAvailableException(String message, Throwable e) {
		super(message, e);
	}

}