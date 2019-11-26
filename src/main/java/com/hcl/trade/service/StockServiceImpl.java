package com.hcl.trade.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.trade.dao.StockDao;
import com.hcl.trade.model.Stock;

@Service
public class StockServiceImpl implements StockService{
	@Autowired
	StockDao stockDao;

	public List<Stock> getAllStocks() {
		
		Iterable<Stock> stock= stockDao.findAll();
		List<Stock> stockDetails= new ArrayList<>();
		for(Stock stockDetail: stock) {
			stockDetails.add(stockDetail);	
		}
		return stockDetails;
	}
}
