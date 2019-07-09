package com.main.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import static java.util.Locale.US;
import static java.text.DateFormat.SHORT;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

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
