package com.hcl.trade.servicetest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Before;

import com.hcl.trade.dao.StockDao;
import com.hcl.trade.model.Stock;
import com.hcl.trade.service.StockServiceImpl;

@RunWith(MockitoJUnitRunner.Silent.class)
public class StockServiceTest {
	@Mock
	StockDao stocksDao;

	@InjectMocks
	StockServiceImpl stockservice;

	List<Stock> stocks = null;
	Stock stockDetails = null;

	@Before
	public void Before() {
		stockDetails = new Stock();
		stocks = new ArrayList<>();

		stockDetails.setStockBrokerage(5);
		stockDetails.setStockId(100110L);
		stockDetails.setStockName("Laptop");
		stockDetails.setStockPrice(50000.0);
		stockDetails.setStockQuantity(5);
		stocks.add(stockDetails);

	}

	@Test
	public void testGetAllClaims() {
		Mockito.when(stocksDao.findAll()).thenReturn(stocks);
		List<Stock> expectedStockList = stockservice.getAllStocks();
		assertEquals(stocks, expectedStockList);

	}
}
