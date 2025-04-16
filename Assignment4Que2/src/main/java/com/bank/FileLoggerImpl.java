package com.bank;

import java.io.FileOutputStream;
import java.io.PrintStream;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
//@Primary
@Component
public class FileLoggerImpl implements Logger {
	private String logFilePath="Applog.txt";
	

	public FileLoggerImpl() {
	
	}

	public FileLoggerImpl(String logFilePath) {
		super();
		this.logFilePath = logFilePath;
	}

	public String getLogFilePath() {
		return logFilePath;
	}

	public void setLogFilePath(String logFilePath) {
		this.logFilePath = logFilePath;
	}

	@Override
	public void logger(String message) {
		// TODO Auto-generated method stub
	//	System.out.println("message file : "+message);
		try(FileOutputStream fout = new FileOutputStream(logFilePath, true)) {
			try(PrintStream out = new PrintStream(fout)) {
				out.println(message);
			}
		} // fout close
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
