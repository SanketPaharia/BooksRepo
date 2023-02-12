package com.skillovilla.booksvillaa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skillovilla.booksvillaa.model.Books;
import com.skillovilla.booksvillaa.model.User;
import com.skillovilla.booksvillaa.model.UserDto;

@Service
public interface UserService {
	public String loginUser(UserDto userDto);

	public List<Books> ShowAllBooks(String uniqueId);
}
