package com.hcl.trade.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.trade.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {

}
