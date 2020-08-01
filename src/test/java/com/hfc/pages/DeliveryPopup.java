package com.hfc.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

public class DeliveryPopup extends BasePage {


	private static Logger LOGGER = LogManager.getLogger(DeliveryPopup.class);
	private static void log(String logs)
	{
		LOGGER.info(logs);
		testLevelReport().get().log(Status.INFO, "<b>" + logs + "</b>");
	}


	@FindBy(xpath = "(//h2[text()='Wählen Sie Ihre Lieferplattform'])[last()]")
	private WebElement oTextDeliveryPlatform;


	public boolean isSelectDeliveryPlatformVisible() {

		if(oTextDeliveryPlatform.isDisplayed())
			return true;

		return false;
	}





	@Override
	public ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(oTextDeliveryPlatform);
	}

}
