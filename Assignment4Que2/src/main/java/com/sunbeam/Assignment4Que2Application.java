package com.sunbeam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.bank.Logger;
@ComponentScan("com.bank")
@SpringBootApplication
public class Assignment4Que2Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Assignment4Que2Application.class, args);
	}
	@Autowired
	private ApplicationContext ctx;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Logger log=ctx.getBean("consoleLoggerImple",Logger.class);
		log.logger("hii");
	}

}
