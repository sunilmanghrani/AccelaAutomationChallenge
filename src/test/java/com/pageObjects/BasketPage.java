package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BasketPage extends BasePage {

	public BasketPage	(WebDriver driver){
		super(driver);
	}
	String locatorId;
	String locator;
	
	 @FindBy(how = How.XPATH, using = "//textarea[@class='form-control ng-pristine ng-untouched ng-valid ng-valid-maxlines']") 
	 WebElement txtarea_message;
	 
	 @FindBy(how = How.XPATH, using = "//input[@value='evoucher']") 
	 WebElement rdo_eVoucherPayment;
	 
	 @FindBy(how = How.XPATH, using = "//input[@value='giftpack']") 
	 WebElement rdo_GiftPackPayment;
			 
	 @FindBy(how = How.XPATH, using = "//input[@value='standard']") 
	 WebElement rdo_standardPayment;
	 
	 @FindBy(how = How.XPATH, using = "//div[@class='packaging_totals ng-scope']/span[2]") 
	 WebElement label_packagingPrice;
	 
	 @FindBy(how = How.XPATH, using = "//div[@class='delivery_totals']/span[2]") 
	 WebElement label_deiveryPrice;
	 
	 @FindBy(how = How.XPATH, using = "//div[@class='row final_totals']/span[2]") 
	 WebElement label_productPrice;
	 
	 @FindBy(how = How.XPATH, using = "//button[@class='btn dropdown-toggle buynow pay-secure-now-bottom']") 
	 WebElement btn_payNow;
	 
	 public void AddPersonalizedMessage(String msg){
			SendKeys(this.txtarea_message, "Personal Message", msg);
	}
	 
	 public void SelectPackagingOption(String packOption){
		 
			switch (packOption) {
	        case "eVoucher":  
	        	Click(this.rdo_eVoucherPayment, "eVoucher Payment");		
	        	break;
	        case "giftpack":
	        	Click(this.rdo_GiftPackPayment, "GiftPack Payment");		
	        	break;
	        case "standard": 
	        	Click(this.rdo_standardPayment, "Standard Payment");		
	        	break;		 
			}
	 }
	 
	 public void VerifyPackagingPrice(String packagingPrice){
		 VerifyLabelValue(this.label_packagingPrice, "PackagingPrice", packagingPrice);		 
	 }
	 
	 public void VerifyDeliveryPrice(String deliveryPrice){
		 VerifyLabelValue(this.label_deiveryPrice, "DeliveryPrice", deliveryPrice);
	 	 }
	 
	 public void VerifyProductPrice(String productPrice){
		 
		 ScreenScroll();
		 VerifyLabelValue(this.label_productPrice, "ProductPrice", productPrice);		 
	 }
	 
	 public void ClickPayNowButton(){		 
		 Click(this.btn_payNow, "payNow");
	 }
}
