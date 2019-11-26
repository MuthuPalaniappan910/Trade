package com.hcl.trade.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.trade.model.Stock;

@Repository
public interface StockDao extends CrudRepository<Stock,Long>{

}
