package com.hcl.trade.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")

@Getter
@Setter
@NoArgsConstructor
public class User {
	@Id
	Long userId;
	String userName;
}
