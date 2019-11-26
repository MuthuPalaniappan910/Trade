
package com.hcl.trade.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.trade.model.UserStock;

@Repository
public interface UserStockDao extends CrudRepository<UserStock, Long> {
	List<UserStock> findByUserId(Long useridcheck);
}
