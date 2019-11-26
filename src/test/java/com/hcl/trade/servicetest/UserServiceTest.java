package com.hcl.trade.servicetest;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.trade.dao.UserDao;
import com.hcl.trade.model.User;
import com.hcl.trade.service.UserServiceImpl;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserServiceTest {
	@Mock
	UserDao usersDao;
	
	@InjectMocks
	UserServiceImpl userService;
	
	User users=new User();	
	
	@Test
	public void checkUser() {
		users.setUserId(200100L);
		Optional<User> user=Optional.of(users);
		Mockito.when(usersDao.findById(200100L)).thenReturn(user);
		@SuppressWarnings("unused")
		Optional<User> expected=userService.validateUser(200100L);		
	}

}
