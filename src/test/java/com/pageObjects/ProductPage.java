package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductPage extends BasePage {

	public ProductPage	(WebDriver driver){
		super(driver);
	}
	
	 @FindBy(how = How.ID, using = "product-price-current") 
	 WebElement label_productPrice;
	 
	 @FindBy(how = How.XPATH, using = "//button[@class='btn btn-transactional top']") 
	 WebElement btn_buyProduct;
	 	 
	 public void VerifyProductPrice(String productPrice){
		 ImplictWait(driver, 3000);
		 VerifyLabelValue(this.label_productPrice, "Product Price", productPrice); 
	}
		 
	 public void ClickOnBuyNow(){
		 ImplictWait(driver, 3000);
		 Click(this.btn_buyProduct, "BuyNow");	
	}
}
