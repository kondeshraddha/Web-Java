package com.sunbeam;

import java.beans.JavaBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class HttpSender implements Sender {
	
	@Override
	public void send(double value) {
		// TODO Auto-generated method stub
		System.out.println("HttpSender value : "+value);
	}

}
