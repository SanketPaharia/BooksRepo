package com.skillovilla.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillovilla.booksvillaa.model.Books;

public interface BooksDao  extends JpaRepository<Books, Integer>{

}
