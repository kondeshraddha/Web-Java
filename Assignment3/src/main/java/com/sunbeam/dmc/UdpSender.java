package com.sunbeam.dmc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;




public class UdpSender implements Sender {
 
	@Override
	public void send(double value) {
		// TODO Auto-generated method stub
		System.out.println("UdpSender value : "+value);
	}

}
