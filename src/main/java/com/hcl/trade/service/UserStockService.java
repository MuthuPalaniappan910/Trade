package com.hcl.trade.service;

import java.util.List;

import com.hcl.trade.dto.BuyRequestDto;
import com.hcl.trade.model.UserStock;

public interface UserStockService {

	String buyDetails(Long itemId, Long userIdCheck, BuyRequestDto buyRequestDto);

	List<UserStock> findByUserId(Long useridcheck);

}
