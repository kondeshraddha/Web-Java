package com.sunbeam.dmc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ArithmeticMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(ArithConfig.class);
		Arithmetic a=(Arithmetic) ctx.getBean("a1");
		int sum=a.add();
		System.out.println("Addition is : "+sum);
		
		int sub=a.subtract();
		System.out.println("Subtraction is : "+sub);
		
		int multi=a.multiply();
		System.out.println("Multiplication is : "+multi);
		
		int div=a.divide();
		System.out.println("Division is : "+div);

	}

}
