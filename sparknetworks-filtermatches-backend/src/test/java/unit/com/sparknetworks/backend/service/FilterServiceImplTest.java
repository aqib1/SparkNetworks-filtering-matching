package unit.com.sparknetworks.backend.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.sparknetworks.backend.entities.PersonDetailsEntity;
import com.sparknetworks.backend.service.Impl.FilterServiceImpl;
import com.sparknetworks.model.FilterHandlerRequest;
import com.sparknetworks.model.LoginRequestModel;

import unit.com.sparknetworks.backend.utils.DataHelper;

/**
 * @author AQIB JAVED
 * @since 2/23/2020
 * @version 1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class FilterServiceImplTest {

	@Mock
	private FilterServiceImpl filterServiceImpl;

	@Before
	public void init() {
		mockFilterServiceImpl();
	}

	private void mockFilterServiceImpl() {
		Mockito.when(filterServiceImpl.login(Mockito.any(LoginRequestModel.class)))
				.thenReturn(DataHelper.getPersonDetailsEntity());

		Mockito.when(filterServiceImpl.findAll()).thenReturn(DataHelper.getPersonDetailsEntityList());

		Mockito.when(filterServiceImpl.filterDetails(Mockito.any(FilterHandlerRequest.class)))
				.thenReturn(DataHelper.getPersonDetailsEntityList());
	}

	@Test
	public void testFilterDetails() {
		List<PersonDetailsEntity> data = filterServiceImpl.filterDetails(DataHelper.getFilterHandlerRequest());
		Assert.assertTrue(1 == data.get(0).getId());
		Assert.assertEquals("tekxe", data.get(0).getDisplayName());
		Assert.assertEquals("12aqw1", data.get(0).getPassword());
		Assert.assertEquals("SE", data.get(0).getJobTitle());
		Assert.assertTrue(12 == data.get(0).getAge());
		Assert.assertTrue(155 == data.get(0).getHeightInCm());
		Assert.assertTrue(51.509865 == data.get(0).getCity().getLat());
		Assert.assertTrue(-1.548567 == data.get(0).getCity().getLon());
		Assert.assertEquals("img.png", data.get(0).getMainPhoto());
		Assert.assertTrue(2.3 == data.get(0).getCompatibilityScore());
		Assert.assertTrue(2 == data.get(0).getContactsExchanged());
		Assert.assertTrue(data.get(0).getFavourite());
		Assert.assertEquals("T", data.get(0).getReligion());
	}

	@Test
	public void testFindAll() {
		List<PersonDetailsEntity> data = filterServiceImpl.findAll();
		Assert.assertTrue(1 == data.get(0).getId());
		Assert.assertEquals("tekxe", data.get(0).getDisplayName());
		Assert.assertEquals("12aqw1", data.get(0).getPassword());
		Assert.assertEquals("SE", data.get(0).getJobTitle());
		Assert.assertTrue(12 == data.get(0).getAge());
		Assert.assertTrue(155 == data.get(0).getHeightInCm());
		Assert.assertTrue(51.509865 == data.get(0).getCity().getLat());
		Assert.assertTrue(-1.548567 == data.get(0).getCity().getLon());
		Assert.assertEquals("img.png", data.get(0).getMainPhoto());
		Assert.assertTrue(2.3 == data.get(0).getCompatibilityScore());
		Assert.assertTrue(2 == data.get(0).getContactsExchanged());
		Assert.assertTrue(data.get(0).getFavourite());
		Assert.assertEquals("T", data.get(0).getReligion());
	}

	@Test
	public void testLogin() {
		PersonDetailsEntity entity = filterServiceImpl.login(DataHelper.getLoginRequestModel());
		Assert.assertTrue(1 == entity.getId());
		Assert.assertEquals("tekxe", entity.getDisplayName());
		Assert.assertEquals("12aqw1", entity.getPassword());
		Assert.assertEquals("SE", entity.getJobTitle());
		Assert.assertTrue(12 == entity.getAge());
		Assert.assertTrue(155 == entity.getHeightInCm());
		Assert.assertTrue(51.509865 == entity.getCity().getLat());
		Assert.assertTrue(-1.548567 == entity.getCity().getLon());
		Assert.assertEquals("img.png", entity.getMainPhoto());
		Assert.assertTrue(2.3 == entity.getCompatibilityScore());
		Assert.assertTrue(2 == entity.getContactsExchanged());
		Assert.assertTrue(entity.getFavourite());
		Assert.assertEquals("T", entity.getReligion());
	}
}
