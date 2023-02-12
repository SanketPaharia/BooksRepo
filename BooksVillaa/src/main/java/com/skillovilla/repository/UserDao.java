package com.skillovilla.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillovilla.booksvillaa.model.User;

public interface UserDao extends JpaRepository<User, Integer> {
	public User findByEmailANDPassword(String email, String password);
}
