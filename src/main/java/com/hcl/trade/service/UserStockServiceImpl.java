
package com.hcl.trade.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.trade.dao.StockDao;
import com.hcl.trade.dao.UserStockDao;
import com.hcl.trade.dao.UserDao;
import com.hcl.trade.dto.BuyRequestDto;
import com.hcl.trade.model.Stock;
import com.hcl.trade.model.UserStock;
import com.hcl.trade.model.User;

@Service
@Transactional
public class UserStockServiceImpl implements UserStockService{

	@Autowired
	UserStockDao usersstockDao;

	@Autowired
	StockDao stockDao;

	@Autowired
	UserDao userDao;

	public String buyDetails(Long stockId, Long userIdCheck, BuyRequestDto buyRequestDto) {
		UserStock userStocks = new UserStock();
		Optional<Stock> stock = stockDao.findById(stockId);
		if (stock.isPresent()) {
			String stockName = stock.get().getStockName();
			Double stockPrice = stock.get().getStockPrice();
			Integer stockQuantity = stock.get().getStockQuantity();
			Integer stockBrokerage = stock.get().getStockBrokerage();
			Optional<User> user = userDao.findById(userIdCheck);
			if (user.isPresent()) {
				Integer quantityWanted = buyRequestDto.getUserQuantity();
				if (quantityWanted <= stockQuantity) {
					Double price = ((quantityWanted * stockPrice)
							+ ((quantityWanted * stockPrice * stockBrokerage) / 100));
					userStocks.setStockName(stockName);
					userStocks.setStockQuantity(quantityWanted);
					userStocks.setGrossPrice(price);
					userStocks.setUserId(user.get().getUserId());
					usersstockDao.save(userStocks);

					Integer updatedQuantity = stockQuantity - quantityWanted;
					stock.get().setStockQuantity(updatedQuantity);
					stockDao.save(stock.get());
				} else {
					return "There is no such stock currently";
				}
			} else {
				return "User is not present";
			}
		} else {
			return "There is no such stock";
		}
		return "Successfully added to cart";

	}

	public List<UserStock> findByUserId(Long useridcheck) {
		return usersstockDao.findByUserId(useridcheck);
	}
}
