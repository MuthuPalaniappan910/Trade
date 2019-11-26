
package com.hcl.trade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.trade.dto.BuyRequestDto;
import com.hcl.trade.model.UserStock;
import com.hcl.trade.service.UserStockService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/useritem")
@Slf4j
public class UserStockController {

	@Autowired
	UserStockService userStockService;

	@PostMapping("/buy/{stockid}/{useridcheck}")
	public String addCart(@PathVariable(value = "stockid") Long stockid,
			@PathVariable(value = "useridcheck") Long useridcheck, @RequestBody BuyRequestDto buyRequestDto) {
		log.info("Inside buy method");
		return userStockService.buyDetails(stockid, useridcheck, buyRequestDto);

	}

	@GetMapping("/itemdetails/{useridcheck}")
	public ResponseEntity<List<UserStock>> getDetailsByUserId(@PathVariable(value = "useridcheck") Long useridcheck) {
		List<UserStock> userStocks = userStockService.findByUserId(useridcheck);
		log.info("Inside to get stocks from particular items");
		if (!(userStocks.isEmpty())) {
			return new ResponseEntity<>(userStocks, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(userStocks, HttpStatus.NOT_FOUND);
		}
	}
}
