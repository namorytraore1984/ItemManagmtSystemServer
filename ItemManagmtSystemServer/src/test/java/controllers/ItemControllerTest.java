package controllers;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.when;
import static org.mockito.BDDMockito.willDoNothing;

import app.controllers.ItemController;
import app.datatransfertobjects.ItemDTO;
import app.services.api.IItemService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ItemController.class, secure = false)
public class ItemControllerTest {
	
	@MockBean
	private IItemService itemService;
	
	@Autowired
	private MockMvc mockMvc;
	
	private String URL = "/items";
	
	private ObjectMapper mapper;
	
	@Before
	public void setUp() {
		mapper = new ObjectMapper();
	}
	
	@Test
	public void addItem() throws Exception {
		
		// Given
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setItemCode("pers");
		itemDTO.setName("person");
		itemDTO.setOrigin("CAT");// Pour catalog
		itemDTO.setType("Human");
		
		RequestBuilder requestBuilder = buildCreateRequest(mapper.writeValueAsString(itemDTO));
		
		willDoNothing().given(itemService).addItem(itemDTO);
		
		// When
		mockMvc.perform(requestBuilder);
		
		// then
	}
	
	@After
	public void cleanUp() {
		
	}
	
	private RequestBuilder buildCreateRequest(String itemDTOJson) {
		
		return MockMvcRequestBuilders.post(URL)
				.content(itemDTOJson)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE);
	}
	
	

}
