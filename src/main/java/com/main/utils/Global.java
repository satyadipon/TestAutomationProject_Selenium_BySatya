package com.main.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.Status;
import com.main.baseSetup.TestSetUp;



public class Global extends TestSetUp {


	private static Logger logger = LogManager.getLogger(Global.class);

	private static void log(String logs)
	{
		logger.info(logs);
		testLevelReport.get().log(Status.INFO, "<b>" + logs + "</b>");
	}


	
	public static void sleep(int secs) {
		try {
			Thread.sleep(secs*1000);
		} catch (InterruptedException e) {

		}
	}

	
}
