package com.sunbeam.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sunbeam.jdbc.entities.Book;

@Repository
public class BookDaoImpl implements BookDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private RowMapper<Book>bookRowMapper;

	@Override
	public int save(Book b) {
		String sql="insert into books values(?,?,?,?,?)";
		int count= jdbcTemplate.update(sql,b.getId(),b.getName(),b.getAuthor(),b.getSubject(),b.getPrice());
	    return count;
	}

	@Override
	public int update(Book b) {
		// TODO Auto-generated method stub
		String sql="Update books set name=?,author=?,subject=?,price=? where id=?";
		int count = jdbcTemplate.update(sql,b.getName(),b.getAuthor(),b.getSubject(),b.getPrice(),b.getId());
		return count;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		String sql="delete from books where id=?";
		int count=jdbcTemplate.update(sql,id);
		return count;
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		String sql="select * from books";
		List<Book>list=jdbcTemplate.query(sql, bookRowMapper);
		return list;
	}

	@Override
	public List<Book> findBySubject(String subject) {
		// TODO Auto-generated method stub
		String sql="select * from books where subject=?";
		List<Book>list=jdbcTemplate.query(sql, bookRowMapper,subject);
		return list;
	}

	@Override
	public Book findById(int id) {
		// TODO Auto-generated method stub
		String sql="select * from books where id=?";
		List<Book>list=jdbcTemplate.query(sql, bookRowMapper,id);
		return list.isEmpty()?null:list.get(0);
	}
	
	
	

}
