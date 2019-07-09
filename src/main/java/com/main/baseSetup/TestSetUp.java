package com.main.baseSetup;

import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.main.utils.DriverFactory;
import com.main.utils.DriverManager;
import com.main.utils.ExtentManager;


public class TestSetUp {



	private static final long DEFAULT_TIMEOUT = 30;
	public static ExtentReports extent;
	public static ThreadLocal<ExtentTest> classLevelReport = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<ExtentTest> testLevelReport = new ThreadLocal<ExtentTest>();
	private static final ThreadLocal<Wait<WebDriver>> wait = ThreadLocal.withInitial(() -> null);

	protected WebDriver driver = null;

	
	@BeforeSuite(alwaysRun = true)
	public void setUp() {

		DriverFactory.setChromeExeFilePath(
				System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
		
		extent = ExtentManager.GetExtent();




	}

	@BeforeClass(alwaysRun = true)
	public synchronized void beforeClass() {

		ExtentTest parent = extent.createTest(getClass().getSimpleName());
		classLevelReport.set(parent);
	}

	@BeforeMethod(alwaysRun = true)
	public synchronized void beforeMethod(Method method) {
		WebDriver driver = null;
		if (driver == null) {
			driver = DriverFactory.createDriverInstance("chrome");


		}



	}



	@AfterMethod(alwaysRun = true)
	public synchronized void afterMethod(ITestResult result) {

		extent.flush();

		DriverManager.getDriver().quit();

	}

	

}
