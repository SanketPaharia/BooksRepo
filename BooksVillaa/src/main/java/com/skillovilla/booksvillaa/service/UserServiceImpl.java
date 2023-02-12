package com.skillovilla.booksvillaa.service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillovilla.booksvillaa.exception.BooksException;
import com.skillovilla.booksvillaa.exception.UserException;
import com.skillovilla.booksvillaa.model.Books;
import com.skillovilla.booksvillaa.model.User;
import com.skillovilla.booksvillaa.model.UserDto;
import com.skillovilla.booksvillaa.model.UserSession;
import com.skillovilla.booksvillaa.repository.BooksDao;
import com.skillovilla.booksvillaa.repository.UserDao;
import com.skillovilla.booksvillaa.repository.UserSessionDao;

import net.bytebuddy.utility.RandomString;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao uDao;

	@Autowired
	UserSessionDao uSDao;

	@Autowired
	BooksDao bDao;

	@Override
	public String loginUser(UserDto userDto) {
		User existingUser = uDao.findByEmailAndPassword(userDto.getEmail(), userDto.getPassword());

		if (existingUser != null) {

			UserSession session = new UserSession();
			session.setTime(LocalTime.now());
			session.setUniqueId(RandomString.make(8));
			return uSDao.save(session) + "";

		} else {
			throw new UserException("Wronng credentials");
		}
	}

	@Override
	public List<Books> ShowAllBooks(String uniqueId) {
		UserSession uSession = uSDao.findByUniqueId(uniqueId);
		if (uSession != null) {
			List<Books> books = bDao.findAll();

			if (books.size() != 0) {
				return books;
			} else {
				throw new BooksException("No books in database");
			}

		} else {
			throw new UserException("Login first");
		}

	}

}
