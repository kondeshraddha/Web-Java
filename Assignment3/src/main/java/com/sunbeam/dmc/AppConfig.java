package com.sunbeam.dmc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {
	@Bean
	public TcpSender t1() {
		TcpSender t= new TcpSender();
	//	t.send(22.3);
		return t;
	}
	@Bean
	public HttpSender h1() {
		HttpSender h=new HttpSender();
	//	h.send(23.22);
		return h;
	}
	@Primary
	@Bean
	public UdpSender u1() {
		UdpSender u=new UdpSender();
	//	u.send(44.4);
		return u;
	}
	
	
	


}
