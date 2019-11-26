package com.hcl.trade.controllertest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.hcl.trade.controller.UserStockController;
import com.hcl.trade.model.User;
import com.hcl.trade.service.UserStockServiceImpl;

import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserStockControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	UserStockController userStockController;

	@Mock
	UserStockServiceImpl userStockService;

	User users = new User();

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(userStockController).build();
	}
	
	@Test
	public void getDetailsByInValid() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/useritem/itemdetails/{useridcheck}", 200105)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is(404));
	}
}