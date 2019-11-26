package com.hcl.trade.controllertest;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcl.trade.controller.UserController;
import com.hcl.trade.dto.UserRequestDto;
import com.hcl.trade.dto.UserResponseDto;
import com.hcl.trade.model.User;
import com.hcl.trade.service.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {

	ResponseEntity<UserResponseDto> userResponseDto = null;
	UserRequestDto userRequestDto = null;

	@Before
	public void setup() {
		userResponseDto = new ResponseEntity<UserResponseDto>(HttpStatus.FORBIDDEN);
		userRequestDto = new UserRequestDto();
	}

	@InjectMocks
	UserController userController;

	@Mock
	UserServiceImpl userService;

	@Test
	public void checkUserInvalid() {
		userRequestDto.setUserId(200100L);
		Integer response = 403;
		Mockito.when(userService.validateUser(200105L)).thenReturn(Optional.of(new User()));
		userResponseDto = userController.doCheckUser(userRequestDto);
		assertEquals(response, userResponseDto.getBody().getDisplayCode());
	}

	@Test public void checkUserValid(){ 
		  userRequestDto.setUserId(200100L);
			Integer response = 200;
			Mockito.when(userService.validateUser(200100L)).thenReturn(Optional.of(new User()));
			userResponseDto = userController.doCheckUser(userRequestDto);
			assertEquals(response, userResponseDto.getBody().getDisplayCode());
	} 

}
