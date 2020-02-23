package unit.com.sparknetworks.backend.controller.advice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sparknetworks.backend.controller.advice.ControllerAdvice;
import com.sparknetworks.backend.exceptions.DataNotFoundException;
import com.sparknetworks.backend.exceptions.InvalidLoginCredException;
import com.sparknetworks.backend.exceptions.InvalidRequestException;
import com.sparknetworks.backend.exceptions.ServiceNotAvailableException;
import com.sparknetworks.model.ResponseError;

import unit.com.sparknetworks.backend.utils.DataHelper;

/**
 * @author AQIB JAVED
 * @version 1.0
 * @since 02/23/2020
 */
@RunWith(MockitoJUnitRunner.class)
public class ControllerAdviceTest {

	@Mock
	private ControllerAdvice controllerAdvice;

	@Before
	public void init() {
		mockControllerAdvice();
	}

	private void mockControllerAdvice() {
		Mockito.when(controllerAdvice.handleInvalidRequestException(Mockito.any(RuntimeException.class), Mockito.any()))
				.thenReturn(DataHelper.getHandleInvalidRequestException());

		Mockito.when(controllerAdvice.handleDataNotFoundException(Mockito.any(RuntimeException.class), Mockito.any()))
				.thenReturn(DataHelper.getDataNotFoundException());

		Mockito.when(
				controllerAdvice.handleInvalidLoginCredException(Mockito.any(RuntimeException.class), Mockito.any()))
				.thenReturn(DataHelper.getHandleInvalidLoginCredException());

		Mockito.when(
				controllerAdvice.handleServiceNotAvailableException(Mockito.any(RuntimeException.class), Mockito.any()))
				.thenReturn(DataHelper.getHandleServiceNotAvailableException());
	}

	@Test
	public void testInvalidRequestException() {
		ResponseEntity<ResponseError> response = controllerAdvice
				.handleInvalidRequestException(DataHelper.TEST_RUNTIME_EXC, DataHelper.TEST_WEB_REQUEST);
		Assert.assertEquals("02/23/2020", response.getBody().getCreatedAt());
		Assert.assertEquals(InvalidRequestException.class.getName(), response.getBody().getDetailedMessage());
		Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		Assert.assertEquals("Error - Message", response.getBody().getErrorMessage());
	}

	@Test
	public void testHandleDataNotFoundException() {
		ResponseEntity<ResponseError> response = controllerAdvice
				.handleDataNotFoundException(DataHelper.TEST_RUNTIME_EXC, DataHelper.TEST_WEB_REQUEST);
		Assert.assertEquals("02/23/2020", response.getBody().getCreatedAt());
		Assert.assertEquals(DataNotFoundException.class.getName(), response.getBody().getDetailedMessage());
		Assert.assertEquals(HttpStatus.EXPECTATION_FAILED, response.getStatusCode());
		Assert.assertEquals("Error - Message", response.getBody().getErrorMessage());
	}

	@Test
	public void testHandleInvalidLoginCredException() {
		ResponseEntity<ResponseError> response = controllerAdvice
				.handleInvalidLoginCredException(DataHelper.TEST_RUNTIME_EXC, DataHelper.TEST_WEB_REQUEST);
		Assert.assertEquals("02/23/2020", response.getBody().getCreatedAt());
		Assert.assertEquals(InvalidLoginCredException.class.getName(), response.getBody().getDetailedMessage());
		Assert.assertEquals(HttpStatus.EXPECTATION_FAILED, response.getStatusCode());
		Assert.assertEquals("Error - Message", response.getBody().getErrorMessage());
	}

	@Test
	public void testHandleServiceNotAvailableException() {
		ResponseEntity<ResponseError> response = controllerAdvice
				.handleServiceNotAvailableException(DataHelper.TEST_RUNTIME_EXC, DataHelper.TEST_WEB_REQUEST);
		Assert.assertEquals("02/23/2020", response.getBody().getCreatedAt());
		Assert.assertEquals(ServiceNotAvailableException.class.getName(), response.getBody().getDetailedMessage());
		Assert.assertEquals(HttpStatus.GONE, response.getStatusCode());
		Assert.assertEquals("Error - Message", response.getBody().getErrorMessage());
	}
}
