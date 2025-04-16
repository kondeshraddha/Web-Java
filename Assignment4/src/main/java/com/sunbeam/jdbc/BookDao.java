package com.sunbeam.jdbc;

import java.util.List;

import com.sunbeam.jdbc.entities.Book;

public interface BookDao {
	int save(Book b);
	int update(Book b);
	int delete(int id);
	List<Book>findAll();
	List<Book>findBySubject(String subject);
	Book findById(int id);
	

}
