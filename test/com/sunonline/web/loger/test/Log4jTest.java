package com.sunonline.web.loger.test;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jTest {
	
	public static void main(String[] args) {
		BasicConfigurator.configure();
		
		Logger logger = Logger.getLogger("logger");
		
		logger.debug("debug");
		logger.info("info");
		logger.warn("warn");
		logger.error("error");
		logger.fatal("fatal");
	}
}
