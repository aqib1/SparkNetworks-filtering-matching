package com.sparknetworks.backend.controller.advice;

import java.time.LocalDateTime;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.sparknetworks.backend.exceptions.DataNotFoundException;
import com.sparknetworks.backend.exceptions.InvalidLoginCredException;
import com.sparknetworks.backend.exceptions.InvalidRequestException;
import com.sparknetworks.backend.exceptions.ServiceNotAvailableException;
import com.sparknetworks.model.ResponseError;

/**
 * @author AQIB JAVED
 * @version 1.0
 * @since 15/02/2020
 *
 */
@RestControllerAdvice
public class ControllerAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(ControllerAdvice.class);

	/**
	 * @param e
	 * @param wr
	 * @return
	 */
	@ExceptionHandler(value = { InvalidRequestException.class })
	public ResponseEntity<ResponseError> handleInvalidRequestException(RuntimeException e, WebRequest wr) {
		String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
				+ " [Invalid request exception! => (InvalidRequestException)]";
		ResponseError errorResponse = new ResponseError().createdAt(LocalDateTime.now().toString())
				.detailedMessage(error).errorCode(HttpStatus.BAD_REQUEST.value())
				.exceptionName(InvalidRequestException.class.getName()).errorMessage(e.getMessage());
		logger.error(errorResponse.toString(), e);
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	

	/**
	 * @param e
	 * @param wr
	 * @return
	 */
	@ExceptionHandler(value = { DataNotFoundException.class })
	public ResponseEntity<ResponseError> handleDataNotFoundException(RuntimeException e, WebRequest wr) {
		String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
				+ " [Data not found exception! => (DataNotFoundException)]";
		ResponseError errorResponse = new ResponseError().createdAt(LocalDateTime.now().toString())
				.detailedMessage(error).errorCode(HttpStatus.EXPECTATION_FAILED.value())
				.exceptionName(DataNotFoundException.class.getName()).errorMessage(e.getMessage());
		logger.error(errorResponse.toString(), e);
		return new ResponseEntity<>(errorResponse, HttpStatus.EXPECTATION_FAILED);
	}
	
	/**
	 * @param e
	 * @param wr
	 * @return
	 */
	@ExceptionHandler(value = { InvalidLoginCredException.class })
	public ResponseEntity<ResponseError> handleInvalidLoginCredException(RuntimeException e, WebRequest wr) {
		String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
				+ " [Login not valid! => (InvalidLoginCredException)]";
		ResponseError errorResponse = new ResponseError().createdAt(LocalDateTime.now().toString())
				.detailedMessage(error).errorCode(HttpStatus.EXPECTATION_FAILED.value())
				.exceptionName(InvalidLoginCredException.class.getName()).errorMessage(e.getMessage());
		logger.error(errorResponse.toString(), e);
		return new ResponseEntity<>(errorResponse, HttpStatus.EXPECTATION_FAILED);
	}
	
	/**
	 * @param e
	 * @param wr
	 * @return
	 */
	@ExceptionHandler(value = { ServiceNotAvailableException.class })
	public ResponseEntity<ResponseError> handleServiceNotAvailableException(RuntimeException e, WebRequest wr) {
		String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
				+ " [Service not available! => (ServiceNotAvailableException)]";
		ResponseError errorResponse = new ResponseError().createdAt(LocalDateTime.now().toString())
				.detailedMessage(error).errorCode(HttpStatus.GONE.value())
				.exceptionName(ServiceNotAvailableException.class.getName()).errorMessage(e.getMessage());
		logger.error(errorResponse.toString(), e);
		return new ResponseEntity<>(errorResponse, HttpStatus.GONE);
	}
}
