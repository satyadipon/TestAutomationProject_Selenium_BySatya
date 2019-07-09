package com.main.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	
	private static String chromeExeFilePath;
	private static String firefoxExeFilePath;
	private static String ieExeFilePath;

	public static String getFirefoxExeFilePath() {
		return firefoxExeFilePath;
	}



	public static void setFirefoxExeFilePath(String firefoxExeFilePath) {
		DriverFactory.firefoxExeFilePath = firefoxExeFilePath;
	}



	public static String getChromeExeFilePath() {
		return chromeExeFilePath;
	}



	public static void setChromeExeFilePath(String chromeExeFilePath) {
		DriverFactory.chromeExeFilePath = chromeExeFilePath;
	}



	public static String getIeExeFilePath() {
		return ieExeFilePath;
	}



	public static void setIeExeFilePath(String ieExeFilePath) {
		DriverFactory.ieExeFilePath = ieExeFilePath;
	}


	public static WebDriver createDriverInstance(String browser)
	{
		WebDriver driver= null;
		
		if(browser.equalsIgnoreCase("chrome"))
		{
					
			System.setProperty("webdriver.chrome.driver", DriverFactory.getChromeExeFilePath());
			driver= new ChromeDriver();
			DriverManager.setDriver(driver);
			DriverManager.maximizeBrowser(DriverManager.getDriver());
			//DriverManager.setImplecitWait(DriverManager.getDriver(), 20);
		}
		
		
		return DriverManager.getDriver();
	}
	
	
	public static void destroyDriverInstance(WebDriver driver)
	{
		if(driver!=null)
		{
			
			driver.quit();
			driver=null;
		}
	}

}
