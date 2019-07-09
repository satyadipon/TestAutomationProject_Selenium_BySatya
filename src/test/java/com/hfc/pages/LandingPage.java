package com.hfc.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;
import com.main.utils.DriverManager;

public class LandingPage extends BasePage {


	private static Logger LOGGER = LogManager.getLogger(LandingPage.class);
	private static void log(String logs)
	{
		LOGGER.info(logs);
		testLevelReport().get().log(Status.INFO, "<b>" + logs + "</b>");
	}

	@FindBy(xpath = "//input[@placeholder='Email']")
	private WebElement oInputEmail;

	@FindBy(xpath = "//button[@class='agree-cookie']")
	private WebElement oButtonAgreeCookie;

	@FindBy(xpath = "//a[@class='navigation--entry login-logout']")
	private WebElement oButtonLogin;

	@FindBy(xpath = "//a[contains(@class,'shop-menu-btn')]")
	private WebElement oLinkShopMenu;





	public LandingPage open(String url) {

		DriverManager.getDriver().navigate().to(url);
		return (LandingPage) openPage(LandingPage.class);
	}



	public LandingPage acceptCookie() {

		oButtonAgreeCookie.click();
		return (LandingPage) openPage(LandingPage.class);
	}

	public AddressPopUp clickShopMenuButton() {

		oLinkShopMenu.click();
		return (AddressPopUp) openPage(AddressPopUp.class);
	}


	@Override
	public ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(oButtonLogin);
	}

}
