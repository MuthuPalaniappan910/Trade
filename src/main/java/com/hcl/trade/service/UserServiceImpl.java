package com.hcl.trade.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.trade.dao.UserDao;
import com.hcl.trade.model.User;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDao userDao;

	public Optional<User> validateUser(Long userId) {
		return userDao.findById(userId);
	}

}
