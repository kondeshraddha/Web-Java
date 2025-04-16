package com.sunbeam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Assignment4Que1Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Assignment4Que1Application.class, args);
	}

	@Autowired
	private ApplicationContext ctx;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		TcpSender t=ctx.getBean(TcpSender.class);
		HttpSender h= ctx.getBean(HttpSender.class);
		UdpSender u=ctx.getBean(UdpSender.class);
		t.send(23.2);
		h.send(78.3);
		u.send(44.4);
		Sender sender=ctx.getBean(Sender.class);
		sender.send(66.4);
		
	}

}
