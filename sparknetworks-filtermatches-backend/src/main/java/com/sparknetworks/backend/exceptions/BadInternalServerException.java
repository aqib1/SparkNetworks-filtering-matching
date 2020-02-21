package com.sparknetworks.backend.exceptions;

public class BadInternalServerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4113386087026571894L;

	/**
	 * @param message
	 */
	public BadInternalServerException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param e
	 */
	public BadInternalServerException(String message, Throwable e) {
		super(message, e);
	}

}