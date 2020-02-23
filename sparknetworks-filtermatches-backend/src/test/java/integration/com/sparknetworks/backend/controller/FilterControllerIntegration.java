package integration.com.sparknetworks.backend.controller;

import static com.sparknetworks.backend.utils.Const.FILTER_URL;
import static com.sparknetworks.backend.utils.Const.LOGIN_URL;
import static com.sparknetworks.backend.utils.Utils.asJsonString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.sparknetworks.backend.business.FilterBusiness;
import com.sparknetworks.backend.controller.FilterController;
import com.sparknetworks.backend.entities.PersonDetailsEntity;
import com.sparknetworks.backend.mapper.PersonDetailsModelMapper;
import com.sparknetworks.backend.repositories.PersonDetailsRepository;
import com.sparknetworks.backend.service.Impl.FilterServiceImpl;

import unit.com.sparknetworks.backend.utils.DataHelper;

@RunWith(SpringRunner.class)
public class FilterControllerIntegration {

	private MockMvc mockMvc;
	private MediaType MEDIA_TYPE_JSON_UTF8;

	@Mock
	private PersonDetailsRepository repository;

	@Mock
	private PersonDetailsModelMapper mapper;

	@Spy
	@InjectMocks
	private FilterServiceImpl filterServiceImpl;

	@Spy
	@InjectMocks
	private FilterBusiness filterBusiness;

	@InjectMocks
	private FilterController filterController;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json", java.nio.charset.Charset.forName("UTF-8"));
		this.mockMvc = MockMvcBuilders.standaloneSetup(filterController).build();
		mockingMapStructs();
		mockingFindAll();
		mockingLogin();
		mockingFilterApi();
	}

	private void mockingMapStructs() {
		Mockito.when(mapper.personDetailsEntityToPersonDetailsModel(Mockito.any(PersonDetailsEntity.class)))
				.thenReturn(DataHelper.getPersonDetailsModel());
		Mockito.when(mapper.personDetailsEntityListToPersonDetailsModelList(Mockito.<PersonDetailsEntity>anyList()))
				.thenReturn(DataHelper.getListPersonDetailsModel());
	}

	private void mockingFilterApi() {
		Mockito.when(repository.findAll(ArgumentMatchers.<Specification<PersonDetailsEntity>>any()))
				.thenReturn(DataHelper.getPersonDetailsEntityList());
	}

	private void mockingLogin() {
		Mockito.when(repository.findByDisplayNameAndPassword(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(DataHelper.getPersonDetailsEntity());
	}

	private void mockingFindAll() {
		Mockito.when(repository.findAll()).thenReturn(DataHelper.getPersonDetailsEntityList());
	}

	@Test
	public void testGetAllAPI() throws Exception {
		mockMvc.perform(get(FILTER_URL)).andExpect(status().isOk())
				.andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
				.andExpect(jsonPath("$.matches[0].displayName").value("caloria"))
				.andExpect(jsonPath("$.matches[0].password").value("ca123"))
				.andExpect(jsonPath("$.matches[0].age").value(22))
				.andExpect(jsonPath("$.matches[0].jobTitle").value("SE"))
				.andExpect(jsonPath("$.matches[0].heightInCm").value(121))
				.andExpect(jsonPath("$.matches[0].city.name").value("LHR"))
				.andExpect(jsonPath("$.matches[0].city.lat").value(51.509865))
				.andExpect(jsonPath("$.matches[0].city.lon").value(-1.548567))
				.andExpect(jsonPath("$.matches[0].mainPhoto").value("img.png"))
				.andExpect(jsonPath("$.matches[0].compatibilityScore").value(2.1))
				.andExpect(jsonPath("$.matches[0].contactsExchanged").value(2))
				.andExpect(jsonPath("$.matches[0].favourite").value(true))
				.andExpect(jsonPath("$.matches[0].religion").value("Islam")).andDo(print());
	}

	@Test
	public void testLoginAPI() throws Exception {
		mockMvc.perform(post(FILTER_URL + LOGIN_URL).contentType(MEDIA_TYPE_JSON_UTF8)
				.content(asJsonString(DataHelper.getLoginRequestModel())).accept(MEDIA_TYPE_JSON_UTF8))
				.andExpect(status().isOk()).andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
				.andExpect(jsonPath("$.displayName").value("caloria")).andExpect(jsonPath("$.password").value("ca123"))
				.andExpect(jsonPath("$.age").value(22)).andExpect(jsonPath("$.jobTitle").value("SE"))
				.andExpect(jsonPath("$.heightInCm").value(121)).andExpect(jsonPath("$.city.name").value("LHR"))
				.andExpect(jsonPath("$.city.lat").value(51.509865)).andExpect(jsonPath("$.city.lon").value(-1.548567))
				.andExpect(jsonPath("$.mainPhoto").value("img.png"))
				.andExpect(jsonPath("$.compatibilityScore").value(2.1))
				.andExpect(jsonPath("$.contactsExchanged").value(2)).andExpect(jsonPath("$.favourite").value(true))
				.andExpect(jsonPath("$.religion").value("Islam")).andDo(print());
	}

	@Test
	public void testFilterAPI() throws Exception {
		mockMvc.perform(post(FILTER_URL).contentType(MEDIA_TYPE_JSON_UTF8)
				.content(asJsonString(DataHelper.getFilterHandlerRequest())).accept(MEDIA_TYPE_JSON_UTF8))
				.andExpect(status().isOk()).andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
				.andExpect(jsonPath("$.matches[0].displayName").value("caloria"))
				.andExpect(jsonPath("$.matches[0].password").value("ca123"))
				.andExpect(jsonPath("$.matches[0].age").value(22))
				.andExpect(jsonPath("$.matches[0].jobTitle").value("SE"))
				.andExpect(jsonPath("$.matches[0].heightInCm").value(121))
				.andExpect(jsonPath("$.matches[0].city.name").value("LHR"))
				.andExpect(jsonPath("$.matches[0].city.lat").value(51.509865))
				.andExpect(jsonPath("$.matches[0].city.lon").value(-1.548567))
				.andExpect(jsonPath("$.matches[0].mainPhoto").value("img.png"))
				.andExpect(jsonPath("$.matches[0].compatibilityScore").value(2.1))
				.andExpect(jsonPath("$.matches[0].contactsExchanged").value(2))
				.andExpect(jsonPath("$.matches[0].favourite").value(true))
				.andExpect(jsonPath("$.matches[0].religion").value("Islam")).andDo(print());
	}
}
