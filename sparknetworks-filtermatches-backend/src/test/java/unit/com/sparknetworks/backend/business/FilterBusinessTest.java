package unit.com.sparknetworks.backend.business;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.sparknetworks.backend.business.FilterBusiness;
import com.sparknetworks.backend.exceptions.DataNotFoundException;
import com.sparknetworks.backend.exceptions.InvalidLoginCredException;
import com.sparknetworks.backend.exceptions.InvalidRequestException;
import com.sparknetworks.model.FilterHandlerRequest;
import com.sparknetworks.model.FilterHandlerResponse;
import com.sparknetworks.model.LoginRequestModel;
import com.sparknetworks.model.PersonDetailsModel;

import unit.com.sparknetworks.backend.utils.DataHelper;

/**
 * @author AQIB JAVED
 * @since 2/23/2020
 * @version 1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class FilterBusinessTest {
	@Mock
	private FilterBusiness filterBusiness;

	@Before
	public void init() {
		mockFilterBusiness();
	}

	private void mockFilterBusiness() {
		Mockito.when(filterBusiness.login(Mockito.any(LoginRequestModel.class)))
				.thenReturn(DataHelper.getPersonDetailsModel());
		Mockito.when(filterBusiness.getAll()).thenReturn(DataHelper.getFilterHandlerResponse());
		Mockito.when(filterBusiness.filter(Mockito.any(FilterHandlerRequest.class)))
				.thenReturn(DataHelper.getFilterHandlerResponse());
	}

	@Test
	public void loginTest() {
		PersonDetailsModel model = filterBusiness.login(DataHelper.getLoginRequestModel());
		Assert.assertEquals("caloria", model.getDisplayName());
		Assert.assertEquals("ca123", model.getPassword());
		Assert.assertTrue(22 == model.getAge());
		Assert.assertEquals("SE", model.getJobTitle());
		Assert.assertTrue(121l == model.getHeightInCm());
		Assert.assertTrue(2 == model.getContactsExchanged());
		Assert.assertTrue(model.getFavourite());
		Assert.assertEquals("LHR", model.getCity().getName());
	}

	@Test
	public void getAllTest() {
		FilterHandlerResponse response = filterBusiness.getAll();
		List<PersonDetailsModel> data = response.getMatches();
		Assert.assertEquals("caloria", data.get(0).getDisplayName());
		Assert.assertEquals("ca123", data.get(0).getPassword());
		Assert.assertTrue(22 == data.get(0).getAge());
		Assert.assertEquals("SE", data.get(0).getJobTitle());
		Assert.assertTrue(121l == data.get(0).getHeightInCm());
		Assert.assertTrue(2 == data.get(0).getContactsExchanged());
		Assert.assertTrue(data.get(0).getFavourite());
		Assert.assertEquals("LHR", data.get(0).getCity().getName());
	}

	@Test
	public void getFilterTest() {
		FilterHandlerResponse response = filterBusiness.filter(DataHelper.getFilterHandlerRequest());
		List<PersonDetailsModel> data = response.getMatches();
		Assert.assertEquals("caloria", data.get(0).getDisplayName());
		Assert.assertEquals("ca123", data.get(0).getPassword());
		Assert.assertTrue(22 == data.get(0).getAge());
		Assert.assertEquals("SE", data.get(0).getJobTitle());
		Assert.assertTrue(121l == data.get(0).getHeightInCm());
		Assert.assertTrue(2 == data.get(0).getContactsExchanged());
		Assert.assertTrue(data.get(0).getFavourite());
		Assert.assertEquals("LHR", data.get(0).getCity().getName());
	}

	@Test(expected = InvalidLoginCredException.class)
	public void testInvalidLoginCredException() {
		mockInvalidLoginCredExceptionLogin();
		filterBusiness.login(DataHelper.getLoginRequestModel());
	}

	private void mockInvalidLoginCredExceptionLogin() {
		Mockito.when(filterBusiness.login(Mockito.any(LoginRequestModel.class)))
				.thenThrow(InvalidLoginCredException.class);
	}
	
	@Test(expected = InvalidRequestException.class)
	public void testInvalidRequestException() {
		mockInvalidRequestExceptionLogin();
		filterBusiness.login(DataHelper.getLoginRequestModel());
	}

	private void mockInvalidRequestExceptionLogin() {
		Mockito.when(filterBusiness.login(Mockito.any(LoginRequestModel.class)))
		.thenThrow(InvalidRequestException.class);
	}
	
	@Test(expected = DataNotFoundException.class)
	public void testDataNotFoundException() {
		mockDataNotFoundExceptionFilter();
		filterBusiness.filter(DataHelper.getFilterHandlerRequest());
	}

	private void mockDataNotFoundExceptionFilter() {
		Mockito.when(filterBusiness.filter(Mockito.any(FilterHandlerRequest.class)))
		.thenThrow(DataNotFoundException.class);
	}
	
}
