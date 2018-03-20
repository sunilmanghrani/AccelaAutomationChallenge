package com.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CheckoutPage extends BasePage {

	public CheckoutPage	(WebDriver driver){
		super(driver);
	}

	 @FindBy(how = How.ID, using = "account_email_field") 
	 WebElement txt_email;	 
	 @FindBy(how = How.XPATH, using = "//button[@class='btn login_guest chk_btns ng-binding']") 
	 WebElement btn_ContinueAsGuest;	 
	 @FindBy(how = How.ID, using = "titlefield") 
	 WebElement lst_titlefield;
	 @FindBy(how = How.ID, using = "firstnamefield") 
	 WebElement txt_firstname;
	 @FindBy(how = How.ID, using = "lastnamefield")
	 WebElement txt_lastname;
	 @FindBy(how = How.ID, using = "telephonenumberfield") 
	 WebElement txt_telephonenumber;
	 @FindBy(how = How.ID, using = "//select[@class='form-control ng-pristine ng-valid ng-touched']") 
	 WebElement lst_selectAddress;
	 @FindBy(how = How.ID, using = "cardholdername") 
	 WebElement txt_cardholdername;
	 @FindBy(how = How.ID, using = "cardnumber") 
	 WebElement txt_cardnumber;
	 @FindBy(how = How.ID, using = "expirymonth") 
	 WebElement lst_expirymonth;
	 @FindBy(how = How.ID, using = "expiryyear") 
	 WebElement lst_expiryyear;
	 @FindBy(how = How.ID, using = "startmonth") 
	 WebElement lst_startmonth;
	 @FindBy(how = How.ID, using = "startyear") 
	 WebElement lst_startyear;
	 @FindBy(how = How.ID, using = "issuenumber") 
	 WebElement txt_issuenumber;
	 @FindBy(how = How.ID, using = "cvvnumber") 
	 WebElement txt_cvvnumber;
	 @FindBy(how = How.ID, using = "btnPlaceOrderButton")
	 WebElement btn_PlaceOrderButton;

	 @FindBy(how = How.XPATH, using = "//div[@class='continue_area_buttons']/button")
	 List<WebElement> btn_searchAddress;
	 
	 @FindBy(how = How.XPATH, using = "//input[@name='PostCode']")
	 List<WebElement> txt_Postcode;
	 
	 @FindBy(how = How.XPATH, using = "//input[@ng-model='FlowData.PostCodeSearchForm.HouseNumber']")
	 List<WebElement> txt_Address1;

	 @FindBy(how = How.XPATH, using = "//button[@class='btn login_continue chk_btns pull-right ng-binding']")
	 List<WebElement> btn_login_continue;
	 
	 @FindBy(how = How.XPATH, using = "//section[@id='chk_step3']/div/span")
	 List<WebElement> label_errorMsg;
	 
	 
	 public void EnterEmailText(String email) {
			
		 this.txt_email.sendKeys(email);
	}
	 
	 public void ClickOnContinueAsGuest(){
		 this.btn_ContinueAsGuest.click();
		 ImplictWait(driver, 2000);
	 }
	 
	 public void EnterCustomerDetails(String title, String firstname, String lastName, String telephoneNumber){
		 
		 SelectDropDownByTextValue(this.lst_titlefield, "title",title ); 	 
		 SendKeys(this.txt_firstname, "First Name", firstname);
		 SendKeys(this.txt_lastname, "Last Name", lastName);
		 SendKeys(this.txt_telephonenumber, "telephonenumber", telephoneNumber);
		 //Click(this.btn_login_continue, "login_continue");	
		 ClickToVisibleButtonFromWebElementList(btn_login_continue,"login_continue");
	 }

	 public void EnterAddressDetails(String address1, String postCode){
		 		 
		 SendKeysToVisibleFieldFromWebElementList(txt_Address1, "Address1", address1);
		 SendKeysToVisibleFieldFromWebElementList(txt_Postcode, "Postcode", postCode);
		 ImplictWait(driver, 3000);
		 ClickToVisibleButtonFromWebElementList(btn_searchAddress,"Search Address");
		 ImplictWait(driver, 2000);
		 //ClickToVisibleButtonFromWebElementList(btn_searchAddress,"Search Address");
	 }
	 
	 public void EnterPaymentDetails(String cardholderName, String cardNumber, String issueNumber , String cvvNumber, String expirymonth, String expiryyear, String startmonth,  String startyear){
		 SendKeys(this.txt_cardholdername, "Cardholder Name", cardholderName);
		 SendKeys(this.txt_cardnumber, "Card Number", cardNumber);
		 SendKeys(this.txt_issuenumber, "Issue Number", issueNumber);
		 SendKeys(this.txt_cvvnumber, "CVV number", cvvNumber);

		SelectDropDownByTextValue(this.lst_expirymonth, "expirymonth", expirymonth); 
		SelectDropDownByTextValue(this.lst_expiryyear, "expiryyear", expiryyear); 
		SelectDropDownByTextValue(this.lst_startmonth, "startmonth", startmonth); 
		SelectDropDownByTextValue(this.lst_startyear, "startyear", startyear); 
	 }
	 
	 public void ClickCheckoutButton(){
		 ImplictWait(driver, 3000);		 
		 Click(this.btn_PlaceOrderButton, "PlaceOrderButton");
	 }
	 
	 public void VerifyErrorMessage(String expected_errormsg){
		 String actual_errormsg = RetrieveVisibleLabelFromWebElementList(label_errorMsg, "error_msg");
		 VerifyTextValues(actual_errormsg, "error_msg", expected_errormsg);
	 }
 }
