package com.stepDefinations;

import com.pageObjects.BasketPage;
import com.pageObjects.CheckoutPage;
import com.pageObjects.HomePage;
import com.pageObjects.ProductPage;
import com.testData.CustomerDeliveryDetail;
import com.testData.CustomerDetails;
import com.testData.CustomerPaymentDetail;

import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CheckoutSteps {
    
	HomePage homePage;
	ProductPage productPage;
	BasketPage basketPage;
	CheckoutPage checkoutPage;
	Scenario scenario;
	CustomerDetails customerDeatils;
	CustomerDeliveryDetail customerDeliveryDetail;
	CustomerPaymentDetail customerPaymentDetail;
	
	public CheckoutSteps()
	{
		homePage = new HomePage(StepContext.driver);
		productPage = new ProductPage(StepContext.driver);
		basketPage = new BasketPage(StepContext.driver);
		checkoutPage = new CheckoutPage(StepContext.driver);
		/***Note : For this  test, customer data is hard coded, though it is not good practice to hard code data */
		customerDeatils = new CustomerDetails("1", "aaa@gmail.com", "Mr.", "test", "user", "1234567890");
		customerDeliveryDetail = new CustomerDeliveryDetail("1", "121", "RG1 3ES");
		customerPaymentDetail = new CustomerPaymentDetail("1", "test", "1234123412341234", "1", "2020", "1", "2016", "123", "123");
	}

	@Given("^I am at Home Page$")
	public void i_am_at_Home_Page(){
		homePage.NavigateToHomePage();
		homePage.waitForPageLoaded();
	}
	
	@Given("^I have a \"(.*?)\" added in bag$") 
	public void i_have_a_Product_added_in_bag(String Product){
		homePage.NavigateToHomePage();
		homePage.waitForPageLoaded();
		homePage.EnterSearchText(Product);
		homePage.ClickSearchButton();
		homePage.waitForPageLoaded();
		homePage.SelectProduct(Product);
		homePage.waitForPageLoaded();
		productPage.ClickOnBuyNow();
		productPage.waitForPageLoaded();
	}
	
	@When("^I search a \"(.*?)\"$") 
	public void i_search_a_Product(String Product){
		homePage.EnterSearchText(Product);
		homePage.ClickSearchButton();
		homePage.waitForPageLoaded();
	}
	
	@When("^I select a \"(.*?)\"$") 
	public void i_select_a_Product(String Product){
		homePage.SelectProduct(Product);
		homePage.waitForPageLoaded();
	}
	
	@When("^The correct \"(.*?)\" is displayed on the product page$")
	public void the_correct_is_displayed_on_the_product_page(String productPrice){
		productPage.VerifyProductPrice(productPrice);
	}

	@When("^I add the product to basket$")
	public void i_add_the_product_to_basket(){
		productPage.ClickOnBuyNow();
		productPage.waitForPageLoaded();
	}
	
	@When("^I add a \"(.*?)\" to the product in the basket$")
	public void i_add_a_Gift_message_to_the_product_in_the_basket(String  message){
		productPage.waitForPageLoaded();
		basketPage.AddPersonalizedMessage(message);
	}

	@And("^I select a \"(.*?)\" method$")
	public void i_select_a_packaging_method(String packOption){
		basketPage.SelectPackagingOption(packOption);
		basketPage.waitForPageLoaded();
	}
	
	@And("^Delivery \"(.*?)\" is applied$")
	public void delivery_is_applied(String deliveryPrice){
		basketPage.VerifyDeliveryPrice(deliveryPrice);
	}

	@And("^Packaging \"(.*?)\" is applied$")
	public void packaging_is_applied(String packagingPrice){
		basketPage.VerifyPackagingPrice(packagingPrice);
	}
	
	@When("^The correct \"(.*?)\" is displayed on the basket page$")
	public void the_correct_is_displayed_on_the_basket_page(String productPrice){
		basketPage.VerifyProductPrice(productPrice);
	}
	
	@When("^Proceed to checkout page$")
	public void proceedCheckout(){
		basketPage.ClickPayNowButton();
		basketPage.AcceptDialogBox();
		basketPage.waitForPageLoaded();
	}
	
	@And("^Entered Customer details at checkout page$")
	public void enteredCustomerDetailsAtCheckoutPage(){
		checkoutPage.EnterEmailText(customerDeatils.email);
		checkoutPage.ClickOnContinueAsGuest();
		checkoutPage.waitForPageLoaded();
		checkoutPage.EnterCustomerDetails(customerDeatils.title, 
											customerDeatils.firstname, 
											customerDeatils.lastname, 
											customerDeatils.telephonenumber);

		checkoutPage.waitForPageLoaded();
	}
	
	@And("^Entered delivery details at checkout page$")
	public void enteredDeliveryDetailsAtCheckoutPage(){
		checkoutPage.EnterAddressDetails(customerDeliveryDetail.address1,
				customerDeliveryDetail.PostCode);

		checkoutPage.waitForPageLoaded();
	}
	
	@And("^Entered incorrect payment details and checkout$")
	public void enteredIncorrectPaymentDetailsAtCheckoutPage(){
		checkoutPage.EnterPaymentDetails(customerPaymentDetail.cardholdername,
				customerPaymentDetail.cardnumber,
				customerPaymentDetail.issuenumber,
				customerPaymentDetail.cvvnumber,
				customerPaymentDetail.expirymonth,
				customerPaymentDetail.expiryyear,
				customerPaymentDetail.startmonth,
				customerPaymentDetail.startyear);
		checkoutPage.waitForPageLoaded();
		checkoutPage.ClickCheckoutButton();
		checkoutPage.waitForPageLoaded();
	}
	
	@Then("^Error message \"(.*?)\" is displayed at checkout Page$")
	public void verify_error(String error_msg){
		checkoutPage.VerifyErrorMessage(error_msg);
	}
}
