package com.hcl.trade.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "stock")

@Getter
@Setter
@NoArgsConstructor
public class Stock {
	@Id
	Long stockId;
	String stockName;
	Double stockPrice;
	Integer stockBrokerage;
	Integer stockQuantity;
}
