package unit.com.sparknetworks.backend.controller;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.sparknetworks.backend.controller.FilterController;
import com.sparknetworks.backend.exceptions.ServiceNotAvailableException;
import com.sparknetworks.model.FilterHandlerRequest;
import com.sparknetworks.model.FilterHandlerResponse;
import com.sparknetworks.model.LoginRequestModel;
import com.sparknetworks.model.PersonDetailsModel;

import unit.com.sparknetworks.backend.utils.DataHelper;

/**
 * @author AQIB JAVED
 * @version 1.0
 * @since 02/23/2020
 */
@RunWith(MockitoJUnitRunner.class)
public class FilterControllerTest {

	@Mock
	private FilterController filterController;

	@Before
	public void init() {
		mockFilterController();
	}

	private void mockFilterController() {
		Mockito.when(filterController.login(Mockito.any(LoginRequestModel.class)))
				.thenReturn(DataHelper.getLoginFilterResponseController());
		Mockito.when(filterController.getAll()).thenReturn(DataHelper.getAllFilterResponseController());
		Mockito.when(filterController.filter(Mockito.any(FilterHandlerRequest.class)))
				.thenReturn(DataHelper.getAllFilterResponseController());
	}

	@Test
	public void testFilter() {
		ResponseEntity<FilterHandlerResponse> response = filterController.filter(DataHelper.getFilterHandlerRequest());
		Assert.assertTrue(200 == response.getStatusCodeValue());
		FilterHandlerResponse filter = response.getBody();
		List<PersonDetailsModel> matches = filter.getMatches();
		Assert.assertEquals("ca123", matches.get(0).getPassword());
		Assert.assertTrue(22 == matches.get(0).getAge());
		Assert.assertEquals("SE", matches.get(0).getJobTitle());
		Assert.assertTrue(121l == matches.get(0).getHeightInCm());
		Assert.assertTrue(2 == matches.get(0).getContactsExchanged());
		Assert.assertTrue(matches.get(0).getFavourite());
		Assert.assertEquals("LHR", matches.get(0).getCity().getName());
	}

	@Test
	public void testGetAll() {
		ResponseEntity<FilterHandlerResponse> response = filterController.getAll();
		Assert.assertTrue(200 == response.getStatusCodeValue());
		FilterHandlerResponse filter = response.getBody();
		List<PersonDetailsModel> matches = filter.getMatches();
		Assert.assertEquals("ca123", matches.get(0).getPassword());
		Assert.assertTrue(22 == matches.get(0).getAge());
		Assert.assertEquals("SE", matches.get(0).getJobTitle());
		Assert.assertTrue(121l == matches.get(0).getHeightInCm());
		Assert.assertTrue(2 == matches.get(0).getContactsExchanged());
		Assert.assertTrue(matches.get(0).getFavourite());
		Assert.assertEquals("LHR", matches.get(0).getCity().getName());
	}

	@Test
	public void testLogin() {
		ResponseEntity<PersonDetailsModel> response = filterController.login(DataHelper.getLoginRequestModel());
		Assert.assertTrue(200 == response.getStatusCodeValue());
		PersonDetailsModel model = response.getBody();
		Assert.assertEquals("ca123", model.getPassword());
		Assert.assertTrue(22 == model.getAge());
		Assert.assertEquals("SE", model.getJobTitle());
		Assert.assertTrue(121l == model.getHeightInCm());
		Assert.assertTrue(2 == model.getContactsExchanged());
		Assert.assertTrue(model.getFavourite());
		Assert.assertEquals("LHR", model.getCity().getName());
	}

	@Test(expected = ServiceNotAvailableException.class)
	public void testLoginCircuitBreaker() {
		mockLoginCircuitBreaker();
		filterController.loginCircuitBreaker(DataHelper.getLoginRequestModel());
	}

	private void mockLoginCircuitBreaker() {
		Mockito.when(filterController.loginCircuitBreaker(Mockito.any(LoginRequestModel.class)))
				.thenThrow(ServiceNotAvailableException.class);
	}

	@Test(expected = ServiceNotAvailableException.class)
	public void filterCircuitBreaker() {
		mockFilterCircuitBreaker();
		filterController.filterCircuitBreaker(DataHelper.getFilterHandlerRequest());
	}

	private void mockFilterCircuitBreaker() {
		Mockito.when(filterController.filterCircuitBreaker(Mockito.any(FilterHandlerRequest.class)))
				.thenThrow(ServiceNotAvailableException.class);
	}

	@Test(expected = ServiceNotAvailableException.class)
	public void getAllCircuitBreaker() {
		mockGetAllCircuitBreaker();
		filterController.getAllCircuitBreaker();
	}

	private void mockGetAllCircuitBreaker() {
		Mockito.when(filterController.getAllCircuitBreaker())
				.thenThrow(ServiceNotAvailableException.class);
	}
}
