package unit.com.sparknetworks.backend.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.sparknetworks.backend.controller.FilterController;
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
				.thenReturn(DataHelper.getLoginFilterController());
		Mockito.when(filterController.getAll()).thenReturn(DataHelper.getAllFilterController());
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

}
