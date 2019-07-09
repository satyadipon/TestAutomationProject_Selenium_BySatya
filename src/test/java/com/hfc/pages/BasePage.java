package com.hfc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.main.baseSetup.TestSetUp;
import com.main.utils.DriverManager;




public abstract class BasePage<T> {

	
	//public WebDriver driver;
	public int PAGE_LOAD_TIMEOUT=60;
	public int AJAX_LOAD_TIMEOUT=60;

	protected Wait<WebDriver> wait;
	
	
	public static ThreadLocal<ExtentTest> testLevelReport()
	{
		 return TestSetUp.testLevelReport;
	}
	
	public T openPage(Class<T> clazz)
	{
		T page=null;
		AjaxElementLocatorFactory ajaxLocatorFactory=new AjaxElementLocatorFactory(DriverManager.getDriver(), AJAX_LOAD_TIMEOUT);
		page=PageFactory.initElements(DriverManager.getDriver(), clazz);
		PageFactory.initElements(ajaxLocatorFactory, page);
		
		ExpectedCondition pageLoadCondtion=	((BasePage) page).getPageLoadCondition();
		waitForPageLoad(pageLoadCondtion);
		return page;
		
		
		
	}
	
	public abstract ExpectedCondition getPageLoadCondition();
	
	public void waitForPageLoad(ExpectedCondition expectedCondition)
	{
		 WebDriverWait wait= new WebDriverWait(DriverManager.getDriver(), PAGE_LOAD_TIMEOUT);
		 wait.until(expectedCondition);
	}
	
}
