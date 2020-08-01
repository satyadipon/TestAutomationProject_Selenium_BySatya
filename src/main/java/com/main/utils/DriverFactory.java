package com.main.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	

	public static WebDriver createDriverInstance(String browser)
	{
		WebDriver driver= null;
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver= new ChromeDriver();
			DriverManager.setDriver(driver);
			DriverManager.maximizeBrowser(DriverManager.getDriver());
			DriverManager.setImplecitWait(DriverManager.getDriver(), 20);
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
