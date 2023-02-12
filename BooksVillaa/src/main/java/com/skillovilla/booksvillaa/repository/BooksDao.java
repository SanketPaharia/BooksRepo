package com.skillovilla.booksvillaa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillovilla.booksvillaa.model.Books;
@Repository
public interface BooksDao  extends JpaRepository<Books, Integer>{

}
