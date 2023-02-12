package com.skillovilla.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.skillovilla.booksvillaa.model.User;
import com.skillovilla.repository.UserDao;

public class UserServiceImpl implements UserService {

	@Autowired
	UserDao uDao;
	
	@Override
	public User loginUser(String email, String Password) {
		User existing = uDao.findByEmailANDPassword(email, Password);
		
		
		return null;
	}

}
