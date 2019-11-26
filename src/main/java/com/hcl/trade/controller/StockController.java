package com.hcl.trade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.trade.model.Stock;
import com.hcl.trade.service.StockService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/stocks")
@Slf4j
public class StockController {
	@Autowired
	StockService stockService;

	@GetMapping("/")
	public ResponseEntity<List<Stock>> getAll() {
		List<Stock> stocks = stockService.getAllStocks();	
		log.info("Inside get available stock details");
		return new ResponseEntity<>(stocks, HttpStatus.OK);
	}
}
