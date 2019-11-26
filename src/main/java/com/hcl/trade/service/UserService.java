package com.hcl.trade.service;

import java.util.Optional;

import com.hcl.trade.model.User;

public interface UserService {

	Optional<User> validateUser(Long userId);

}
