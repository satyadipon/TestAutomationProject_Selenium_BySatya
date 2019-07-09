package com.hfc.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.hfc.pages.AddressPopUp;
import com.hfc.pages.MenuPage;
import com.hfc.pages.LandingPage;
import com.main.baseSetup.TestSetUp;
import com.main.utils.Config;
import com.main.utils.DriverManager;

public class AddToCartFunctionalityTest extends TestSetUp{

	private Logger logger = LogManager.getLogger(AddToCartFunctionalityTest.class);

	private void log(String logs)
	{
		logger.info(logs);
		testLevelReport.get().log(Status.INFO, "<b>" + logs + "</b>");
	}



	@Test(description = "add to cart functionality", groups={"addToCart"})
	public void addToCartFunctionalityTest() throws Exception {

		//Load website
		LandingPage lpage=new LandingPage().open(Config.getBaseURL());
		log("Website Url Launched "+DriverManager.getDriver().getCurrentUrl());

		//accpet cookies
		lpage.acceptCookie();
		log("OK button clicked for <Agree-Cookie>");

		//Goto Menu Page
		AddressPopUp popup = lpage.clickShopMenuButton();
		log("Menu Button Clicked");		
		
		//Set Address
		MenuPage menu = popup.setAddress("Semperstraße 44, 1180 Wien, Austria");		
		Assert.assertTrue(menu.getCustomerAddress().contains("Semperstraße 44, 1180 Wien, Austria"));
		log("Added customer address is available in the address section");
		
		//Add Products, check product name and quanity after adding in cart
		menu.addProduct("Beef Baby Burrito");
		Assert.assertTrue(menu.isItemPresentInCart("Beef Baby Burrito"));
		Assert.assertEquals(menu.getItemQuantity("Beef Baby Burrito"), "1");
		log("Product "+"[Beef Baby Burrito]"+" added to the cart successfully");
		
		menu.addProduct("Cheesy Classic Quesadilla");
		Assert.assertTrue(menu.isItemPresentInCart("Cheesy Classic Quesadilla"));
		Assert.assertEquals(menu.getItemQuantity("Cheesy Classic Quesadilla"), "1");
		log("Product "+"[Cheesy Classic Quesadilla]"+" added to the cart successfully");
		
		menu.addProduct("Cheesy Classic Quesadilla");
		Assert.assertTrue(menu.isItemPresentInCart("Cheesy Classic Quesadilla"));
		Assert.assertEquals(menu.getItemQuantity("Cheesy Classic Quesadilla"), "2");
		log("Product "+"[Cheesy Classic Quesadilla]"+" added to the cart successfully");
		
		log("Add To Cart functionality - test validation complete");

	}
}


