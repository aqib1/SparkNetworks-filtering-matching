package com.sparknetworks.backend.exceptions;

/**
 * @author AQIB JAVED
 * @version 1.0
 * @since 21/02/2020
 *
 */
public class DataNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9008547783032900262L;

	/**
	 * @param message
	 */
	public DataNotFoundException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param e
	 */
	public DataNotFoundException(String message, Throwable e) {
		super(message, e);
	}

}