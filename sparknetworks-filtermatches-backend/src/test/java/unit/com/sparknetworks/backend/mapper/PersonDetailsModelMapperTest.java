package unit.com.sparknetworks.backend.mapper;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.sparknetworks.backend.entities.PersonDetailsEntity;
import com.sparknetworks.backend.mapper.PersonDetailsModelMapper;
import com.sparknetworks.model.PersonDetailsModel;

import unit.com.sparknetworks.backend.utils.DataHelper;

/**
 * @author AQIB JAVED
 * @version 1.0
 * @since 02/23/2020
 */
@RunWith(MockitoJUnitRunner.class)
public class PersonDetailsModelMapperTest {

	@Mock
	private PersonDetailsModelMapper mapper;

	@Before
	public void init() {
		Mockito.when(mapper.personDetailsEntityToPersonDetailsModel(Mockito.any(PersonDetailsEntity.class)))
				.thenReturn(DataHelper.getPersonDetailsModel());

		Mockito.when(mapper.personDetailsEntityListToPersonDetailsModelList(Mockito.<PersonDetailsEntity>anyList()))
				.thenReturn(DataHelper.getListPersonDetailsModel());

	}

	@Test
	public void testPersonDetailsEntityListToPersonDetailsModelList() {
		Object model = mapper.personDetailsEntityListToPersonDetailsModelList(DataHelper.getPersonDetailsEntityList());
		Assert.assertTrue(model instanceof List);
		@SuppressWarnings("unchecked")
		List<Object> subType = (List<Object>) model;
		Assert.assertTrue(subType.get(0) instanceof PersonDetailsModel);
	}

	@Test
	public void testPersonDetailsEntityToPersonDetailsModel() {
		Object model = mapper.personDetailsEntityToPersonDetailsModel(DataHelper.getPersonDetailsEntity());
		Assert.assertTrue(model instanceof PersonDetailsModel);
	}

}
