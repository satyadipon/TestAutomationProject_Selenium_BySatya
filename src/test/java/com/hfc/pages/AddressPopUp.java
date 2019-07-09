package com.hfc.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;
import com.main.utils.Global;

public class AddressPopUp extends BasePage {
	
	
	private static Logger LOGGER = LogManager.getLogger(AddressPopUp.class);
	private static void log(String logs)
	{
		LOGGER.info(logs);
		testLevelReport().get().log(Status.INFO, "<b>" + logs + "</b>");
	}

	@FindBy(id = "address-input")
	private WebElement oInputAddress;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement oButtonSubmit;
	
	
	public MenuPage setAddress(String input) {

		oInputAddress.sendKeys(input);
		Global.sleep(2);
		oButtonSubmit.click();
		log("Address is set to "+input+" and submitted");

		return (MenuPage) openPage(MenuPage.class);

	}

	
	
	

	@Override
	public ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(oInputAddress);
	}

}
