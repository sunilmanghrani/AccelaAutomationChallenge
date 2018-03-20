package com.pageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.apache.log4j.Logger;

import com.utils.CaptureScreenshot;

public class BasePage {
	
	final static Logger logger = Logger.getLogger(BasePage.class);
	CaptureScreenshot sc = new CaptureScreenshot(); 
	public static WebDriver driver;
	WebDriverWait wait;
	Alert alert;
	JavascriptExecutor js;
	Properties prop;
	
	public  BasePage(WebDriver driver12){
		driver = driver12;
		wait = new WebDriverWait(driver, 15);
		PageFactory.initElements(driver, this);
	}
	
	
	/**
	 * This method is to navigate to HomePage
	 * 
	 * @param none
	 * @returnType  void
	 * 
	 */	
	public void NavigateToHomePage()
	 {   
    String baseURL = GetPropValues("baseURL");

	 if(! baseURL.equalsIgnoreCase(null)){
		 driver.get(baseURL);
		 logger.info("Navigating to base url : " + baseURL);
	 }else{
		 logger.error("base url not found " + baseURL );
		 Assert.fail("base url not found " + baseURL );
	 }
	 }
	
	
	/**
	 * This method is to SendKeys to text field
	 * 
	 * @param WebElement, fieldName, textValue
	 * @returnType  void
	 * 
	 */
	public void SendKeys(WebElement elm, String fieldName, String textValue){
		try{
		elm.sendKeys(textValue);
		logger.info("Entered value in test field : " + fieldName + " ==>> "+ textValue);
		}
		catch(Exception exe){			
			logger.error("Unable to enter value in field : " + fieldName + " ==>> "+ textValue);
			logger.error("Exception occurs : " + exe);
			sc.caputureImage(System.getProperty("scenarioName"),fieldName);
			Assert.fail("Unable to enter value in field : " + fieldName+ " ==>> "+ textValue);
		}
		
	}
	
	/**
	 * This method is to click to web element
	 * 
	 * @param WebElement, elementName
	 * @returnType  void
	 * 
	 */
	public void Click(WebElement elm, String elementName){
		try{
		elm.click();
		logger.info("Clicked on element : " + elementName );
		}
		catch(Exception exe){			
			logger.error("Unable to click on element : " + elementName);
			logger.error("Exception occured : " + exe);
			sc.caputureImage(System.getProperty("scenarioName"),elementName);
			Assert.fail("Unable to click on element: " + elementName);
		}
	}
	
	/**
	 * This method is to select value from dropdown
	 * 
	 * @param WebElement, dropDownName and value to select
	 * @returnType  void
	 * 
	 */
	public void SelectDropDownByTextValue(WebElement elm, String dropDownName, String textValue){
		try{
			Select dropdown = new Select(elm);
			dropdown.selectByVisibleText(textValue);
			
			logger.info("Selected value from dropdown : " + dropDownName + " ==>> " + textValue);		
		}
		catch(Exception exe){			
			logger.error("Unable to select value from dropdown : " + dropDownName + " ==>> " + textValue);		
			logger.error("Exception occured : " + exe);
			sc.caputureImage(System.getProperty("scenarioName"),dropDownName);
			Assert.fail("Unable to select value from dropdown : " + dropDownName + " ==>> " + textValue);		
		}
	}
	
	
	/**
	 * This method is to verify the label visible text value
	 * 
	 * @param WebElement, Labeltype and expectedValue
	 * @returnType  void
	 * 
	 */
	public void VerifyLabelValue(WebElement elm, String Labeltype,  String expectedValue){
		try{
			 String actualText = elm.getText();
			 if(actualText.trim().equals(expectedValue.trim())){
				 logger.info("Assert Pass: " +Labeltype +" Actual value  : " + actualText + " is  equals to  " + expectedValue);									
			 }else{

				 logger.error("Assert fail : " +Labeltype +" Actual value  : " + actualText + " is not equals to  " + expectedValue);									
				 sc.caputureImage(System.getProperty("scenarioName"),Labeltype);
				 Assert.fail("Assert fail : " +Labeltype +" Actual value  : " + actualText + " is not equals to  " + expectedValue);												  
			 }

		 }catch(Exception exe){
			logger.error("Exception occured : " + exe);
			sc.caputureImage(System.getProperty("scenarioName"),Labeltype);
			Assert.fail("Exception occured : " + exe);		
		 }			
	}

	/**
	 * This method is to verify two string values
	 * 
	 * @param actualText, Labeltype and expectedValue
	 * @returnType  void
	 * 
	 */
	public void VerifyTextValues(String actualText, String Labeltype,  String expectedValue){
		try{
			 if(actualText.trim().equals(expectedValue.trim())){
				 logger.info("Assert Pass: " +Labeltype +" Actual value  : " + actualText + " is  equals to  " + expectedValue);									
			 }else{

				 logger.error("Assert fail : " +Labeltype +" Actual value  : " + actualText + " is not equals to  " + expectedValue);									
				 sc.caputureImage(System.getProperty("scenarioName"),Labeltype);
				 Assert.fail("Assert fail : " +Labeltype +" Actual value  : " + actualText + " is not equals to  " + expectedValue);												  
			 }

		 }catch(Exception exe){
			logger.error("Exception occured : " + exe);
			sc.caputureImage(System.getProperty("scenarioName"),Labeltype);
			Assert.fail("Exception occured : " + exe);		
		 }			
	}
	
	
	/**
	 * This method is to click on the visible button from the list of web elements
	 * 
	 * @param List of web elements and elementName
	 * @returnType  void
	 * 
	 */
	public void ClickToVisibleButtonFromWebElementList(List<WebElement> webElementList, String elementName ){
		Boolean flag = false;
		 for (WebElement webElement : webElementList) {
			 if(webElement.isDisplayed()&& webElement.isEnabled()){
				 webElement.click();
					logger.info("Clicked on element : " + elementName );
				 flag = true;
				 break;
			 }
		}
		 if(!flag){	 
			logger.error("Unable to click on element : " + elementName);
			sc.caputureImage(System.getProperty("scenarioName"),elementName);
			Assert.fail("Unable to click on element: " + elementName);
			}
	}
	
