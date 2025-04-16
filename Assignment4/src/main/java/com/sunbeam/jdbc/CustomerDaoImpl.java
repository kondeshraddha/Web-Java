package com.sunbeam.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sunbeam.jdbc.entities.Book;
import com.sunbeam.jdbc.entities.Customer;
@Repository
public class CustomerDaoImpl implements CustomerDao {
	  @Autowired
       private JdbcTemplate jdbcTemplate;
	  @Autowired
	  private RowMapper<Customer>customerRowMapper;
	@Override
	public int save(Customer cust) {
		// TODO Auto-generated method stub
		String sql="insert into customers values(?,?,?,?,?,?,?)";
		int count= jdbcTemplate.update(sql,cust.getId(),cust.getName(),cust.getPassword(),cust.getEmail(),cust.getMobile(),cust.getAddress(),cust.getBirth());
	    return count;
	}

	@Override
	public int changePassword(int custId, String password) {
		String sql = "UPDATE customers SET password=? WHERE id=?";
		int count = jdbcTemplate.update(sql, password, custId);
		return count;
	}

	@Override
	public Customer findByEmail(String email) {
		String sql = "SELECT * FROM customers WHERE email = ?";
		List<Customer> list = jdbcTemplate.query(sql, customerRowMapper, email);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public int delete(int id) {
		String sql="delete from custmoers where id=?";
		int count=jdbcTemplate.update(sql,id);
		return count;
	}

	@Override
	public List<Customer> findAll() {
		String sql="select * from customers";
		List<Customer>list=jdbcTemplate.query(sql, customerRowMapper);
		return list;
	}

	@Override
	public Customer findByEmailAndPasswd(String email, String passwd) {
		// TODO Auto-generated method stub
		String sql="select * from customers where email=? and password=?";
		List<Customer> list = jdbcTemplate.query(sql, customerRowMapper, email,passwd);
		return list.isEmpty()? null : list.get(0);
		
		
	}
	

}
