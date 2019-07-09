package com.hfc.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;
import com.main.utils.Config;
import com.main.utils.DriverManager;
import com.main.utils.Global;

public class MenuPage extends BasePage {


	private static Logger LOGGER = LogManager.getLogger(MenuPage.class);
	private static void log(String logs)
	{
		LOGGER.info(logs);
		testLevelReport().get().log(Status.INFO, "<b>" + logs + "</b>");
	}


	@FindBy(xpath = "//a[contains(@class,'logo') and @title='Mamacita']")
	private WebElement oLinkMamacita;


	@FindBy(id = "customer_address")
	private WebElement oTextCustomerAddress;

	@FindBy(xpath = "//a[@class='product--title']")
	private List<WebElement> oTextProductName;

	@FindBy(xpath = "//a[@class='product--title']/../preceding-sibling::div//button")
	private List<WebElement> oButtonProductNameImageLink;

	@FindBy(id = "topup-modal--close")
	private WebElement oButtonCloseTopUpModal;
	
	@FindBy(xpath = "//div[@class='cart--item']//span[@class='item--name']")
	private List<WebElement> oTextCartItems;
	
	@FindBy(xpath = "//div[@class='cart--item']//span[@class='item--name']/preceding-sibling::span[@class='item--quantity']")
	private List<WebElement> oTextCartItemsQuantity;
	
	@FindBy(xpath = "//a[contains(@class,'checkout')]")
	private WebElement oButtonCheckOut;
	
	
	

	public String getCustomerAddress() {

		Global.sleep(5);
		return oTextCustomerAddress.getAttribute("innerText");
	}

	public MenuPage addProduct(String input) throws Exception {

		boolean isProductClicked = false;

		for(int i=0;i<oTextProductName.size();i++) {

			Global.sleep(2);
			if(oTextProductName.get(i).getAttribute("title").equalsIgnoreCase(input))
			{
				log("Product found - "+input);
				Global.sleep(2);
				oButtonProductNameImageLink.get(i).click();
				log("Product is selected");
				oButtonCloseTopUpModal.click();
				isProductClicked=true;
				break;
			}

		}

		if(!isProductClicked)
			throw new Exception("Incorrect Product name or Product not available!!!");


		return (MenuPage) openPage(MenuPage.class);
	}

	public boolean isItemPresentInCart(String item) {

		Global.sleep(3);
		for(WebElement cartItem : oTextCartItems) {
			
			if(cartItem.getAttribute("innerText").equalsIgnoreCase(item)) {
				log("Item is present in cart");
				return true;
			}
		}
		
		log("Item is not present in cart");
		return false;
	}
	
	public String getItemQuantity(String item) throws Exception {
		
		boolean isItemPresent = false;
		Global.sleep(3);
		for(int i=0;i<oTextCartItems.size();i++) {
			
			if(oTextCartItems.get(i).getAttribute("innerText").equalsIgnoreCase(item)) {
				isItemPresent=true;
				return oTextCartItemsQuantity.get(i).getAttribute("innerText").replace("x", "");
			}
		}
		
		if(!isItemPresent)
			throw new Exception("Item is not present in cart");
		
		return null;
		
		
	}


	@Override
	public ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(oLinkMamacita);
	}

}
