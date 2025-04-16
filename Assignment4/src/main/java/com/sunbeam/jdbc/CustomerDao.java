package com.sunbeam.jdbc;

import java.util.List;

import com.sunbeam.jdbc.entities.Book;
import com.sunbeam.jdbc.entities.Customer;

public interface CustomerDao {
	int save(Customer cust);
	int changePassword(int custId, String password);
	Customer findByEmail(String email);
	int delete(int id);
	List<Customer> findAll();
	Customer findByEmailAndPasswd(String email, String passwd);
}
