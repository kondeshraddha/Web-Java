package com.sunbeam.jdbc;

import java.sql.Date;
import java.util.List;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sunbeam.jdbc.entities.Book;
import com.sunbeam.jdbc.entities.Customer;





@SpringBootApplication
public class Assignment4Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Assignment4Application.class, args);
	}
	@Autowired
	BookDao bookDao;
	@Autowired
	CustomerDao custDao;

	@Override
	public void run(String... args) throws Exception {

		 Scanner sc= new Scanner(System.in);
		
		int choice=0;
	do {
		System.out.println("1.insertBook\n2.updateBook\n3.deleteBook\n4.findAllBook\n5.findBySubject\n6.findById\n"
				+ "7.insertCustomer\n8.UpdateByPasswd\n9.findByEmail\n10.deleteCustomer\n11.findAllCustomer\n12.findByEmailAndPasswd\n");
	    choice=sc.nextInt();
	    switch(choice) {
	    case 0:
	    	System.out.println("exist");
	    	break;
	    case 1:
	    	Book b=new Book(54,"The Archer","Paulo","Novel",897.8);
			int count=bookDao.save(b);
			System.out.println("Book inserted : "+count);
			break;
			
	    case 2:
	    	Book b1=new Book(54,"Advancejava","james gosling","java",600.7);
			int count1=bookDao.update(b1);
			System.out.println("Book Updated "+count1);
			break;
			
	    case 3:
	    	int count2=bookDao.delete(54);
			System.out.println("Book deleted : "+count2);
			break;
			
	    case 4:
	    	List<Book>list=bookDao.findAll();
	    	for(Book li:list) {
	    		System.out.println(li);
	    	}
	    	break;
	    	
	    case 5:
	    	List<Book>lis=bookDao.findBySubject("os");
	    	for(Book li1:lis) {
	    		System.out.println(lis);
	    	}
	    	break;
	    	
	    case 6:
	    	Book bk=bookDao.findById(21);
	    	System.out.println(bk);
	    	break;
	    	
	    case 7:
	    	Customer c =new Customer(5,"Riya","riya","986543355","pune","riya@321gmail.com",Date.valueOf("2010-12-12"));
			int count3=custDao.save(c);
			System.out.println("Customer inserted : "+count3);
			break;
	    case 8:
	    	int count4=custDao.changePassword(5, "Rash");
	    	System.out.println("Password updated : "+count4);
			break;
	    case 9:
	    	Customer c2=custDao.findByEmail("riya@321gmail.com");
	    	System.out.println(c2);
	    	break;
	    case 10:
	    	int count5=custDao.delete(5);
	    	System.out.println("Customer deleted : "+count5);
	    	break;
	    case 11:
	    	List<Customer>l1=custDao.findAll();
	    	for(Customer li:l1) {
	    		System.out.println(li);
	    	}
	    	break;
	    case 12:
	    	Customer c3= custDao.findByEmailAndPasswd("riya@321gmail.com", "riya");
	    	System.out.println(c3);
	    	break;
	    	
	    default:
	    		System.out.println("Customer not found");
	   
	    	
	    	
	    	
	    
			
	    	
	    	
	    }
	}while(choice!=0);
		
		
		
		
	}

}
