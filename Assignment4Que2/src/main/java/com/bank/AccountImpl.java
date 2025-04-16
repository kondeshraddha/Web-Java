package com.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class AccountImpl implements Account {
	private int id;
	private String type;
	private double balance;
	@Autowired
	@Qualifier("consoleLoggerImple")
	private Logger logger;
	public AccountImpl() {
		
	}
	
	public AccountImpl(int id, String type, double balance) {
		
		this.id = id;
		this.type = type;
		this.balance = balance;
	//	this.logger = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	@Override
	public String toString() {
		return "AccountImpl [id=" + id + ", type=" + type + ", balance=" + balance + ", logger=" + logger + "]";
	}
	
	public void deposit(double amount) {
		if(logger!= null) {
			logger.logger("Deposite Rs : "+amount+"/- into account"+this.id);
			this.balance=this.balance+amount;
		}
		
	}

	@Override
	public void withdraw(double amount) {
		// TODO Auto-generated method stub
		if(logger!=null)
			logger.logger("withdraw rs : "+amount+"/- int acount"+this.id);
		this.balance=this.balance-amount;
		
	}
	

}
