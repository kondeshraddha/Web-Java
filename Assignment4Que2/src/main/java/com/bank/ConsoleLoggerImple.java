package com.bank;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ConsoleLoggerImple implements Logger{

	@Override
	public void logger(String message) {
		// TODO Auto-generated method stub
		System.out.println("cons : "+message);
		
	}

}
