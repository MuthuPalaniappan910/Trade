package com.hcl.trade.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.trade.dto.UserRequestDto;
import com.hcl.trade.dto.UserResponseDto;
import com.hcl.trade.model.User;
import com.hcl.trade.service.UserService;
import com.hcl.trade.util.TradeConstants;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/user")
@RestController
@Slf4j
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/check/")
	public ResponseEntity<UserResponseDto> doCheckUser(@RequestBody UserRequestDto userRequestDto) {
		Long userId = userRequestDto.getUserId();
		Optional<User> user = userService.validateUser(userId);
		UserResponseDto userResponseDto = new UserResponseDto();
		log.info("Inside verifying users method");
		if(user.isPresent()) {
			userResponseDto.setUserName(user.get().getUserName());
			userResponseDto.setDisplayCode(TradeConstants.SUCCESS_CODE);
			userResponseDto.setDisplayMessage(TradeConstants.SUCCESS_MESSAGE);
			return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
		}else {
			userResponseDto.setDisplayCode(TradeConstants.ERROR_CODE);
			userResponseDto.setDisplayMessage(TradeConstants.ERROR_MESSAGE);
			return new ResponseEntity<>(userResponseDto, HttpStatus.FORBIDDEN);
	}
	}

}
