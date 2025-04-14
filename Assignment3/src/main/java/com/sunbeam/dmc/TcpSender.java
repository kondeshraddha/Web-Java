package com.sunbeam.dmc;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class TcpSender implements Sender {
   
	@Override
	public void send(double value) {
		// TODO Auto-generated method stub
		System.out.println("TcpSender value : "+value);
		
	}

}
