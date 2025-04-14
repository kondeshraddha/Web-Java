package com.sunbeam.dmc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Assignment3Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Assignment3Application.class, args);
	}
	@Autowired
	private ApplicationContext ctx;

	@Override
	public void run(String... args) throws Exception {
//		Sender tcp=(Sender) ctx.getBean("t1");
//		Sender htt=(Sender) ctx.getBean("h1");
//		Sender udp=(Sender) ctx.getBean("u1");
		Sender c= ctx.getBean(Sender.class);
        c.send(34.3);
		
		
		
	}

}
