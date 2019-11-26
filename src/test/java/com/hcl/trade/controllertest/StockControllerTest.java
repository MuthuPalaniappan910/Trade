package com.hcl.trade.controllertest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hcl.trade.controller.StockController;
import com.hcl.trade.service.StockService;

@RunWith(SpringJUnit4ClassRunner.class)
public class StockControllerTest {
	private MockMvc mockMvc;

	@InjectMocks
	StockController stockController;

	@Mock
	StockService stockService;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(stockController).build();
	}
	
	@Test
	public void testCheckStocks() throws Exception {
		{
			mockMvc.perform(MockMvcRequestBuilders.get("/stocks/")
					.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk());

		}
	}


}
