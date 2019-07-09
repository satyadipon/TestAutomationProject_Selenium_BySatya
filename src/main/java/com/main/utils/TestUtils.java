package com.main.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

import com.main.baseSetup.TestSetUp;



public class TestUtils extends TestSetUp{

	public static String screenshotPath;
	public static String screenshotName;

	/*
	 * @description: Method to take capture screenshot
	 */
	public static void captureScreenshot() throws IOException {
		
		screenshotPath = "./Screenshots/";
		File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".png";

		
		
		FileUtils.copyFile(scrFile,
				new File(screenshotPath + screenshotName));


	}
	
	
	
	

}
