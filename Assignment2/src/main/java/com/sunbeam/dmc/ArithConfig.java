package com.sunbeam.dmc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArithConfig {
	@Bean
	public Arithmetic a1() {
		Arithmetic a=new Arithmetic();
		a.setNum1(25);
		a.setNum2(10);
		return a;
		
		
	}

}
