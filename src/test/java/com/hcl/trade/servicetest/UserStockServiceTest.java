package com.hcl.trade.servicetest;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.trade.dao.StockDao;
import com.hcl.trade.dao.UserStockDao;
import com.hcl.trade.dao.UserDao;
import com.hcl.trade.dto.BuyRequestDto;
import com.hcl.trade.model.Stock;
import com.hcl.trade.model.User;
import com.hcl.trade.service.UserStockServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserStockServiceTest {
	@Mock
	UserStockDao userStockDao;

	@Mock
	StockDao stocksDao;

	@Mock
	UserDao usersDao;
	
	@InjectMocks
	UserStockServiceImpl userStockServiceImpl;
	
	User users=new User();
	Stock stocks=new Stock();
	BuyRequestDto buyRequestDto=new BuyRequestDto();
	
	@Test
	public void getPurchaseDetailsById() {
		users.setUserId(200100L);
		Optional<User> userDet=Optional.of(users);
		stocks.setStockId(100110L);
		stocks.setStockBrokerage(5);
		stocks.setStockName("Laptop");
		stocks.setStockPrice(65000.00);
		stocks.setStockQuantity(40);
		Optional<Stock> stockDet=Optional.of(stocks);
		buyRequestDto.setUserQuantity(2);
		String message="Successfully added to cart";
		Mockito.when(stocksDao.findById(100110L)).thenReturn(stockDet);
		Mockito.when(usersDao.findById(200100L)).thenReturn(userDet);
		String expected=userStockServiceImpl.buyDetails(100110L, 200100L,buyRequestDto);
		assertEquals(message,expected);		
	}
	
	@Test
	public void getPurchaseDetailsStockInvalid() {
		users.setUserId(200100L);
		Optional<User> userDet=Optional.of(users);
		stocks.setStockId(100110L);
		stocks.setStockBrokerage(5);
		stocks.setStockName("Laptop");
		stocks.setStockPrice(65000.00);
		stocks.setStockQuantity(40);
		Optional<Stock> stockDet=Optional.of(stocks);
		buyRequestDto.setUserQuantity(50);
		String message="There is no such stock currently";
		Mockito.when(stocksDao.findById(100110L)).thenReturn(stockDet);
		Mockito.when(usersDao.findById(200100L)).thenReturn(userDet);
		String expected=userStockServiceImpl.buyDetails(100110L, 200100L,buyRequestDto);
		assertEquals(message,expected);		
	}
	
	@Test
	public void getPurchaseDetailsstocksInvalid() {
		users.setUserId(200100L);
		Optional<User> userDet=Optional.of(users);
		stocks.setStockId(100120L);
		Optional<Stock> stockDet=Optional.of(stocks);
		buyRequestDto.setUserQuantity(50);
		String message="There is no such stock";
		Mockito.when(stocksDao.findById(100100L)).thenReturn(stockDet);
		Mockito.when(usersDao.findById(200100L)).thenReturn(userDet);
		String expected=userStockServiceImpl.buyDetails(100120L, 200100L,buyRequestDto);
		assertEquals(message,expected);		
	}
	
	@Test
	public void getPurchaseDetailsUserInvalid() {
		users.setUserId(200100L);
		Optional<User> userDet=Optional.of(users);
		stocks.setStockId(100100L);
		Optional<Stock> stockDet=Optional.of(stocks);
		buyRequestDto.setUserQuantity(50);
		String message="User is not present";
		Mockito.when(stocksDao.findById(100100L)).thenReturn(stockDet);
		Mockito.when(usersDao.findById(200103L)).thenReturn(userDet);
		String expected=userStockServiceImpl.buyDetails(100100L, 200100L,buyRequestDto);
		assertEquals(message,expected);		
	}
}
