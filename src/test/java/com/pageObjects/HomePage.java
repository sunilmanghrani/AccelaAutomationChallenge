package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {

	public HomePage	(WebDriver driver){
		super(driver);
	}
	
	@FindBy(how = How.ID, using = "search-field") 
	 WebElement txt_searchField;
	 
	 @FindBy(how = How.ID, using = "magnifier-search") 
	 WebElement btn_searchButton;
	 	 
	 @FindBy(how = How.ID, using = "product-price-current") 
	 WebElement label_productPrice;
	 
	 
	 public void EnterSearchText(String searchTerm){
		 
		 SendKeys(this.txt_searchField, "Search Field" , searchTerm);
	}
	 
	 public void ClickSearchButton(){
		Click(this.btn_searchButton, "Search Button");	
	}
	 
	 public void SelectProduct(String searchProduct){
         WebElement product = driver.findElement(
                 By.xpath("//div[@id='productlist-results']//div[text()='" + searchProduct + "']"));		 
		 Click(product, searchProduct);
	 }
}
