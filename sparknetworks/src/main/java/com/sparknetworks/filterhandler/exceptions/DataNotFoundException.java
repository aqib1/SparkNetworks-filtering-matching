package com.sparknetworks.backend.exceptions;

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