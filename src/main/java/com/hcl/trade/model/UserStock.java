
package com.hcl.trade.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name="userstock")
public class UserStock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long purchasedId;
	String stockName;
	Integer stockQuantity;
	Double grossPrice;
	Long userId;
}
