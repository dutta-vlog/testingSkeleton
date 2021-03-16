package com.skeleton.reports;

import org.apache.log4j.Logger;

public class Log4j {

	private static final Logger logger4j = Logger.getLogger(Log4j.class);

	public Logger getLog4jLogger() {
		return logger4j;
	}
	
	public Log4j() {
		logger4j.info("Log4j has intiated ");
		
	}
	
}