	/**
	 * This method is to sendkeys to the visible field from the list of web elements
	 * 
	 * @param List of web elements, fieldName and textValue
	 * @returnType  void
	 * 
	 */
	public void SendKeysToVisibleFieldFromWebElementList(List<WebElement> webElementList, String fieldName, String textValue ){
		Boolean flag = false;
		 for (WebElement webElement : webElementList) {
			 if(webElement.isDisplayed()&& webElement.isEnabled()){
				 webElement.sendKeys(textValue);
				 logger.info("Entered value in visible test field : " + fieldName + " ==>> "+ textValue);
				 flag = true;
				 break;
			 }
		}
		 if(!flag){
				logger.error("Unable to enter value in field : " + fieldName + " ==>> "+ textValue);
				sc.caputureImage(System.getProperty("scenarioName"),fieldName);
				Assert.fail("Unable to enter value in field : " + fieldName+ " ==>> "+ textValue); 
		 }
	}
	
	/**
	 * This method is to retrieve  the visible label from the list of web elements
	 * 
	 * @param List of web elements, elementName 
	 * @returnType  String of visible text
	 * 
	 */
	public String RetrieveVisibleLabelFromWebElementList(List<WebElement> webElementList, String elementName ){
		Boolean flag = false;
		String visibleText=null;
		 for (WebElement webElement : webElementList) {
			 if(webElement.isDisplayed()&& webElement.isEnabled()){
				 visibleText=webElement.getText();
					logger.info("Clicked on element : " + elementName );
				 flag = true;
				 break;
			 }
		}
		 if(!flag){	 
			logger.error("Unable to click on element : " + elementName);
			sc.caputureImage(System.getProperty("scenarioName"),elementName);
			Assert.fail("Unable to click on element: " + elementName);
			}
		return visibleText;
	}
	
	/**
	 * This method is to wait for the page load
	 * 
	 * @param none
	 * @returnType  none
	 * 
	 */ 
	 public void waitForPageLoaded() {
	        ExpectedCondition<Boolean> expectation = new
	                ExpectedCondition<Boolean>() {
	                    public Boolean apply(WebDriver driver) {
	                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
	                    }
	                };
	        try {
	            Thread.sleep(1000);
	            WebDriverWait wait = new WebDriverWait(driver, 30);
	            wait.until(expectation);
	            logger.info("Wait for page load");
	        } catch (Throwable exe) {
	        	logger.error("Timeout waiting for Page Load Request to complete." + exe);
	            Assert.fail("Timeout waiting for Page Load Request to complete.");
	        }
	    }
	 
		/**
		 * This method is to accept alert
		 * 
		 * @param none
		 * @returnType  none
		 * 
		 */
	 public void AcceptDialogBox(){
		 try { 
			 ImplictWait(driver, 3000);
		 alert = driver.switchTo().alert();
		 alert.accept();
		 logger.info("Pop up alert is accepted");									
		 } catch (Throwable exe) {
	        	logger.error("Pop up alert is not accepted");
	            Assert.fail("Pop up alert is not accepted");
	        } 
	 }
	 
		/**
		 * This method is to scroll screen
		 * 
		 * @param none
		 * @returnType  none
		 * 
		 */
	 public void ScreenScroll(){
		 try{
		 js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,200)");
		 logger.info("Screen scrolled");
		 }
		 catch (Throwable exe) {
	        	logger.error("Unable to scroll screen");
	      } 
	 }
		
		/**
		 * This method is to wait for object to be appear
		 * 
		 * @param locator, element id
		 * @returnType  none
		 * 
		 */
		public void WaitForObjectAppears(String locator, By Id){

			switch (locator) {
	        case "id":  
	        	wait.until(ExpectedConditions.visibilityOfElementLocated(Id));		
	        	break;
	        case "xpath":  
	        	wait.until(ExpectedConditions.visibilityOfElementLocated(Id));		
	        	break;
			}
		}
		
		/**
		 * This method is to wait implicitly
		 * 
		 * @param WebDriver, time
		 * @returnType  none
		 * 
		 */
		public void ImplictWait(WebDriver d, long time){
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//d.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		}
		
		/**
		 * This method is to retrieve property value by keys
		 * 
		 * @param key
		 * @returnType  value
		 * 
		 */
		public String GetPropValues(String key){
			Properties prop = new Properties();
			InputStream input = null;
			String propValue =null;

			try {

				input = new FileInputStream("config.properties");

				// load a properties file
				prop.load(input);

				// get the property value
				 propValue = prop.getProperty(key);

				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			return propValue;
		}
}
